package com.hga.appturismo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.bdSQLite.SqliteHotel;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.bdSQLite.SqliteRestaurante;
import com.hga.appturismo.calendar.DatePickerFragment;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InsertarLugarActivity extends AppCompatActivity {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static int SELECT_PICTURE = 3;
    private String email;
    private ImageView imageView;
    private String mCurrentPhotoPath;
    private String mCurrentAbsolutePhotoPath;
    private TextView txt_ruta_imagen;
    private TurismoAplicacion app;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    private EditText txt_nombre;
    private EditText txt_actividad;
    private EditText txt_descripcion;
    private EditText txt_telefono;
    private EditText txt_horario;
    private EditText txt_latitud;
    private EditText txt_longitud;
    private EditText txt_direccion;
    private EditText txt_paginaweb;
    private EditText txt_email;
    private EditText txt_linea;
    private TextView txt_fecha;
    private EditText txt_registrador;

    private Spinner spinnerProvincia;
    private Spinner spinnerCategoria;
    private Spinner spinnerTipo;

    private LinearLayout layout_tipo;
    private LinearLayout layout_provincia;
    private LinearLayout layout_tipoTurismo;
    private LinearLayout layout_nombre;
    private LinearLayout layout_actividad;
    private LinearLayout layout_descripcion;
    private LinearLayout layout_email;
    private LinearLayout layout_direccion;
    private LinearLayout layout_pagina_web;
    private LinearLayout layout_telefono;
    private LinearLayout layout_horario;
    private LinearLayout layout_latitud;
    private LinearLayout layout_longitud;
    private LinearLayout layout_imagen;
    private LinearLayout layout_linea;
    private LinearLayout layout_fecha;
    private LinearLayout layout_registrador;

    private View focusView = null;

    private DatePickerFragment datePickerFragmentIn;
    private Calendar calendarDate;

    /**
     * despues de  tomar la foto con la camara muestra la imagen tomada con la camara en el activity *
     *
     * @param requestCode:
     * @param resultCode:
     * @param data:
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            txt_ruta_imagen.setText(mCurrentPhotoPath);
            Picasso.with(this).load(mCurrentPhotoPath).into(imageView);
            addPictureToGalery();
        }
        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK) {

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};//Array size of 1, and we put in a string
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            mCurrentAbsolutePhotoPath = cursor.getString(columnIndex);//here we have our image path.
            mCurrentPhotoPath = "file:" + cursor.getString(columnIndex);//here we have our image path.

            cursor.close();

            txt_ruta_imagen.setText(mCurrentPhotoPath);
            Picasso.with(this).load(selectedImage).into(imageView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_lugar);

        app = (TurismoAplicacion) getApplicationContext();
        getEmail();
        iniciarValores();
        iniciarLayout();
        showImageCamera();
        initSpinnerTipoLugar();
        initSpinnerProvincia();
        initSpinnerCategoria();
        initDate();
    }

    private void initDate() {
        calendarDate =setDateReserve(1, txt_fecha);

        datePickerFragmentIn = new DatePickerFragment();
        datePickerFragmentIn.setTextView(txt_fecha, txt_fecha, calendarDate);
    }

    private Calendar setDateReserve(int dayLast, TextView dateTextView) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dayLast);//sumar dias
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        String[] strDays = new String[]{"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        String dia = strDays[calendar.get(Calendar.DAY_OF_WEEK) - 1];//obtener dia

        dateTextView.setText(dateFormat.format(calendar.getTime()));

        return calendar;
    }

    public void showDatePickerDialog(View v) {
        datePickerFragmentIn.show(getFragmentManager(), "datePicker");
    }

    private void getEmail() {
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
    }

    /**
     * guarda la imagen tomada con la camara en el activity en el celular
     */
    private void addPictureToGalery() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File newFile = new File(mCurrentPhotoPath);

        Uri contentUri = Uri.fromFile(newFile);
        intent.setData(contentUri);
        this.sendBroadcast(intent);
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
        return image;
    }

    @NonNull
    private ModeloHotel getHotel(int idHotelSQLite) {
        ModeloHotel modeloHotel = new ModeloHotel();
        modeloHotel.setIdSQLite(idHotelSQLite);
        modeloHotel.setNombre(txt_nombre.getText().toString());
        modeloHotel.setDireccion(txt_direccion.getText().toString());
        modeloHotel.setLinea(txt_linea.getText().toString());
        modeloHotel.setActividad(txt_actividad.getText().toString());
        modeloHotel.setTelefonoString(txt_telefono.getText().toString());
        modeloHotel.setPaginaWeb(txt_paginaweb.getText().toString());
        modeloHotel.setEmail(txt_email.getText().toString());
        modeloHotel.setGpsX(Float.parseFloat(txt_latitud.getText().toString()));
        modeloHotel.setGpsY(Float.parseFloat(txt_longitud.getText().toString()));
        modeloHotel.setRegistradoPor(email);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);
        switch (rol) {
            case Constants.USUARIO_ROL_REVISOR:
                modeloHotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
                break;
            case Constants.USUARIO_ROL_ADMIN:
                modeloHotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
                break;
            default:
                modeloHotel.setEstado(Constants.ESTADO_LUGAR_SUG_INSERTAR);
                break;
        }

        return modeloHotel;
    }

    /**
     * obtener la imagen capturada
     *
     * @param id:identificador del lugar a guardar
     * @param tipo:            tipo de imagen(hotel,restaurante,hotel)
     * @return ModeloImagen:imagen
     */
    @NonNull
    private ArrayList<ModeloImagen> getImagen(String tipo, int id, String ruta) {
        ModeloImagen modeloImagen = new ModeloImagen();
        modeloImagen.setIdSqlite(0);
        modeloImagen.setIdLugarReference(id);
        modeloImagen.setIdImagen(1);
        modeloImagen.setTipoImagen(tipo);
        modeloImagen.setUrlApp(txt_ruta_imagen.getText().toString());

        Uri uri;
        try {
            uri = Uri.fromFile(new File(mCurrentAbsolutePhotoPath));
        } catch (NullPointerException e) {
            uri = Uri.fromFile(new File(mCurrentPhotoPath));
        }
        modeloImagen.setUrlServer(ruta + "/" + uri.getLastPathSegment());

        ArrayList<ModeloImagen> modeloImagenArrayList = new ArrayList<>();
        modeloImagenArrayList.add(modeloImagen);
        return modeloImagenArrayList;
    }

    /**
     * recupera datos de la vista y lo convierte en un objeto ModeloLugarTuristico
     *
     * @param lugarTuristico:conexion a la base de datos SQLite
     * @return ModeloLugarTuristico:lugar turistico a insertar
     */
    @NonNull
    private ModeloLugarTuristico getLugarTuristico(SqliteLugar lugarTuristico) {
        ModeloLugarTuristico modeloLugarTuristico = new ModeloLugarTuristico();
        modeloLugarTuristico.setIdSQLite(lugarTuristico.list().size() + 1);
        modeloLugarTuristico.setNombre(txt_nombre.getText().toString());
        modeloLugarTuristico.setTipo(spinnerCategoria.getSelectedItem().toString());
        modeloLugarTuristico.setActividad(txt_actividad.getText().toString());
        modeloLugarTuristico.setDescripcion(txt_descripcion.getText().toString());
        modeloLugarTuristico.setDireccion(txt_direccion.getText().toString());
        modeloLugarTuristico.setTelefonoString(txt_telefono.getText().toString());
        modeloLugarTuristico.setHorario(txt_horario.getText().toString());
        modeloLugarTuristico.setGpsX(Float.parseFloat(txt_latitud.getText().toString()));
        modeloLugarTuristico.setGpsY(Float.parseFloat(txt_longitud.getText().toString()));
        modeloLugarTuristico.setProvincia(spinnerProvincia.getSelectedItem().toString());
        modeloLugarTuristico.setLinea(txt_linea.getText().toString());
        modeloLugarTuristico.setFecha(String.valueOf(calendarDate.getTimeInMillis()));
        modeloLugarTuristico.setRegistradoPor(email);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);
        switch (rol) {
            case Constants.USUARIO_ROL_REVISOR:
                modeloLugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
                break;
            case Constants.USUARIO_ROL_ADMIN:
                modeloLugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
                break;
            default:
                modeloLugarTuristico.setEstado(Constants.ESTADO_LUGAR_SUG_INSERTAR);
                break;
        }

        return modeloLugarTuristico;
    }

    @NonNull
    private ModeloRestaurante getRestaurante(SqliteRestaurante restaurante) {
        ModeloRestaurante modeloRestaurante = new ModeloRestaurante();
        modeloRestaurante.setIdSQLite(restaurante.list().size() + 1);
        modeloRestaurante.setNombre(txt_nombre.getText().toString());
        modeloRestaurante.setLinea(txt_linea.getText().toString());
        modeloRestaurante.setActividad(txt_actividad.getText().toString());
        modeloRestaurante.setHorario(txt_horario.getText().toString());
        modeloRestaurante.setDireccion(txt_direccion.getText().toString());
        modeloRestaurante.setEmail(txt_email.getText().toString());
        modeloRestaurante.setPaginaWeb(txt_paginaweb.getText().toString());
        modeloRestaurante.setTelefonoString(txt_telefono.getText().toString());
        modeloRestaurante.setGpsX(Float.parseFloat(txt_latitud.getText().toString()));
        modeloRestaurante.setGpsY(Float.parseFloat(txt_longitud.getText().toString()));
        modeloRestaurante.setRegistradoPor(email);

        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        int rol = sharedPreferences.getInt("rol", 0);
        switch (rol) {
            case Constants.USUARIO_ROL_REVISOR:
                modeloRestaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
                break;
            case Constants.USUARIO_ROL_ADMIN:
                modeloRestaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
                break;
            default:
                modeloRestaurante.setEstado(Constants.ESTADO_LUGAR_SUG_INSERTAR);
                break;
        }

        return modeloRestaurante;
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
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    public void goGaleryActivity(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, SELECT_PICTURE);
    }

    /**
     * envia la imagen tomada por la camara al servidor bdFirebase//h
     */
    private void guardarDatosFirebaseHotel() {
        final SqliteHotel hotelSQLite = new SqliteHotel(this);
        final ModeloHotel modeloHotel = getHotel(hotelSQLite.list().size());

        databaseReference = app.getDataBaseReferenceHotel("");
        File file = new File(mCurrentAbsolutePhotoPath);
        final Uri uri = Uri.fromFile(file);

        storageReference = app.getStorageReferenceHotel(modeloHotel.getNombre());
        StorageReference imageReference = storageReference.child(uri.getLastPathSegment());

        UploadTask uploadTask = imageReference.putFile(uri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InsertarLugarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                modeloHotel.setImagenes(getImagen(ModeloImagen.TIPO_HOTEL, modeloHotel.getIdSQLite(), ModeloImagen.TIPO_HOTEL + "/" + modeloHotel.getNombre()));

                databaseReference.push().setValue(modeloHotel, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        modeloHotel.setIdFirebase(databaseReference.getKey());
                        hotelSQLite.insert(modeloHotel);//insertar modeloHotel en SQLite
                        Toast.makeText(InsertarLugarActivity.this, "Hotel insertado exitosamente", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    /**
     * enviar los datos recuperados del activity al servidor bdFirebase
     */
    private void guardarDatosFirebaseRestaurante() {
        final SqliteRestaurante restaurante = new SqliteRestaurante(this);
        final ModeloRestaurante modeloRestaurante = getRestaurante(restaurante);

        databaseReference = app.getDataBaseReferenceRestaurante("");
        File file = new File(mCurrentAbsolutePhotoPath);
        final Uri uri = Uri.fromFile(file);

        storageReference = app.getStorageReferenceRestaurante(modeloRestaurante.getNombre());
        StorageReference imageReference = storageReference.child(uri.getLastPathSegment());

        UploadTask uploadTask = imageReference.putFile(uri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InsertarLugarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                modeloRestaurante.setImagenes(getImagen(ModeloImagen.TIPO_RESTAURANTE, modeloRestaurante.getIdSQLite(), ModeloImagen.TIPO_RESTAURANTE + "/" + modeloRestaurante.getNombre()));

                databaseReference.push().setValue(modeloRestaurante, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        modeloRestaurante.setIdFirebase(databaseReference.getKey());
                        restaurante.insert(modeloRestaurante);//insertar restaurate en SQLite

                        Toast.makeText(InsertarLugarActivity.this, "Restaurante insertado exitosamente", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    /**
     * envia la imagen tomada por la camara al servidor bdFirebase
     */
    private void guardarDatosFirebaseLugarTuristico() {
        final SqliteLugar lugarTuristico = new SqliteLugar(this);
        final ModeloLugarTuristico modeloLugarTuristico = getLugarTuristico(lugarTuristico);

        File file = new File(mCurrentAbsolutePhotoPath);
        final Uri uri = Uri.fromFile(file);

        databaseReference = setReferencetProvincia(modeloLugarTuristico);

        storageReference = app.getStorageReferenceLugarTuristico(modeloLugarTuristico.getNombre());
        StorageReference imageReference = storageReference.child(uri.getLastPathSegment());

        UploadTask uploadTask = imageReference.putFile(uri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InsertarLugarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                modeloLugarTuristico.setImagenesFirebase(getImagen(ModeloImagen.TIPO_LUGAR, modeloLugarTuristico.getIdSQLite(), ModeloImagen.TIPO_LUGAR + "/" + modeloLugarTuristico.getNombre()));

                databaseReference.push().setValue(modeloLugarTuristico, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                        modeloLugarTuristico.setIdFirebase(databaseReference.getKey());
                        lugarTuristico.insert(modeloLugarTuristico);//insertar el lugar turistico en SQLite

                        Toast.makeText(InsertarLugarActivity.this, "Lugar turistico insertado exitosamente", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private DatabaseReference setReferencetProvincia(ModeloLugarTuristico modeloLugarTuristico) {
        String[] arrayTipo = getResources().getStringArray(R.array.provincia);
        for (String anArrayTipo : arrayTipo) {
            if (modeloLugarTuristico.getProvincia().equals(anArrayTipo)) {
                databaseReference = app.getDataBaseReferenceLugarTuristico(anArrayTipo);
                break;
            }
        }

        return databaseReference;
    }

    private void iniciarLayout() {
        layout_tipo = findViewById(R.id.layout_tipo);
        layout_provincia = findViewById(R.id.layout_provincia);
        layout_tipoTurismo = findViewById(R.id.layout_tipoTurismo);
        layout_nombre = findViewById(R.id.layout_nombre);
        layout_actividad = findViewById(R.id.layout_actividad);
        layout_descripcion = findViewById(R.id.layout_descripcion);
        layout_email = findViewById(R.id.layout_email);
        layout_direccion = findViewById(R.id.layout_direccion);
        layout_pagina_web = findViewById(R.id.layout_pagina_web);
        layout_telefono = findViewById(R.id.layout_telefono);
        layout_horario = findViewById(R.id.layout_horario);
        layout_latitud = findViewById(R.id.layout_latitud);
        layout_longitud = findViewById(R.id.layout_longitud);
        layout_fecha = findViewById(R.id.layout_fechaTurismo);
        layout_linea = findViewById(R.id.layout_lineaTurismo);
        layout_imagen = findViewById(R.id.layout_imagen);
    }

    private void iniciarValores() {
        imageView = findViewById(R.id.insertar_imagen);
        txt_ruta_imagen = findViewById(R.id.ruta_imagen);

        spinnerProvincia = findViewById(R.id.spinner_provincia);
        spinnerCategoria = findViewById(R.id.spinner_tipo_turismo);
        spinnerTipo = findViewById(R.id.spinner_tipo);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_direccion = findViewById(R.id.txt_direccion);
        txt_telefono = findViewById(R.id.txt_telefono);
        txt_paginaweb = findViewById(R.id.txt_paginaweb);
        txt_email = findViewById(R.id.txt_email);
        txt_latitud = findViewById(R.id.txt_latitud);
        txt_longitud = findViewById(R.id.txt_longitud);
        txt_actividad = findViewById(R.id.txt_actividad_insertar);
        txt_descripcion = findViewById(R.id.txt_descripcion_insertar);
        txt_horario = findViewById(R.id.txt_horario);
        txt_linea = findViewById(R.id.txt_linea);
        txt_fecha = findViewById(R.id.txt_fecha);
    }

    /**
     * agregar los valores de los spinner en el activity insertar
     * -spinner provincia(cercado, quillacollo,etc)
     */
    private void initSpinnerProvincia() {
        ArrayAdapter<CharSequence> adapterProvincia = ArrayAdapter.createFromResource(this, R.array.provincia, android.R.layout.simple_spinner_item);
        adapterProvincia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincia.setAdapter(adapterProvincia);
    }

    /**
     * agregar los valores de los spinner en el activity insertar
     * -spinner tipo lugar(arquitectonico, etc..)
     */
    private void initSpinnerTipoLugar() {
        ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(this, R.array.tipo_insercion, android.R.layout.simple_spinner_item);
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapterTipo);
        spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://hotel
                        layout_tipo.setVisibility(View.VISIBLE);
                        layout_provincia.setVisibility(View.GONE);
                        //layout_provincia.removeAllViews();//lo elimnar y despues no vuelve a aparecer
                        layout_tipoTurismo.setVisibility(View.GONE);
                        layout_nombre.setVisibility(View.VISIBLE);
                        layout_actividad.setVisibility(View.VISIBLE);
                        layout_descripcion.setVisibility(View.GONE);
                        layout_linea.setVisibility(View.VISIBLE);
                        layout_fecha.setVisibility(View.GONE);
                        layout_email.setVisibility(View.VISIBLE);
                        layout_direccion.setVisibility(View.VISIBLE);
                        layout_pagina_web.setVisibility(View.VISIBLE);
                        layout_telefono.setVisibility(View.VISIBLE);
                        layout_horario.setVisibility(View.VISIBLE);
                        layout_latitud.setVisibility(View.VISIBLE);
                        layout_longitud.setVisibility(View.VISIBLE);
                        layout_imagen.setVisibility(View.VISIBLE);
                        break;
                    case 1://restaurante
                        layout_tipo.setVisibility(View.VISIBLE);
                        layout_provincia.setVisibility(View.GONE);
                        layout_tipoTurismo.setVisibility(View.GONE);
                        layout_nombre.setVisibility(View.VISIBLE);
                        layout_actividad.setVisibility(View.VISIBLE);
                        layout_descripcion.setVisibility(View.GONE);
                        layout_linea.setVisibility(View.VISIBLE);
                        layout_fecha.setVisibility(View.GONE);
                        layout_email.setVisibility(View.VISIBLE);
                        layout_direccion.setVisibility(View.VISIBLE);
                        layout_pagina_web.setVisibility(View.VISIBLE);
                        layout_telefono.setVisibility(View.VISIBLE);
                        layout_horario.setVisibility(View.VISIBLE);
                        layout_latitud.setVisibility(View.VISIBLE);
                        layout_longitud.setVisibility(View.VISIBLE);
                        layout_imagen.setVisibility(View.VISIBLE);
                        break;
                    case 2://lugar turistico
                        layout_tipo.setVisibility(View.VISIBLE);
                        layout_provincia.setVisibility(View.VISIBLE);
                        layout_tipoTurismo.setVisibility(View.VISIBLE);
                        layout_nombre.setVisibility(View.VISIBLE);
                        layout_actividad.setVisibility(View.VISIBLE);
                        layout_descripcion.setVisibility(View.VISIBLE);
                        layout_email.setVisibility(View.GONE);
                        layout_direccion.setVisibility(View.VISIBLE);
                        layout_pagina_web.setVisibility(View.VISIBLE);
                        layout_telefono.setVisibility(View.VISIBLE);
                        layout_horario.setVisibility(View.VISIBLE);
                        layout_latitud.setVisibility(View.VISIBLE);
                        layout_longitud.setVisibility(View.VISIBLE);
                        layout_imagen.setVisibility(View.VISIBLE);
                        layout_linea.setVisibility(View.GONE);
                        layout_fecha.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * agregar los valores de los spinner en el activity insertar
     * -spinner tipo insercion(hotel, restarutanre, lugar turistico)
     */
    private void initSpinnerCategoria() {
        ArrayAdapter<CharSequence> adapterTipoTurismo = ArrayAdapter.createFromResource(this, R.array.tipo_turismo, android.R.layout.simple_spinner_item);
        adapterTipoTurismo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapterTipoTurismo);
        spinnerCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 4://acontecimiento en un lugar turistico
                        layout_tipo.setVisibility(View.VISIBLE);
                        layout_provincia.setVisibility(View.VISIBLE);
                        layout_tipoTurismo.setVisibility(View.VISIBLE);
                        layout_nombre.setVisibility(View.VISIBLE);
                        layout_actividad.setVisibility(View.VISIBLE);
                        layout_descripcion.setVisibility(View.VISIBLE);
                        layout_email.setVisibility(View.GONE);
                        layout_direccion.setVisibility(View.VISIBLE);
                        layout_pagina_web.setVisibility(View.GONE);
                        layout_telefono.setVisibility(View.VISIBLE);
                        layout_horario.setVisibility(View.VISIBLE);
                        layout_latitud.setVisibility(View.VISIBLE);
                        layout_longitud.setVisibility(View.VISIBLE);
                        layout_imagen.setVisibility(View.VISIBLE);
                        layout_linea.setVisibility(View.VISIBLE);
                        layout_fecha.setVisibility(View.VISIBLE);
                        break;
                    default:
                        //layout_linea.setVisibility(View.GONE);
                        layout_fecha.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * envia los datos llenados  en la vista al servidro bdFirebase
     * tambien los almacena en la base de datos interna SQLite
     * PD: la imagen tomada tambien es enviada al servidor fireBase
     *
     * @param view:parametros del boton presionado
     */
    public void insertarLugarSQLite(View view) {
        Intent intent;

        switch (spinnerTipo.getSelectedItemPosition()) {
            case 0://hotel
                if (isValidHotel()) {
                    guardarDatosFirebaseHotel();

                    intent = new Intent(InsertarLugarActivity.this, MapaHotelesActivity.class);
                    startActivity(intent);
                }
                break;
            case 1://restaurante
                if (isValidRestaurante()) {
                    guardarDatosFirebaseRestaurante();
                    intent = new Intent(this, MapaRestaurantesActivity.class);
                    startActivity(intent);
                }
                break;
            case 2://lugar turistico
                if (isValidLugarTuristico()) {
                    guardarDatosFirebaseLugarTuristico();
                    intent = new Intent(this, MapaLugaresActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                Toast.makeText(this, "Ocurrio un error con el tipo de lugar: " + spinnerTipo.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    private boolean isValidLugarTuristico() {
        boolean isValidLugarTuristico = true;

        txt_nombre.setError(null);
        txt_actividad.setError(null);
        txt_latitud.setError(null);
        txt_longitud.setError(null);
        txt_ruta_imagen.setError(null);
        focusView = null;
        //para el error en spinner provincia
        TextView txt_provincia = (TextView) spinnerProvincia.getSelectedView();
        txt_provincia.setError(null);
        txt_provincia.setTextColor(Color.RED);//just to highlight that this is an error

        String provincia = txt_provincia.getText().toString();
        String nombre = txt_nombre.getText().toString();
        String actividad = txt_actividad.getText().toString();
        String descripcion = txt_descripcion.getText().toString();
        String latitud = txt_latitud.getText().toString();
        String longitud = txt_longitud.getText().toString();
        String rutaImagen = txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this, "Seleccione una una imagen de la galeria\n o capture una foto", Toast.LENGTH_SHORT).show();
            focusView = txt_ruta_imagen;
            isValidLugarTuristico = false;
        }
        if (longitud.isEmpty()) {
            txt_longitud.setError("Llenar Longitud");
            focusView = txt_longitud;
            isValidLugarTuristico = false;
        }
        if (latitud.isEmpty()) {
            txt_latitud.setError("Ingrese la latidud");
            focusView = txt_latitud;
            isValidLugarTuristico = false;
        }
        if (actividad.isEmpty()) {
            txt_actividad.setError("Llenar descripción");
            focusView = txt_actividad;
            isValidLugarTuristico = false;
        }
        if (provincia.isEmpty()) {
            txt_provincia.setError("Seleccione una Provincia");
            focusView = txt_provincia;
            isValidLugarTuristico = false;
        }
        if (descripcion.isEmpty()) {
            txt_descripcion.setError("Llenar descripcion");
            focusView = txt_descripcion;
            isValidLugarTuristico = false;
        }
        if (nombre.isEmpty()) {
            txt_nombre.setError("Llenar Nombre");
            focusView = txt_nombre;
            isValidLugarTuristico = false;
        }

        if (focusView != null) {
            focusView.requestFocus();
        }
        return isValidLugarTuristico;
    }

    private boolean isValidRestaurante() {
        boolean isValidRestaurante = true;
        txt_nombre.setError(null);
        txt_latitud.setError(null);
        txt_longitud.setError(null);
        focusView = null;
        String nombre = txt_nombre.getText().toString();
        String latitud = txt_latitud.getText().toString();
        String longitud = txt_longitud.getText().toString();
        String rutaImagen = txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this, "Seleccione una una imagen de la galeria\n o capture una foto", Toast.LENGTH_SHORT).show();
            focusView = txt_ruta_imagen;
            isValidRestaurante = false;
        }
        if (longitud.isEmpty()) {
            txt_longitud.setError("Llenar Longitud");
            focusView = txt_longitud;
            isValidRestaurante = false;
        }
        if (latitud.isEmpty()) {
            txt_latitud.setError("Llenar Latitud");
            focusView = txt_latitud;
            isValidRestaurante = false;
        }
        if (nombre.isEmpty()) {
            txt_nombre.setError("Llenar Nombre");
            focusView = txt_nombre;
            isValidRestaurante = false;
        }
        if (focusView != null) {
            focusView.requestFocus();
        }
        return isValidRestaurante;
    }

    private boolean isValidHotel() {
        boolean isValidHotel = true;
        txt_nombre.setError(null);
        txt_latitud.setError(null);
        txt_longitud.setError(null);
        focusView = null;

        String nombre = txt_nombre.getText().toString();
        String latitud = txt_latitud.getText().toString();
        String longitud = txt_longitud.getText().toString();
        String rutaImagen = txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this, "Seleccione una una imagen de la galeria\n o capture una foto", Toast.LENGTH_SHORT).show();
            focusView = txt_ruta_imagen;
            isValidHotel = false;
        }
        if (longitud.isEmpty()) {
            txt_longitud.setError("Llenar Longitud");
            focusView = txt_longitud;
            isValidHotel = false;
        }
        if (latitud.isEmpty()) {
            txt_latitud.setError("Llenar Latitud");
            focusView = txt_latitud;
            isValidHotel = false;
        }
        if (nombre.isEmpty()) {
            txt_nombre.setError("Llenar Nombre");
            focusView = txt_nombre;
            isValidHotel = false;
        }
        if (focusView != null) {
            focusView.requestFocus();
        }
        return isValidHotel;
    }

    /**
     * activa la camara para tomar una foto
     */
    private void showImageCamera() {
        Button button = findViewById(R.id.btn_imagen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCameraActivity(v);
            }
        });
    }
}
