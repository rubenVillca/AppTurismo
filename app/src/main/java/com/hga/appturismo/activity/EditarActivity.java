package com.hga.appturismo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hga.appturismo.R;
import com.hga.appturismo.api.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.String.valueOf;

public class EditarActivity extends AppCompatActivity {
    private String mCurrentPhotoPath = "";
    private String mCurrentAbsolutePhotoPath = "";

    private TurismoAplicacion app;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    private ModeloHotel modeloHotelOld;
    private ModeloHotel modeloHotelNew;
    private ModeloRestaurante modeloRestauranteOld;
    private ModeloRestaurante modeloRestauranteNew;
    private ModeloLugarTuristico modeloLugarTuristicoOld;
    private ModeloLugarTuristico modeloLugarTuristicoNew;

    private Spinner editar_spinner_tipo;//seleccion entre: hotel,restaurante,lugar turistico

    private Spinner editar_spinner_provincia;
    private Spinner editar_spinner_tipo_turismo;

    private EditText editar_txt_nombre;
    private EditText editar_txt_descripcion;
    private EditText editar_txt_email;
    private EditText editar_txt_direccion;
    private EditText editar_txt_paginaweb;
    private EditText editar_txt_telefono;
    private EditText editar_txt_horario;
    private EditText editar_txt_latitud;
    private EditText editar_txt_longitud;

    private Button editar_btn_imagen_capturar;
    private Button editar_btn_insertar;//guardar
    private Button editar_btn_imagen_buscar;
    private TextView editar_txt_ruta_imagen;//ruta de la imagen
    private ImageView imageView;//imagen capturada
    private FloatingActionButton btn_editar;//

    private LinearLayout editar_layout_tipo;
    private LinearLayout editar_layout_provincia;
    private LinearLayout editar_layout_tipoTurismo;
    private LinearLayout editar_layout_nombre;
    private LinearLayout editar_layout_descripcion;
    private LinearLayout editar_layout_email;
    private LinearLayout editar_layout_direccion;
    private LinearLayout editar_layout_pagina_web;
    private LinearLayout editar_layout_telefono;
    private LinearLayout editar_layout_horario;
    private LinearLayout editar_layout_latitud;
    private LinearLayout editar_layout_longitud;
    private LinearLayout editar_layout_imagen;
    private View focusView = null;

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
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            mCurrentAbsolutePhotoPath = cursor.getString(columnIndex);//here we have our image path.
            mCurrentPhotoPath = "file:" + cursor.getString(columnIndex);//here we have our image path.

            cursor.close();

            editar_txt_ruta_imagen.setText(mCurrentPhotoPath);
            Picasso.with(this).load(selectedImage).into(imageView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        app = (TurismoAplicacion) getApplicationContext();

        recuperarDatosModelo();
        iniciarVista();
        iniciarVistaSpinner();
        llenarFormulario();
    }

