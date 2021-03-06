package com.hga.appturismo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.calendar.DatePickerFragment;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EditarActivity extends AppCompatActivity {
    protected String mCurrentPhotoPath = "";
    protected String mCurrentAbsolutePhotoPath = "";

    protected TurismoAplicacion app;
    protected DatabaseReference databaseReference;
    protected StorageReference storageReference;

    protected Spinner editar_spinner_tipo;//seleccion entre: hotel,restaurante,lugar turistico
    protected Spinner editar_spinner_subtipo;
    protected Spinner editar_spinner_provincia;

    protected EditText editar_txt_nombre;
    protected EditText editar_txt_actividad;
    protected EditText editar_txt_descripcion;
    protected EditText editar_txt_email;
    protected EditText editar_txt_direccion;
    protected EditText editar_txt_paginaweb;
    protected EditText editar_txt_telefono;
    protected EditText editar_txt_horario;
    protected EditText editar_txt_latitud;
    protected EditText editar_txt_longitud;
    protected EditText editar_txt_linea;
    protected TextView editar_txt_fecha;

    protected Button editar_btn_imagen_capturar;
    protected Button editar_btn_guardar;//guardar
    protected Button editar_btn_imagen_buscar;
    protected TextView editar_txt_ruta_imagen;//ruta de la imagen
    protected ImageView imageView;//imagen capturada

    protected FloatingActionButton btn_editar;

    protected LinearLayout editar_layout_tipo;
    protected LinearLayout editar_layout_subtipo;
    protected LinearLayout editar_layout_provincia;
    protected LinearLayout editar_layout_nombre;
    protected LinearLayout editar_layout_actividad;
    protected LinearLayout editar_layout_descripcion;
    protected LinearLayout editar_layout_email;
    protected LinearLayout editar_layout_direccion;
    protected LinearLayout editar_layout_pagina_web;
    protected LinearLayout editar_layout_telefono;
    protected LinearLayout editar_layout_horario;
    protected LinearLayout editar_layout_latitud;
    protected LinearLayout editar_layout_longitud;
    protected LinearLayout editar_layout_imagen;
    protected LinearLayout editar_layout_linea;
    protected LinearLayout editar_layout_fecha;
    protected View focusView = null;

    protected DatePickerFragment datePickerFragmentIn;
    protected Calendar calendarDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_lugar);

        app = (TurismoAplicacion) getApplicationContext();
    }

    /**
     * despues de  tomar la foto con la camara muestra la imagen tomada con la camara en el activity *
     *
     * @param requestCode:
     * @param resultCode:
     * @param data:
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == InsertarLugarActivity.REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            editar_txt_ruta_imagen.setText(mCurrentPhotoPath);
            Picasso.with(this).load(mCurrentPhotoPath).into(imageView);
            addPictureToGalery();
        }
        if (requestCode == InsertarLugarActivity.SELECT_PICTURE && resultCode == Activity.RESULT_OK) {

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};//Array size of 1, and we put in a string

            assert selectedImage != null;
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            mCurrentAbsolutePhotoPath = cursor.getString(columnIndex);//here we have our image path.
            mCurrentPhotoPath = "file:" + cursor.getString(columnIndex);//here we have our image path.

            cursor.close();

            editar_txt_ruta_imagen.setText(mCurrentPhotoPath);
            Picasso.with(this).load(selectedImage).into(imageView);
        }
    }

    protected void iniciarVista() {
        editar_layout_tipo = findViewById(R.id.editar_layout_tipo);
        editar_spinner_tipo = findViewById(R.id.editar_spinner_tipo);

        editar_layout_subtipo = findViewById(R.id.editar_layout_subtipo);
        editar_spinner_subtipo = findViewById(R.id.editar_spinner_subtipo);

        editar_layout_provincia = findViewById(R.id.editar_layout_provincia);
        editar_spinner_provincia = findViewById(R.id.editar_spinner_provincia);

        editar_layout_nombre = findViewById(R.id.editar_layout_nombre);
        editar_txt_nombre = findViewById(R.id.editar_txt_nombre);

        editar_layout_actividad = findViewById(R.id.editar_layout_actividad);
        editar_txt_actividad = findViewById(R.id.editar_txt_actividad);

        editar_layout_descripcion = findViewById(R.id.editar_layout_descripcion);
        editar_txt_descripcion = findViewById(R.id.editar_txt_descripcion);

        editar_layout_email = findViewById(R.id.editar_layout_email);
        editar_txt_email = findViewById(R.id.editar_txt_email);

        editar_layout_direccion = findViewById(R.id.editar_layout_direccion);
        editar_txt_direccion = findViewById(R.id.editar_txt_direccion);

        editar_layout_pagina_web = findViewById(R.id.editar_layout_pagina_web);
        editar_txt_paginaweb = findViewById(R.id.editar_txt_paginaweb);

        editar_layout_telefono = findViewById(R.id.editar_layout_telefono);
        editar_txt_telefono = findViewById(R.id.editar_txt_telefono);

        editar_layout_horario = findViewById(R.id.editar_layout_horario);
        editar_txt_horario = findViewById(R.id.editar_txt_horario);

        editar_layout_latitud = findViewById(R.id.editar_layout_latitud);
        editar_txt_latitud = findViewById(R.id.editar_txt_latitud);

        editar_layout_longitud = findViewById(R.id.editar_layout_longitud);
        editar_txt_longitud = findViewById(R.id.editar_txt_longitud);

        editar_layout_linea = findViewById(R.id.editar_layout_linea);
        editar_txt_linea = findViewById(R.id.editar_txt_linea);

        editar_layout_fecha = findViewById(R.id.editar_layout_fecha);
        editar_txt_fecha = findViewById(R.id.editar_txt_fecha);

        editar_layout_imagen = findViewById(R.id.editar_layout_imagen);
        editar_txt_ruta_imagen = findViewById(R.id.editar_ruta_imagen);
        imageView = findViewById(R.id.editar_insertar_imagen);
        editar_btn_imagen_capturar = findViewById(R.id.editar_btn_imagen_capturar);
        editar_btn_imagen_buscar = findViewById(R.id.editar_btn_imagen_buscar);

        datePickerFragmentIn = new DatePickerFragment();
        datePickerFragmentIn.setTextView(editar_txt_fecha, editar_txt_fecha, calendarDate);

        editar_btn_guardar = findViewById(R.id.editar_btn_insertar);
    }

    /**
     * agregar los valores de los spinner en el activity insertar
     * -spinner provincia(cercado, quillacollo,etc)
     * -spinner tipo lugar(arquitectonico, etc..)
     * -spinner tipo insercion(modeloHotelOld, restarutanre, lugar turistico)
     */
    protected void iniciarVistaSpinner(int seleccion) {
        onClickSpinnerTipo(seleccion);
        onClickSpinnerSubtipo();
        onClickSpinnerProvincia();
    }

    private void onClickSpinnerTipo(int seleccion) {
        ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(this, R.array.tipo_insercion, android.R.layout.simple_spinner_item);
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editar_spinner_tipo.setAdapter(adapterTipo);
        editar_spinner_tipo.setSelection(seleccion);
        editar_spinner_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setVisibleTipoLugar(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void onClickSpinnerSubtipo() {
        ArrayAdapter<CharSequence> adapterSubTipoTurismo = ArrayAdapter.createFromResource(this, R.array.subtipo_turismo, android.R.layout.simple_spinner_item);
        adapterSubTipoTurismo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editar_spinner_subtipo.setAdapter(adapterSubTipoTurismo);
        editar_spinner_subtipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setVisibleTipoLugar(Constants.SELECT_LUGAR);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void onClickSpinnerProvincia() {
        ArrayAdapter<CharSequence> adapterProvincia = ArrayAdapter.createFromResource(this, R.array.provincia, android.R.layout.simple_spinner_item);
        adapterProvincia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editar_spinner_provincia.setAdapter(adapterProvincia);
    }

    private void setVisibleTipoLugar(int position) {
        switch (position) {
            case 0://modeloHotelOld
                editar_layout_tipo.setVisibility(View.VISIBLE);
                editar_layout_subtipo.setVisibility(View.GONE);
                editar_layout_provincia.setVisibility(View.GONE);
                editar_layout_nombre.setVisibility(View.VISIBLE);
                editar_layout_email.setVisibility(View.VISIBLE);
                editar_layout_direccion.setVisibility(View.VISIBLE);
                editar_layout_pagina_web.setVisibility(View.VISIBLE);
                editar_layout_telefono.setVisibility(View.VISIBLE);
                editar_layout_horario.setVisibility(View.VISIBLE);
                editar_layout_latitud.setVisibility(View.VISIBLE);
                editar_layout_longitud.setVisibility(View.VISIBLE);
                editar_layout_imagen.setVisibility(View.VISIBLE);
                editar_layout_linea.setVisibility(View.VISIBLE);
                editar_layout_fecha.setVisibility(View.GONE);
            case 1://modeloRestauranteOld
                editar_layout_tipo.setVisibility(View.VISIBLE);
                editar_layout_provincia.setVisibility(View.GONE);
                editar_layout_subtipo.setVisibility(View.GONE);
                editar_layout_nombre.setVisibility(View.VISIBLE);
                editar_layout_email.setVisibility(View.VISIBLE);
                editar_layout_direccion.setVisibility(View.VISIBLE);
                editar_layout_pagina_web.setVisibility(View.VISIBLE);
                editar_layout_telefono.setVisibility(View.VISIBLE);
                editar_layout_horario.setVisibility(View.VISIBLE);
                editar_layout_latitud.setVisibility(View.VISIBLE);
                editar_layout_longitud.setVisibility(View.VISIBLE);
                editar_layout_imagen.setVisibility(View.VISIBLE);
                editar_layout_linea.setVisibility(View.VISIBLE);
                editar_layout_fecha.setVisibility(View.GONE);
                break;
            case 2://lugar turistico
                editar_layout_tipo.setVisibility(View.VISIBLE);
                editar_layout_provincia.setVisibility(View.VISIBLE);
                editar_layout_subtipo.setVisibility(View.VISIBLE);
                editar_layout_nombre.setVisibility(View.VISIBLE);
                editar_layout_descripcion.setVisibility(View.VISIBLE);
                editar_layout_actividad.setVisibility(View.GONE);
                editar_layout_email.setVisibility(View.GONE);
                editar_layout_direccion.setVisibility(View.VISIBLE);
                editar_layout_pagina_web.setVisibility(View.VISIBLE);
                editar_layout_telefono.setVisibility(View.VISIBLE);
                editar_layout_horario.setVisibility(View.VISIBLE);
                editar_layout_latitud.setVisibility(View.VISIBLE);
                editar_layout_longitud.setVisibility(View.VISIBLE);
                editar_layout_imagen.setVisibility(View.VISIBLE);
                editar_layout_linea.setVisibility(View.VISIBLE);

                String positionTipo=editar_spinner_subtipo.getSelectedItem().toString();
                if (positionTipo.equals(Constants.TIPO_LUGAR_ACONTECIMIENTOS))
                    editar_layout_fecha.setVisibility(View.VISIBLE);
                else
                    editar_layout_fecha.setVisibility(View.GONE);
                break;
        }
    }

    @NonNull
    protected ArrayList<ModeloImagen> getModeloImagens(String tipo, int id, String ruta, ArrayList<ModeloImagen> imagenes) {
        ArrayList<ModeloImagen> modeloImagenArrayList = new ArrayList<>();

        if (!mCurrentPhotoPath.isEmpty()) {
            ModeloImagen modeloImagen = new ModeloImagen();
            modeloImagen.setIdSqlite(0);
            modeloImagen.setIdLugarReference(id);
            modeloImagen.setIdImagen(1);
            modeloImagen.setTipoImagen(tipo);
            modeloImagen.setUrlApp(editar_txt_ruta_imagen.getText().toString());
            Uri uri;
            try {
                uri = Uri.fromFile(new File(mCurrentAbsolutePhotoPath));
            } catch (NullPointerException e) {
                uri = Uri.fromFile(new File(mCurrentPhotoPath));
            }
            modeloImagen.setUrlServer(ruta + uri.getLastPathSegment());
            modeloImagenArrayList.add(modeloImagen);
        } else {
            modeloImagenArrayList = imagenes;
        }
        return modeloImagenArrayList;
    }

    /**
     * comvertir la ruta de bdFirebase para usarlo...
     *
     * @param urlFirebase: ruta de la ruta en bdFirebase
     * @return DatabaseReference:direccion de la ruta bdFirebase en formato bdFirebase
     */
    protected DatabaseReference getPostReferenceProvincia(String urlFirebase, String provincia) {
        DatabaseReference postReference=null;

        String[] arrayTipo = getResources().getStringArray(R.array.provincia);
        for (String provinciaLugar : arrayTipo) {
            if (provincia.equals(provinciaLugar)) {
                postReference = app.getDataBaseReferenceLugarTuristico(provinciaLugar+"/" + urlFirebase);
                break;
            }
        }

        return postReference;
    }

    protected int getSelectedArray(String tipo, int idArray) {
        int res=-1;
        String[] arrayTipo = getResources().getStringArray(idArray);
        for (int i=0;i<arrayTipo.length;i++){
            if (tipo.equals(arrayTipo[i])){
                res=i;
                break;
            }
        }
        return res;
    }

    /**
     * permite cambiar imagen de perfil
     */
    public void goCameraActivity(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(this.getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (photoFile != null) {
                Uri photoUri = FileProvider.getUriForFile(this, "com.hga.appturismo", photoFile);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, InsertarLugarActivity.REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    /**
     * guardar las imagenes de perfil capturadas
     *
     * @return File: imagen guardada en el smarthphone
     */
    private File createImageFile() throws IOException {
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFilename = "JPEG_" + timeStamp + "_";
        File storageDir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(imageFilename, ".jpg", storageDir);
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();

        mCurrentAbsolutePhotoPath = image.getAbsolutePath();
        Picasso.with(this).load(mCurrentAbsolutePhotoPath).into(imageView);
        return image;
    }

    public void goGaleryActivity(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, InsertarLugarActivity.SELECT_PICTURE);
    }

    /**
     * guarda la imagen tomada con la camara en el activity en el celular
     */
    protected void addPictureToGalery() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File newFile = new File(mCurrentPhotoPath);

        Uri contentUri = Uri.fromFile(newFile);
        intent.setData(contentUri);
        this.sendBroadcast(intent);
    }

    public void showDatePickerDialog(View v) {
        datePickerFragmentIn.show(getFragmentManager(), "datePicker");
    }
}
