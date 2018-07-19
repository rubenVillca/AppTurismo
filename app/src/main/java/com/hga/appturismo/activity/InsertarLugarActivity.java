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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.bdSQLite.DataBaseSync;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InsertarLugarActivity extends AppCompatActivity {
    private String email;

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static int SELECT_PICTURE = 3;
    private ImageView imageView;
    private String mCurrentPhotoPath;
    private String mCurrentAbsolutePhotoPath;
    private TextView txt_ruta_imagen;
    private TurismoAplicacion app;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    private EditText txt_nombre;
    private EditText txt_descripcion;
    private EditText txt_telefono;
    private EditText txt_horario;
    private EditText txt_latitud;
    private EditText txt_longitud;
    private EditText txt_direccion;
    private EditText txt_paginaweb;
    private EditText txt_email;
    private EditText txt_linea;
    private EditText txt_fecha;

    private Spinner spinnerProvincia;
    private Spinner spinnerTipoTurismo;
    private Spinner spinnerTipo;

    private LinearLayout layout_tipo;
    private LinearLayout layout_provincia;
    private LinearLayout layout_tipoTurismo;
    private LinearLayout layout_nombre;
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
        initSpinner();
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
    private ModeloHotel getHotel(DataBaseSync dataBaseSync) {
        ModeloHotel modeloHotel = new ModeloHotel();
        modeloHotel.setIdSQLite(dataBaseSync.getListaHoteles().size() + 1);
        modeloHotel.setNombre(txt_nombre.getText().toString());
        modeloHotel.setDireccion(txt_direccion.getText().toString());
        modeloHotel.setTelefonoString(txt_telefono.getText().toString());
        modeloHotel.setPaginaWeb(txt_paginaweb.getText().toString());
        modeloHotel.setEmail(txt_email.getText().toString());
        modeloHotel.setGpsX(Float.parseFloat(txt_latitud.getText().toString()));
        modeloHotel.setGpsY(Float.parseFloat(txt_longitud.getText().toString()));
        modeloHotel.setNombre(email);
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
        modeloImagen.setId(0);
        modeloImagen.setKey_id(id);
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
     * @param dataBaseSync:conexion a la base de datos SQLite
     * @return ModeloLugarTuristico:lugar turistico a insertar
     */
    @NonNull
    private ModeloLugarTuristico getLugarTuristico(DataBaseSync dataBaseSync) {
        ModeloLugarTuristico modeloLugarTuristico = new ModeloLugarTuristico();
        modeloLugarTuristico.setIdSQLite(dataBaseSync.getListaLugarTuristco().size() + 1);
        modeloLugarTuristico.setNombre(txt_nombre.getText().toString());
        modeloLugarTuristico.setTipo(spinnerTipoTurismo.getSelectedItem().toString());
        modeloLugarTuristico.setDescripcion(txt_descripcion.getText().toString());
        modeloLugarTuristico.setDireccion(txt_direccion.getText().toString());
        modeloLugarTuristico.setTelefonoString(txt_telefono.getText().toString());
        modeloLugarTuristico.setHorario(txt_horario.getText().toString());
        modeloLugarTuristico.setGpsX(Float.parseFloat(txt_latitud.getText().toString()));
        modeloLugarTuristico.setGpsY(Float.parseFloat(txt_longitud.getText().toString()));
        modeloLugarTuristico.setProvincia(spinnerProvincia.getSelectedItem().toString());
        modeloLugarTuristico.setLinea(txt_linea.getText().toString());
        modeloLugarTuristico.setFecha(txt_fecha.getText().toString());
        modeloLugarTuristico.setRegistradoPor(email);
        return modeloLugarTuristico;
    }

    @NonNull
    private ModeloRestaurante getRestaurante(DataBaseSync dataBaseSync) {
        ModeloRestaurante modeloRestaurante = new ModeloRestaurante();
        modeloRestaurante.setIdSQLite(dataBaseSync.getListaRestaurantes().size() + 1);
        modeloRestaurante.setNombre(txt_nombre.getText().toString());
        modeloRestaurante.setHorario(txt_horario.getText().toString());
        modeloRestaurante.setDireccion(txt_direccion.getText().toString());
        modeloRestaurante.setEmail(txt_email.getText().toString());
        modeloRestaurante.setTelefonoString(txt_telefono.getText().toString());
        modeloRestaurante.setGpsX(Float.parseFloat(txt_latitud.getText().toString()));
        modeloRestaurante.setGpsY(Float.parseFloat(txt_longitud.getText().toString()));
        modeloRestaurante.setRegistradoPor(email);

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
    private void guardarDatosFirebaseHotel(final ModeloHotel modeloHotel) {
        databaseReference = app.getDataBaseReferenceHotel("");
        File file = new File(mCurrentAbsolutePhotoPath);
        final Uri uri = Uri.fromFile(file);

        storageReference = app.getStorageReferenceHotel(modeloHotel.getNombre());
        StorageReference imageReference = storageReference.child(modeloHotel.getNombre() + "/" + uri.getLastPathSegment());

        UploadTask uploadTask = imageReference.putFile(uri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InsertarLugarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(InsertarLugarActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();

                //String imageURL = taskSnapshot.getDownloadUrl().toString();
                //String imageURL=Constants.FIREBASE_STORAGE_IMGS + uri.getLastPathSegment();
                databaseReference.push().setValue(modeloHotel);
            }
        });
    }

    /**
     * envia la imagen tomada por la camara al servidor bdFirebase
     */
    private void guardarDatosFirebaseLugarTuristico(final ModeloLugarTuristico modeloLugarTuristico) {
        File file = new File(mCurrentAbsolutePhotoPath);
        final Uri uri = Uri.fromFile(file);

        String provincia = modeloLugarTuristico.getProvincia();
        switch (provincia) {
            case "Arani":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARANI);
                break;
            case "Arque":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARQUE);
                break;
            case "Ayopaya":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_AYOPAYA);
                break;
            case "Bolivar":
            case "Bolívar":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_BOLIVAR);
                break;
            case "Narciso Campero":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAMPERO);
                break;
            case "Capinota":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAPINOTA);
                break;
            case "Cercado":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CERCADO);
                break;
            case "Chapare":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CHAPARE);
                break;
            case "Esteban Arze":
            case "Esteban Arce":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
                break;
            case "German Jordan":
            case "Germán Jordán":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
                break;
            case "Jose Carrasco":
            case "José Carrasco":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO);
                break;
            case "Mizque":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_MIZQUE);
                break;
            case "Punata":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_PUNATA);
                break;
            case "Quillacollo":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
                break;
            case "Tapacari":
            case "Tapacarí":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TAPACARI);
                break;
            case "Tiraque":
                databaseReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TIRAQUE);
                break;
            default:
                break;
        }
        storageReference = app.getStorageReferenceLugarTuristico("");
        StorageReference imageReference = storageReference.child(modeloLugarTuristico.getNombre() + "/" + uri.getLastPathSegment());

        UploadTask uploadTask = imageReference.putFile(uri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InsertarLugarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(InsertarLugarActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();

                //String imageURL = taskSnapshot.getDownloadUrl().toString();
                //String imageURL=Constants.FIREBASE_STORAGE_IMGS + uri.getLastPathSegment();
                databaseReference.push().setValue(modeloLugarTuristico);
            }
        });
    }

    /**
     * enviar los datos recuperados del activity al servidor bdFirebase
     */
    private void guardarDatosFirebaseRestaurante(final ModeloRestaurante modeloRestaurante) {
        databaseReference = app.getDataBaseReferenceRestaurante("");
        File file = new File(mCurrentAbsolutePhotoPath);
        final Uri uri = Uri.fromFile(file);

        storageReference = app.getStorageReferenceRestaurante(modeloRestaurante.getNombre());
        StorageReference imageReference = storageReference.child(modeloRestaurante.getNombre() + "/" + uri.getLastPathSegment());

        UploadTask uploadTask = imageReference.putFile(uri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(InsertarLugarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(InsertarLugarActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();
                //String imageURL = taskSnapshot.getDownloadUrl().toString();
                //String imageURL=Constants.FIREBASE_STORAGE_IMGS + uri.getLastPathSegment();
                databaseReference.push().setValue(modeloRestaurante);
            }
        });
    }

    private void iniciarLayout() {
        layout_tipo = findViewById(R.id.layout_tipo);
        layout_provincia = findViewById(R.id.layout_provincia);
        layout_tipoTurismo = findViewById(R.id.layout_tipoTurismo);
        layout_nombre = findViewById(R.id.layout_nombre);
        layout_descripcion = findViewById(R.id.layout_descripcion);
        layout_email = findViewById(R.id.layout_email);
        layout_direccion = findViewById(R.id.layout_direccion);
        layout_pagina_web = findViewById(R.id.layout_pagina_web);
        layout_telefono = findViewById(R.id.layout_telefono);
        layout_horario = findViewById(R.id.layout_horario);
        layout_latitud = findViewById(R.id.layout_latitud);
        layout_longitud = findViewById(R.id.layout_longitud);
        layout_fecha = findViewById(R.id.layout_fechaTurismo);
        layout_linea= findViewById(R.id.layout_lineaTurismo);
        layout_imagen = findViewById(R.id.layout_imagen);
    }

    private void iniciarValores() {
        imageView = findViewById(R.id.insertar_imagen);
        txt_ruta_imagen = findViewById(R.id.ruta_imagen);

        spinnerProvincia = findViewById(R.id.spinner_provincia);
        spinnerTipoTurismo = findViewById(R.id.spinner_tipo_turismo);
        spinnerTipo = findViewById(R.id.spinner_tipo);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_direccion = findViewById(R.id.txt_direccion);
        txt_telefono = findViewById(R.id.txt_telefono);
        txt_paginaweb = findViewById(R.id.txt_paginaweb);
        txt_email = findViewById(R.id.txt_email);
        txt_latitud = findViewById(R.id.txt_latitud);
        txt_longitud = findViewById(R.id.txt_longitud);
        txt_descripcion = findViewById(R.id.txt_descripcion);
        txt_horario = findViewById(R.id.txt_horario);
        txt_linea = findViewById(R.id.txt_linea);
        txt_fecha = findViewById(R.id.txt_fecha);
    }

    /**
     * agregar los valores de los spinner en el activity insertar
     * -spinner provincia(cercado, quillacollo,etc)
     * -spinner tipo lugar(arquitectonico, etc..)
     * -spinner tipo insercion(hotel, restarutanre, lugar turistico)
     */
    private void initSpinner() {
        //spinnerProvincia
        ArrayAdapter<CharSequence> adapterProvincia = ArrayAdapter.createFromResource(this, R.array.provincia, android.R.layout.simple_spinner_item);
        adapterProvincia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincia.setAdapter(adapterProvincia);

        ArrayAdapter<CharSequence> adapterTipoTurismo = ArrayAdapter.createFromResource(this, R.array.tipo_turismo, android.R.layout.simple_spinner_item);
        adapterTipoTurismo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoTurismo.setAdapter(adapterTipoTurismo);
        spinnerTipoTurismo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 4://acontecimiento en un lugar turistico
                        layout_tipo.setVisibility(View.VISIBLE);
                        layout_provincia.setVisibility(View.VISIBLE);
                        layout_tipoTurismo.setVisibility(View.VISIBLE);
                        layout_nombre.setVisibility(View.VISIBLE);
                        layout_descripcion.setVisibility(View.VISIBLE);
                        layout_email.setVisibility(View.VISIBLE);
                        layout_direccion.setVisibility(View.VISIBLE);
                        layout_pagina_web.setVisibility(View.GONE);
                        layout_telefono.setVisibility(View.VISIBLE);
                        layout_horario.setVisibility(View.VISIBLE);
                        layout_latitud.setVisibility(View.VISIBLE);
                        layout_longitud.setVisibility(View.VISIBLE);
                        layout_imagen.setVisibility(View.VISIBLE);
                        break;
                        default:
                            layout_linea.setVisibility(View.GONE);
                            layout_fecha.setVisibility(View.GONE);
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
                        layout_descripcion.setVisibility(View.VISIBLE);
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
                        layout_descripcion.setVisibility(View.VISIBLE);
                        layout_email.setVisibility(View.GONE);
                        layout_direccion.setVisibility(View.VISIBLE);
                        layout_pagina_web.setVisibility(View.GONE);
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
                        layout_descripcion.setVisibility(View.VISIBLE);
                        layout_email.setVisibility(View.VISIBLE);
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
     * envia los datos llenados  en la vista al servidro bdFirebase
     * tambien los almacena en la base de datos interna SQLite
     * PD: la imagen tomada tambien es enviada al servidor fireBase
     *
     * @param view:parametros del boton presionado
     */
    public void insertarLugarSQLite(View view) {
        DataBaseSync dataBaseSync = new DataBaseSync(this);
        ArrayList<ModeloImagen> modeloImagenArrayList;
        Intent intent;

        switch (spinnerTipo.getSelectedItemPosition()) {
            case 0://hotel
                if (isValidHotel()) {
                    ModeloHotel modeloHotel = getHotel(dataBaseSync);
                    modeloImagenArrayList = getImagen(ModeloImagen.TIPO_HOTEL, modeloHotel.getIdSQLite(), ModeloImagen.TIPO_HOTEL + "/" + modeloHotel.getNombre());
                    modeloHotel.setImagenes(modeloImagenArrayList);
                    dataBaseSync.insertarHotel(modeloHotel);//insertar modeloHotel en SQLite

                    guardarDatosFirebaseHotel(modeloHotel);
                    intent = new Intent(this, MapaHotelesActivity.class);
                    startActivity(intent);
                }
                break;
            case 1://restaurante
                if (isValidRestaurante()) {
                    ModeloRestaurante modeloRestaurante = getRestaurante(dataBaseSync);
                    modeloImagenArrayList = getImagen(ModeloImagen.TIPO_RESTAURANTE, modeloRestaurante.getIdSQLite(), ModeloImagen.TIPO_RESTAURANTE + "/" + modeloRestaurante.getNombre());
                    modeloRestaurante.setImagenesFirebase(modeloImagenArrayList);
                    dataBaseSync.insertarRestaurante(modeloRestaurante);//insertar restaurate en SQLite

                    guardarDatosFirebaseRestaurante(modeloRestaurante);
                    intent = new Intent(this, MapaRestaurantesActivity.class);
                    startActivity(intent);
                }
                break;
            case 2://lugar turistico
                if (isValidLugarTuristico()) {
                    ModeloLugarTuristico modeloLugarTuristico = getLugarTuristico(dataBaseSync);
                    modeloImagenArrayList = getImagen(ModeloImagen.TIPO_LUGAR, modeloLugarTuristico.getIdSQLite(), ModeloImagen.TIPO_LUGAR + "/" + modeloLugarTuristico.getNombre());
                    modeloLugarTuristico.setImagenesFirebase(modeloImagenArrayList);
                    dataBaseSync.insertarLugarTuristico(modeloLugarTuristico);//insetar el lugar turistico en SQLite

                    guardarDatosFirebaseLugarTuristico(modeloLugarTuristico);
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
        txt_descripcion.setError(null);
        txt_latitud.setError(null);
        txt_longitud.setError(null);
        txt_ruta_imagen.setError(null);
        focusView=null;
        //para el error en spinner provincia
        TextView txt_provincia = (TextView) spinnerProvincia.getSelectedView();
        txt_provincia.setError(null);
        txt_provincia.setTextColor(Color.RED);//just to highlight that this is an error

        String provincia = txt_provincia.getText().toString();
        String nombre = txt_nombre.getText().toString();
        String descripcion = txt_descripcion.getText().toString();
        String latitud = txt_latitud.getText().toString();
        String longitud = txt_longitud.getText().toString();
        String rutaImagen=txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this,"Seleccione una una imagen de la galeria\n o capture una foto",Toast.LENGTH_SHORT).show();
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
        if (descripcion.isEmpty()) {
            txt_descripcion.setError("Llenar descripción");
            focusView = txt_descripcion;
            isValidLugarTuristico = false;
        }
        if (provincia.isEmpty()) {
            txt_provincia.setError("Seleccione una Provincia");
            focusView = txt_provincia;
            isValidLugarTuristico = false;
        }
        if (nombre.isEmpty()) {
            txt_nombre.setError("Llenar Nombre");
            focusView = txt_nombre;
            isValidLugarTuristico = false;
        }
        if (focusView!=null) {
            focusView.requestFocus();
        }
        return isValidLugarTuristico;
    }

    private boolean isValidRestaurante() {
        boolean isValidRestaurante = true;
        txt_nombre.setError(null);
        txt_latitud.setError(null);
        txt_longitud.setError(null);
        focusView=null;
        String nombre = txt_nombre.getText().toString();
        String latitud = txt_latitud.getText().toString();
        String longitud = txt_longitud.getText().toString();
        String rutaImagen=txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this,"Seleccione una una imagen de la galeria\n o capture una foto",Toast.LENGTH_SHORT).show();
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
        if (focusView!=null) {
            focusView.requestFocus();
        }
        return isValidRestaurante;
    }

    private boolean isValidHotel() {
        boolean isValidHotel = true;
        txt_nombre.setError(null);
        txt_latitud.setError(null);
        txt_longitud.setError(null);
        focusView=null;

        String nombre = txt_nombre.getText().toString();
        String latitud = txt_latitud.getText().toString();
        String longitud = txt_longitud.getText().toString();
        String rutaImagen=txt_ruta_imagen.getText().toString();

        if (rutaImagen.isEmpty()) {
            txt_ruta_imagen.setError("Seleccione una una imagen de la galeria\n o capture una foto");
            Toast.makeText(this,"Seleccione una una imagen de la galeria\n o capture una foto",Toast.LENGTH_SHORT).show();
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
        if (focusView!=null) {
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