    private void recuperarDatosModelo() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.get("modeloHotel") != null) {
                modeloHotelOld = (ModeloHotel) bundle.get("modeloHotel");
            }
            if (bundle.get("modeloRestaurante") != null) {
                modeloRestauranteOld = (ModeloRestaurante) bundle.get("modeloRestaurante");
            }
            if (bundle.get("lugar") != null) {
                modeloLugarTuristicoOld = (ModeloLugarTuristico) bundle.get("lugar");
            }
        }

    }

    private void iniciarVista() {
        editar_layout_tipo = (LinearLayout) findViewById(R.id.editar_layout_tipo);
        editar_spinner_tipo = (Spinner) findViewById(R.id.editar_spinner_tipo);
        editar_layout_provincia = (LinearLayout) findViewById(R.id.editar_layout_provincia);
        editar_spinner_provincia = (Spinner) findViewById(R.id.editar_spinner_provincia);
        editar_layout_tipoTurismo = (LinearLayout) findViewById(R.id.editar_layout_tipoTurismo);
        editar_spinner_tipo_turismo = (Spinner) findViewById(R.id.editar_spinner_tipo_turismo);
        editar_layout_nombre = (LinearLayout) findViewById(R.id.editar_layout_nombre);
        editar_txt_nombre = (EditText) findViewById(R.id.editar_txt_nombre);
        editar_layout_descripcion = (LinearLayout) findViewById(R.id.editar_layout_descripcion);
        editar_txt_descripcion = (EditText) findViewById(R.id.editar_txt_descripcion);
        editar_layout_email = (LinearLayout) findViewById(R.id.editar_layout_email);
        editar_txt_email = (EditText) findViewById(R.id.editar_txt_email);
        editar_layout_direccion = (LinearLayout) findViewById(R.id.editar_layout_direccion);
        editar_txt_direccion = (EditText) findViewById(R.id.editar_txt_direccion);
        editar_layout_pagina_web = (LinearLayout) findViewById(R.id.editar_layout_pagina_web);
        editar_txt_paginaweb = (EditText) findViewById(R.id.editar_txt_paginaweb);
        editar_layout_telefono = (LinearLayout) findViewById(R.id.editar_layout_telefono);
        editar_txt_telefono = (EditText) findViewById(R.id.editar_txt_telefono);
        editar_layout_horario = (LinearLayout) findViewById(R.id.editar_layout_horario);
        editar_txt_horario = (EditText) findViewById(R.id.editar_txt_horario);
        editar_layout_latitud = (LinearLayout) findViewById(R.id.editar_layout_latitud);
        editar_txt_latitud = (EditText) findViewById(R.id.editar_txt_latitud);
        editar_layout_longitud = (LinearLayout) findViewById(R.id.editar_layout_longitud);
        editar_txt_longitud = (EditText) findViewById(R.id.editar_txt_longitud);

        editar_layout_imagen = (LinearLayout) findViewById(R.id.editar_layout_imagen);
        editar_txt_ruta_imagen = (TextView) findViewById(R.id.editar_ruta_imagen);
        imageView = (ImageView) findViewById(R.id.editar_insertar_imagen);
        editar_btn_imagen_capturar = (Button) findViewById(R.id.editar_btn_imagen_capturar);
        editar_btn_imagen_buscar = (Button) findViewById(R.id.editar_btn_imagen_buscar);

        editar_btn_insertar = (Button) findViewById(R.id.editar_btn_insertar);
        editar_btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modeloHotelOld != null) {
                    if (isValidHotel()) {
                        recuperarFormularioHotel();
                        guardarFirebaseHotel();
                        Toast.makeText(EditarActivity.this, "Editado hotel " + modeloHotelNew.getNombre(), Toast.LENGTH_SHORT).show();

                    }
                }
                if (modeloRestauranteOld != null) {
                    if (isValidRestaurante()) {
                        recuperarFormularioRestaurante();
                        guardarFirebaseRestaurante();
                        Toast.makeText(EditarActivity.this, "Editado restaurante " + modeloRestauranteNew.getNombre(), Toast.LENGTH_SHORT).show();
                    /*Intent intent=new Intent(EditarActivity.this,ListaRestaurantesActivity.class);
                    startActivity(intent);*/
                    }
                }
                if (modeloLugarTuristicoOld != null) {
                    if (isValidLugarTuristico()) {
                        recuperarFormularioLugar();
                        guardarFirebaseLugarTuristico();
                        Toast.makeText(EditarActivity.this, "Editado lugar " + modeloLugarTuristicoNew.getNombre(), Toast.LENGTH_SHORT).show();
                    /*Intent intent=new Intent(EditarActivity.this,ListaLugaresActivity.class);
                    startActivity(intent);*/
                        //insertar imgen en firebase
                    }
                }
                Intent intent = new Intent(EditarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if (modeloHotelOld != null) {
            cargarImagenHotel();
        }
        if (modeloRestauranteOld != null) {
            cargarImagenRestaurante();
        }
        if (modeloLugarTuristicoOld != null) {
            cargarImagenLugarTuristico();
        }
    }

    private void cargarImagenHotel() {
        if (modeloHotelOld.getImagenes().size() > 0) {
            if (!modeloHotelOld.getImagenes().get(0).getUrlApp().equals("")) {
                try {
                    int idImage = Integer.parseInt(modeloHotelOld.getImagenes().get(0).getUrlApp());
                    Picasso.with(this).load(idImage).into(imageView);
                } catch (NumberFormatException e) {
                    Picasso.with(this).load(modeloHotelOld.getImagenes().get(0).getUrlApp()).into(imageView);
                }
            } else {
                String urlImagenServer = modeloHotelOld.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceHotel(urlImagenServer);
                storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(EditarActivity.this).load(uri.toString()).into(imageView);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Error al cargar imagenes");
                    }
                });
            }
        }
    }

    private void cargarImagenRestaurante() {
        if (modeloRestauranteOld.getImagenes().size() > 0) {
            if (!modeloRestauranteOld.getImagenes().get(0).getUrlApp().equals("")) {
                try {
                    int idImage = Integer.parseInt(modeloRestauranteOld.getImagenes().get(0).getUrlApp());
                    Picasso.with(this).load(idImage).into(imageView);
                } catch (NumberFormatException e) {
                    Picasso.with(this).load(modeloRestauranteOld.getImagenes().get(0).getUrlApp()).into(imageView);
                }
            } else {
                String urlImagenServer = modeloRestauranteOld.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceRestaurante(urlImagenServer);
                storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(EditarActivity.this).load(uri.toString()).into(imageView);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Error al cargar imagenes");
                    }
                });
            }
        }
    }

    private void cargarImagenLugarTuristico() {
        if (modeloLugarTuristicoOld.getImagenes().size() > 0) {
            if (!modeloLugarTuristicoOld.getImagenes().get(0).getUrlApp().equals("")) {
                try {
                    int idImage = Integer.parseInt(modeloLugarTuristicoOld.getImagenes().get(0).getUrlApp());
                    Picasso.with(this).load(idImage).into(imageView);
                } catch (NumberFormatException e) {
                    Picasso.with(this).load(modeloLugarTuristicoOld.getImagenes().get(0).getUrlApp()).into(imageView);
                }
            } else {
                String urlImagenServer = modeloLugarTuristicoOld.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceLugarTuristico(urlImagenServer);
                storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(EditarActivity.this).load(uri.toString()).into(imageView);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Error al cargar imagenes");
                    }
                });
            }
        }
    }

    /**
     * agregar los valores de los spinner en el activity insertar
     * -spinner provincia(cercado, quillacollo,etc)
     * -spinner tipo lugar(arquitectonico, etc..)
     * -spinner tipo insercion(modeloHotelOld, restarutanre, lugar turistico)
     */
    private void iniciarVistaSpinner() {
        ArrayAdapter<CharSequence> adapterProvincia = ArrayAdapter.createFromResource(this, R.array.provincia, android.R.layout.simple_spinner_item);
        adapterProvincia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editar_spinner_provincia.setAdapter(adapterProvincia);

        ArrayAdapter<CharSequence> adapterTipoTurismo = ArrayAdapter.createFromResource(this, R.array.tipo_turismo, android.R.layout.simple_spinner_item);
        adapterTipoTurismo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editar_spinner_tipo_turismo.setAdapter(adapterTipoTurismo);

        ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(this, R.array.tipo_insercion, android.R.layout.simple_spinner_item);
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editar_spinner_tipo.setAdapter(adapterTipo);

        if (modeloHotelOld != null)
            editar_spinner_tipo.setSelection(0);
        if (modeloRestauranteOld != null)
            editar_spinner_tipo.setSelection(1);
        if (modeloLugarTuristicoOld != null)
            editar_spinner_tipo.setSelection(2);

        editar_spinner_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://modeloHotelOld
                        editar_layout_tipo.setVisibility(View.GONE);
                        editar_layout_provincia.setVisibility(View.GONE);
                        editar_layout_tipoTurismo.setVisibility(View.GONE);
                        editar_layout_nombre.setVisibility(View.VISIBLE);
                        editar_layout_descripcion.setVisibility(View.VISIBLE);
                        editar_layout_email.setVisibility(View.VISIBLE);
                        editar_layout_direccion.setVisibility(View.VISIBLE);
                        editar_layout_pagina_web.setVisibility(View.VISIBLE);
                        editar_layout_telefono.setVisibility(View.VISIBLE);
                        editar_layout_horario.setVisibility(View.VISIBLE);
                        editar_layout_latitud.setVisibility(View.VISIBLE);
                        editar_layout_longitud.setVisibility(View.VISIBLE);
                        editar_layout_imagen.setVisibility(View.VISIBLE);
                        break;
                    case 1://modeloRestauranteOld
                        editar_layout_tipo.setVisibility(View.GONE);
                        editar_layout_provincia.setVisibility(View.GONE);
                        editar_layout_tipoTurismo.setVisibility(View.GONE);
                        editar_layout_nombre.setVisibility(View.VISIBLE);
                        editar_layout_descripcion.setVisibility(View.VISIBLE);
                        editar_layout_email.setVisibility(View.GONE);
                        editar_layout_direccion.setVisibility(View.VISIBLE);
                        editar_layout_pagina_web.setVisibility(View.GONE);
                        editar_layout_telefono.setVisibility(View.VISIBLE);
                        editar_layout_horario.setVisibility(View.VISIBLE);
                        editar_layout_latitud.setVisibility(View.VISIBLE);
                        editar_layout_longitud.setVisibility(View.VISIBLE);
                        editar_layout_imagen.setVisibility(View.VISIBLE);
                        break;
                    case 2://lugar turistico
                        editar_layout_tipo.setVisibility(View.VISIBLE);
                        editar_layout_provincia.setVisibility(View.VISIBLE);
                        editar_layout_tipoTurismo.setVisibility(View.VISIBLE);
                        editar_layout_nombre.setVisibility(View.VISIBLE);
                        editar_layout_descripcion.setVisibility(View.VISIBLE);
                        editar_layout_email.setVisibility(View.VISIBLE);
                        editar_layout_direccion.setVisibility(View.VISIBLE);
                        editar_layout_pagina_web.setVisibility(View.VISIBLE);
                        editar_layout_telefono.setVisibility(View.VISIBLE);
                        editar_layout_horario.setVisibility(View.VISIBLE);
                        editar_layout_latitud.setVisibility(View.VISIBLE);
                        editar_layout_longitud.setVisibility(View.VISIBLE);
                        editar_layout_imagen.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void llenarFormulario() {
        if (modeloHotelOld != null) {
            mostrarDatosHotel();
        }
        if (modeloRestauranteOld != null) {
            mostrarDatosRestaurante();
        }
        if (modeloLugarTuristicoOld != null) {
            mostrarDatosLugarTuristico();
        }
    }

    private void recuperarFormularioLugar() {
        modeloLugarTuristicoNew = new ModeloLugarTuristico();
        modeloLugarTuristicoNew.setProvincia(editar_spinner_provincia.getSelectedItem().toString());
        modeloLugarTuristicoNew.setTipo(editar_spinner_tipo_turismo.getSelectedItem().toString());
        modeloLugarTuristicoNew.setNombre(editar_txt_nombre.getText().toString());
        modeloLugarTuristicoNew.setIdSQLite(modeloLugarTuristicoOld.getIdSQLite());
        modeloLugarTuristicoNew.setIdFirebase(modeloLugarTuristicoOld.getIdFirebase());
        modeloLugarTuristicoNew.setImagenesFirebase(
                getModeloImagens(
                        ModeloImagen.TIPO_LUGAR,
                        modeloLugarTuristicoNew.getIdSQLite(),
                        Constants.FIREBASE_STORAGE_URL_LUGAR_TURISTICO
                )
        );
        modeloLugarTuristicoNew.setDescripcion(editar_txt_descripcion.getText().toString());
        modeloLugarTuristicoNew.setHorario(editar_txt_horario.getText().toString());
        modeloLugarTuristicoNew.setDireccion(editar_txt_direccion.getText().toString());
        modeloLugarTuristicoNew.setTelefono(Integer.parseInt(editar_txt_telefono.getText().toString()));
        modeloLugarTuristicoNew.setGpsX(Float.parseFloat(editar_txt_latitud.getText().toString()));
        modeloLugarTuristicoNew.setGpsY(Float.parseFloat(editar_txt_longitud.getText().toString()));
    }

    @NonNull
    private ArrayList<ModeloImagen> getModeloImagens(String tipo, int id, String ruta) {
        ArrayList<ModeloImagen> modeloImagenArrayList = new ArrayList<>();

        if (!mCurrentPhotoPath.isEmpty()) {
            ModeloImagen modeloImagen = new ModeloImagen();
            modeloImagen.setId(0);
            modeloImagen.setKey_id(id);
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
            if (tipo.equals(ModeloImagen.TIPO_HOTEL)) {
                modeloImagenArrayList = modeloHotelOld.getImagenes();
            } else if (tipo.equals(ModeloImagen.TIPO_RESTAURANTE)) {
                modeloImagenArrayList = modeloRestauranteOld.getImagenes();
            } else if (tipo.equals(ModeloImagen.TIPO_LUGAR)) {
                modeloImagenArrayList = modeloLugarTuristicoOld.getImagenes();
            }
        }
        return modeloImagenArrayList;
    }

    private void recuperarFormularioRestaurante() {
        modeloRestauranteNew = new ModeloRestaurante();
        modeloRestauranteNew.setNombre(editar_txt_nombre.getText().toString());
        modeloRestauranteNew.setGpsX(Float.parseFloat(editar_txt_latitud.getText().toString()));
        modeloRestauranteNew.setGpsY(Float.parseFloat(editar_txt_longitud.getText().toString()));
        modeloRestauranteNew.setDireccion(editar_txt_direccion.getText().toString());
        modeloRestauranteNew.setIdSQLite(modeloRestauranteOld.getIdSQLite());
        modeloRestauranteNew.setIdFirebase(modeloRestauranteOld.getIdFirebase());
        modeloRestauranteNew.setTelefono(Integer.parseInt(editar_txt_telefono.getText().toString()));
        modeloRestauranteNew.setEmail(editar_txt_email.getText().toString());
        modeloRestauranteNew.setHorario(editar_txt_horario.getText().toString());
        modeloRestauranteNew.setProvincia(editar_spinner_provincia.getSelectedItem().toString());
        modeloRestauranteNew.setPaginaWeb(editar_txt_paginaweb.getText().toString());
        modeloRestauranteNew.setImagenesFirebase(
                getModeloImagens(ModeloImagen.TIPO_RESTAURANTE, modeloRestauranteNew.getIdSQLite(), Constants.FIREBASE_STORAGE_URL_RESTAURANTE)
        );
    }

    private void recuperarFormularioHotel() {
        modeloHotelNew = new ModeloHotel();
        modeloHotelNew.setIdFirebase(modeloHotelOld.getIdFirebase());
        modeloHotelNew.setIdSQLite(modeloHotelOld.getIdSQLite());
        modeloHotelNew.setNombre(editar_txt_nombre.getText().toString());
        modeloHotelNew.setGpsX(Float.parseFloat(editar_txt_latitud.getText().toString()));
        modeloHotelNew.setGpsY(Float.parseFloat(editar_txt_longitud.getText().toString()));
        modeloHotelNew.setDireccion(editar_txt_direccion.getText().toString());
        modeloHotelNew.setTelefono(Integer.parseInt(editar_txt_telefono.getText().toString()));
        modeloHotelNew.setProvincia(editar_spinner_provincia.getSelectedItem().toString());
        modeloHotelNew.setPaginaWeb(editar_txt_paginaweb.getText().toString());
        modeloHotelNew.setEmail(editar_txt_email.getText().toString());
        modeloHotelNew.setImagenes(getModeloImagens(ModeloImagen.TIPO_HOTEL, modeloHotelNew.getIdSQLite(), Constants.FIREBASE_STORAGE_URL_HOTEL));
    }

    /**
     * Guardar los cambios del hotel seleccionado en Firebase
     */
    private void guardarFirebaseHotel() {
        app = (TurismoAplicacion) getApplicationContext();
        //subir datos a firebase
        databaseReference = app.getDataBaseReferenceHotel();
        databaseReference.child(modeloHotelNew.getIdFirebase()).setValue(modeloHotelNew);
        if (!mCurrentPhotoPath.isEmpty()) {
            //subir imagen a firebase
            File file = new File(mCurrentAbsolutePhotoPath);
            final Uri uri = Uri.fromFile(file);

            storageReference = app.getStorageReferenceHotel("");
            StorageReference imageReference = storageReference.child(uri.getLastPathSegment());
            UploadTask uploadTask = imageReference.putFile(uri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(EditarActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    /**
     * Guardar los cambios del restaurante seleccionado en Firebase
     */
    private void guardarFirebaseRestaurante() {
        app = (TurismoAplicacion) getApplicationContext();
        //subir datos a firebase
        databaseReference = app.getDataBaseReferenceRestaurante();
        databaseReference.child(modeloRestauranteNew.getIdFirebase()).setValue(modeloRestauranteNew);
        if (!mCurrentPhotoPath.isEmpty()) {
            //subir imagen a firebase
            File file = new File(mCurrentAbsolutePhotoPath);
            final Uri uri = Uri.fromFile(file);

            storageReference = app.getStorageReferenceRestaurante("");
            StorageReference imageReference = storageReference.child(uri.getLastPathSegment());
            UploadTask uploadTask = imageReference.putFile(uri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(EditarActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    /**
     * Guardar los cambios del lugar turistico seleccionado en Firebase
     * si la provincia es diferento a la provincia inicial se eliminara el lugar turistico q este
     * en la provincia inicial
     */
    private void guardarFirebaseLugarTuristico() {
        app = (TurismoAplicacion) getApplicationContext();
        //subir datos a firebase
        databaseReference = getPostReferenceProvincia(modeloLugarTuristicoNew.getIdFirebase(), modeloLugarTuristicoNew.getProvincia());
        databaseReference.setValue(modeloLugarTuristicoNew);
        if (!modeloLugarTuristicoNew.getProvincia().equals(modeloLugarTuristicoOld.getProvincia())) {
            databaseReference = getPostReferenceProvincia(modeloLugarTuristicoOld.getIdFirebase(), modeloLugarTuristicoOld.getProvincia());
            databaseReference.removeValue();
        }

        //subir imagen a firebase
        if (!mCurrentPhotoPath.isEmpty()) {
            File file = new File(mCurrentAbsolutePhotoPath);
            final Uri uri = Uri.fromFile(file);

            storageReference = app.getStorageReferenceLugarTuristico(ModeloUsuario.codificarNombre(modeloLugarTuristicoNew.getNombre()));
            StorageReference imageReference = storageReference.child(uri.getLastPathSegment());
            UploadTask uploadTask = imageReference.putFile(uri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(EditarActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    /**
     * comvertir la ruta de firebase para usarlo...
     *
     * @param urlFirebase: ruta de la ruta en firebase
     * @return DatabaseReference:direccion de la ruta firebase en formato firebase
     */
    private DatabaseReference getPostReferenceProvincia(String urlFirebase, String provincia) {
        DatabaseReference postReference;
        provincia = provincia.toLowerCase();
        switch (provincia) {
            case "arani":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARANI + "/" + urlFirebase);
                break;
            case "cercado":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CERCADO + "/" + urlFirebase);
                break;
            case "arque":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARQUE + "/" + urlFirebase);
                break;
            case "ayopaya":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_AYOPAYA + "/" + urlFirebase);
                break;
            case "bolivar":
            case "bolívar":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_BOLIVAR + "/" + urlFirebase);
                break;
            case "campero":
            case "narciso campero":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAMPERO + "/" + urlFirebase);
                break;
            case "chapare":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CHAPARE + "/" + urlFirebase);
                break;
            case "capinota":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAMPERO + "/" + urlFirebase);
                break;
            case "esteban arze":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE + "/" + urlFirebase);
                break;
            case "jordán":
            case "jordan":
            case "germán jordán":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN + "/" + urlFirebase);
                break;
            case "carrasco":
            case "josé carrasco":
            case "José Carrasco":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO + "/" + urlFirebase);
                break;
            case "mizque":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_MIZQUE + "/" + urlFirebase);
                break;
            case "punata":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_PUNATA + "/" + urlFirebase);
                break;
            case "quillacollo":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_QUILLACOLLO + "/" + urlFirebase);
                break;
            case "tapacarí":
            case "tapacari":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TAPACARI + "/" + urlFirebase);
                break;
            case "tiraque":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TIRAQUE + "/" + urlFirebase);
                break;
            default:
                postReference = null;
                break;
        }
        return postReference;
    }

    private DatabaseReference getPostReferenceTipoTurismo(String urlFirebase, String tipo) {
        DatabaseReference postReference;
        tipo = tipo.toLowerCase();
        switch (tipo) {
            case "sitios naturales":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_TIPO_TURISMO_SITIOS_NATURALES + "/" + urlFirebase);
                break;
            case "patrimonio urbano arquitectónico, artístico, museos y manifestaciones culturales":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_TIPO_TURISMO_PATRIMONIOS + "/" + urlFirebase);
                break;
            case "etnografía y folklore":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_TIPO_TURISMO_ETNOGRAFIA_FOLKLORE + "/" + urlFirebase);
                break;
            case "realizaciones técnicas y científicas":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_TIPO_TURISMO_REALIZACIONES_TECNICAS_CIENTIFICAS + "/" + urlFirebase);
                break;
            case "acontecimientos programados":
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_TIPO_TURISMO_ACONTECIMIENTOS_PROGRAMADOS + "/" + urlFirebase);
                break;
            default:
                postReference = null;
                break;
        }
        return postReference;
    }

    private void mostrarDatosRestaurante() {
        app = (TurismoAplicacion) getApplicationContext();
        editar_layout_provincia.setVisibility(View.GONE);
        editar_layout_tipoTurismo.setVisibility(View.GONE);
        editar_layout_descripcion.setVisibility(View.GONE);
        editar_layout_pagina_web.setVisibility(View.GONE);
        //editar_spinner_tipo.setText(modeloRestauranteOld.get());
        //editar_spinner_provincia.setText(modeloRestauranteOld.get());
        //editar_spinner_tipo_turismo.setText(modeloRestauranteOld.get());
        editar_txt_nombre.setText(modeloRestauranteOld.getNombre());
        //editar_txt_descripcion.setText(modeloRestauranteOld.getD());
        editar_txt_email.setText(modeloRestauranteOld.getEmail());
        editar_txt_direccion.setText(modeloRestauranteOld.getDireccion());
        editar_txt_paginaweb.setText(modeloRestauranteOld.getPaginaWeb());
        editar_txt_telefono.setText(valueOf(modeloRestauranteOld.getTelefono()));
        editar_txt_horario.setText(modeloRestauranteOld.getHorario());
        editar_txt_latitud.setText(valueOf(valueOf(modeloRestauranteOld.getGpsX())));
        editar_txt_longitud.setText(valueOf(valueOf(modeloRestauranteOld.getGpsY())));
        String urlImagen = "";
        if (!modeloRestauranteOld.getImagenes().isEmpty()) {
            if (modeloRestauranteOld.getImagenes().get(0).getUrlServer().isEmpty()) {
                urlImagen = modeloRestauranteOld.getImagenes().get(0).getUrlApp();
                Picasso.with(this).load(urlImagen).into(imageView);

                try {
                    int idImage = Integer.parseInt(urlImagen);
                    Picasso.with(this).load(idImage).into(imageView);
                } catch (NumberFormatException e) {
                    Picasso.with(this).load(urlImagen).into(imageView);
                }
            } else {
                urlImagen = modeloRestauranteOld.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceRestaurante("");
                storageRef.child(urlImagen).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(EditarActivity.this).load(uri.toString()).into(imageView);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Error al cargar imagenes");
                    }
                });
            }
        }
        editar_txt_ruta_imagen.setText(urlImagen);
    }

    private void mostrarDatosHotel() {
        app = (TurismoAplicacion) getApplicationContext();
        editar_layout_tipoTurismo.setVisibility(View.GONE);
        editar_layout_provincia.setVisibility(View.GONE);
        editar_layout_descripcion.setVisibility(View.GONE);
        editar_layout_horario.setVisibility(View.GONE);
        //editar_spinner_tipo.setText(modeloHotelOld.get());
        //editar_spinner_provincia.setText(modeloHotelOld.get());
        //editar_spinner_tipo_turismo.setText(modeloHotelOld.get());
        editar_txt_nombre.setText(modeloHotelOld.getNombre());
        //editar_txt_descripcion.setText(modeloHotelOld.get());
        editar_txt_email.setText(modeloHotelOld.getEmail());
        editar_txt_direccion.setText(modeloHotelOld.getDireccion());
        editar_txt_paginaweb.setText(modeloHotelOld.getPaginaWeb());
        editar_txt_telefono.setText(valueOf(modeloHotelOld.getTelefono()));
        //editar_txt_horario.setText(modeloHotelOld.get());
        editar_txt_latitud.setText(valueOf(valueOf(modeloHotelOld.getGpsX())));
        editar_txt_longitud.setText(valueOf(valueOf(modeloHotelOld.getGpsY())));
        String urlImagen = "";
        if (!modeloHotelOld.getImagenes().isEmpty()) {
            if (modeloHotelOld.getImagenes().get(0).getUrlServer().isEmpty()) {
                urlImagen = modeloHotelOld.getImagenes().get(0).getUrlApp();
                try {
                    int idImage = Integer.parseInt(urlImagen);
                    Picasso.with(this).load(idImage).into(imageView);
                } catch (NumberFormatException e) {
                    Picasso.with(this).load(urlImagen).into(imageView);
                }
            } else {
                urlImagen = modeloHotelOld.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceHotel("");
                storageRef.child(urlImagen).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(EditarActivity.this).load(uri.toString()).into(imageView);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Error al cargar imagenes");
                    }
                });
            }
        }
        editar_txt_ruta_imagen.setText(urlImagen);
    }

    private void mostrarDatosLugarTuristico() {
        app = (TurismoAplicacion) getApplicationContext();

        editar_layout_tipo.setVisibility(View.GONE);
        editar_layout_pagina_web.setVisibility(View.GONE);
        //editar_spinner_tipo.setText(modeloLugarTuristicoOld.get());
        int idProvincia = getIdProvincia(modeloLugarTuristicoOld.getProvincia());
        int idTipoTurismo = getTipoTurismo(modeloLugarTuristicoOld.getTipo());
        editar_spinner_provincia.setSelection(idProvincia);
        editar_spinner_tipo_turismo.setSelection(idTipoTurismo);
        editar_txt_nombre.setText(modeloLugarTuristicoOld.getNombre());
        editar_txt_descripcion.setText(modeloLugarTuristicoOld.getDescripcion());
        //editar_txt_email.setText(modeloLugarTuristicoOld.getEmail());
        editar_txt_direccion.setText(modeloLugarTuristicoOld.getDireccion());
        //editar_txt_paginaweb.setText(modeloLugarTuristicoOld.getPaginaWeb());
        editar_txt_telefono.setText(valueOf(modeloLugarTuristicoOld.getTelefono()));
        editar_txt_horario.setText(modeloLugarTuristicoOld.getHorario());
        editar_txt_latitud.setText(valueOf(valueOf(modeloLugarTuristicoOld.getGpsX())));
        editar_txt_longitud.setText(valueOf(valueOf(modeloLugarTuristicoOld.getGpsY())));
        String urlImagen = "";
        if (!modeloLugarTuristicoOld.getImagenes().isEmpty()) {
            if (modeloLugarTuristicoOld.getImagenes().get(0).getUrlServer().isEmpty()) {
                urlImagen = modeloLugarTuristicoOld.getImagenes().get(0).getUrlApp();
                Picasso.with(this).load(urlImagen).into(imageView);
                try {
                    int idImage = Integer.parseInt(urlImagen);
                    Picasso.with(this).load(idImage).into(imageView);
                } catch (NumberFormatException e) {
                    Picasso.with(this).load(urlImagen).into(imageView);
                }
            } else {
                urlImagen = modeloLugarTuristicoOld.getImagenes().get(0).getUrlServer();

                StorageReference storageRef = app.getStorageReferenceLugarTuristico("");
                storageRef.child(urlImagen).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Got the download URL for 'users/me/profile.png'
                        // Pass it to Picasso to download, show in ImageView and caching
                        Picasso.with(EditarActivity.this).load(uri.toString()).into(imageView);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Error al cargar imagenes");
                    }
                });
            }
        }
        editar_txt_ruta_imagen.setText(urlImagen);
    }

    private int getTipoTurismo(String tipo) {
        int res;
        switch (tipo) {
            case "sitios naturales":
                res = 0;
                break;
            case "patrimonio urbano arquitectónico, artístico, museos y manifestaciones culturales":
                res = 1;
                break;
            case "etnografía y folklore":
                res = 2;
                break;
            case "realizaciones técnicas y científicas":
                res = 3;
                break;
            case "acontecimientos programados":
                res = 4;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }

    private int getIdProvincia(String provincia) {
        provincia = provincia.toLowerCase();
        int res;
        switch (provincia) {
            case "arani":
                res = 0;
                break;
            case "arque":
                res = 1;
                break;
            case "ayopaya":
                res = 2;
                break;
            case "bolivar":
            case "bolívar":
                res = 3;
                break;
            case "narciso campero":
                res = 4;
                break;
            case "capinota":
                res = 5;
                break;
            case "cercado":
                res = 6;
                break;
            case "chapare":
                res = 7;
                break;
            case "esteban arce":
                res = 8;
                break;
            case "germán jordán":
            case "german jordan":
                res = 9;
                break;
            case "jose carrasco":
            case "josé carrasco":
                res = 10;
                break;
            case "mizque":
                res = 11;
                break;
            case "punata":
                res = 12;
                break;
            case "quillacollo":
                res = 13;
                break;
            case "tapacarí":
            case "tapacari":
                res = 14;
                break;
            case "tiraque":
                res = 15;
                break;
            default:
                res = 0;
                break;
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

    private boolean isValidLugarTuristico() {
        boolean isValidLugarTuristico = true;

        editar_txt_nombre.setError(null);
        editar_txt_descripcion.setError(null);
        editar_txt_latitud.setError(null);
        editar_txt_longitud.setError(null);
        editar_txt_ruta_imagen.setError(null);
        focusView = null;
        //para el error en spinner provincia
        TextView editar_txt_provincia = (TextView) editar_spinner_provincia.getSelectedView();
        editar_txt_provincia.setError(null);
        editar_txt_provincia.setTextColor(Color.RED);//just to highlight that this is an error

        String provincia = editar_txt_provincia.getText().toString();
        String nombre = editar_txt_nombre.getText().toString();
        String descripcion = editar_txt_descripcion.getText().toString();
        String latitud = editar_txt_latitud.getText().toString();
        String longitud = editar_txt_longitud.getText().toString();
        String rutaImagen = editar_txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            editar_txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this, "Seleccione una una imagen de la galeria\n o capture una foto", Toast.LENGTH_SHORT).show();
            focusView = editar_txt_ruta_imagen;
            isValidLugarTuristico = false;
        }
        if (longitud.isEmpty()) {
            editar_txt_longitud.setError("Llenar Longitud");
            focusView = editar_txt_longitud;
            isValidLugarTuristico = false;
        }
        if (latitud.isEmpty()) {
            editar_txt_latitud.setError("Ingrese la latidud GPS");
            focusView = editar_txt_latitud;
            isValidLugarTuristico = false;
        }
        if (descripcion.isEmpty()) {
            editar_txt_descripcion.setError("Llenar descripción");
            focusView = editar_txt_descripcion;
            isValidLugarTuristico = false;
        }
        if (provincia.isEmpty()) {
            editar_txt_provincia.setError("Sleccione una provincia");
            focusView = editar_txt_provincia;
            isValidLugarTuristico = false;
        }
        if (nombre.isEmpty()) {
            editar_txt_nombre.setError("Llenar Nombre");
            focusView = editar_txt_nombre;
            isValidLugarTuristico = false;
        }
        if (focusView != null) {
            focusView.requestFocus();
        }
        return isValidLugarTuristico;
    }

    private boolean isValidRestaurante() {
        boolean isValidRestaurante = true;
        editar_txt_nombre.setError(null);
        editar_txt_latitud.setError(null);
        editar_txt_longitud.setError(null);
        focusView = null;
        String nombre = editar_txt_nombre.getText().toString();
        String latitud = editar_txt_latitud.getText().toString();
        String longitud = editar_txt_longitud.getText().toString();
        String rutaImagen = editar_txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            editar_txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this, "Seleccione una una imagen de la galeria\n o capture una foto", Toast.LENGTH_SHORT).show();
            focusView = editar_txt_ruta_imagen;
            isValidRestaurante = false;
        }
        if (longitud.isEmpty()) {
            editar_txt_longitud.setError("Llenar Longitud");
            focusView = editar_txt_longitud;
            isValidRestaurante = false;
        }
        if (latitud.isEmpty()) {
            editar_txt_latitud.setError("Llenar Latitud");
            focusView = editar_txt_latitud;
            isValidRestaurante = false;
        }
        if (nombre.isEmpty()) {
            editar_txt_nombre.setError("Llenar Nombre");
            focusView = editar_txt_nombre;
            isValidRestaurante = false;
        }
        if (focusView != null) {
            focusView.requestFocus();
        }
        return isValidRestaurante;
    }

    private boolean isValidHotel() {
        boolean isValidHotel = true;
        editar_txt_nombre.setError(null);
        editar_txt_latitud.setError(null);
        editar_txt_longitud.setError(null);
        focusView = null;

        String nombre = editar_txt_nombre.getText().toString();
        String latitud = editar_txt_latitud.getText().toString();
        String longitud = editar_txt_longitud.getText().toString();
        String rutaImagen = editar_txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            editar_txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this, "Seleccione una una imagen de la galeria\n o capture una foto", Toast.LENGTH_SHORT).show();
            focusView = editar_txt_ruta_imagen;
            isValidHotel = false;
        }
        if (longitud.isEmpty()) {
            editar_txt_longitud.setError("Llenar Longitud");
            focusView = editar_txt_longitud;
            isValidHotel = false;
        }
        if (latitud.isEmpty()) {
            editar_txt_latitud.setError("Llenar Latitud");
            focusView = editar_txt_latitud;
            isValidHotel = false;
        }
        if (nombre.isEmpty()) {
            editar_txt_nombre.setError("Llenar Nombre");
            focusView = editar_txt_nombre;
            isValidHotel = false;
        }
        if (focusView != null) {
            focusView.requestFocus();
        }
        return isValidHotel;
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
}
