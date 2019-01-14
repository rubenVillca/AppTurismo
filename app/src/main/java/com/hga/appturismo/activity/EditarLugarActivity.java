package com.hga.appturismo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.bdSQLite.SqliteLugar;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;

import static java.lang.String.valueOf;

public class EditarLugarActivity extends EditarActivity {

    private ModeloLugarTuristico modeloLugarTuristicoOld;
    private ModeloLugarTuristico modeloLugarTuristicoNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setLugarTuristicoOld();
        iniciarVista();
        iniciarVistaSpinner(Constants.SELECT_LUGAR);
        mostrarDatosLugarTuristico();
        //mostrarImagenLugar();
        mostrarImagenLugarTuristico();
    }

    private void setLugarTuristicoOld() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.get("lugar") != null) {
            modeloLugarTuristicoOld = (ModeloLugarTuristico) bundle.get("lugar");
        }
    }

    protected void iniciarVista() {
        super.iniciarVista();

        editar_layout_email.setVisibility(View.GONE);
        editar_btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modeloLugarTuristicoOld != null) {
                    if (isValidLugarTuristico()) {
                        mostrarLugar();
                        guardarFirebaseLugarTuristico();
                        Toast.makeText(EditarLugarActivity.this, "Editado lugar " + modeloLugarTuristicoNew.getNombre(), Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent = new Intent(EditarLugarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mostrarImagenLugarTuristico() {
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
                        Picasso.with(EditarLugarActivity.this).load(uri.toString()).into(imageView);
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

    private void mostrarLugar() {
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
                        Constants.FIREBASE_STORAGE_URL_LUGAR_TURISTICO, modeloLugarTuristicoOld.getImagenes()
                )
        );
        modeloLugarTuristicoNew.setActividad(editar_txt_actividad.getText().toString());
        modeloLugarTuristicoNew.setDescripcion(editar_txt_descripcion.getText().toString());
        modeloLugarTuristicoNew.setHorario(editar_txt_horario.getText().toString());
        modeloLugarTuristicoNew.setDireccion(editar_txt_direccion.getText().toString());
        modeloLugarTuristicoNew.setTelefono(Long.parseLong(editar_txt_telefono.getText().toString()));
        modeloLugarTuristicoNew.setGpsX(Float.parseFloat(editar_txt_latitud.getText().toString()));
        modeloLugarTuristicoNew.setGpsY(Float.parseFloat(editar_txt_longitud.getText().toString()));
        modeloLugarTuristicoNew.setLinea(editar_txt_linea.getText().toString());
        modeloLugarTuristicoNew.setFecha(editar_txt_fecha.getText().toString());

        mostrarImagenLugarTuristico();
    }

    /**
     * Guardar los cambios del lugar turistico seleccionado en Firebase
     * si la provincia es diferento a la provincia inicial se eliminara el lugar turistico q este
     * en la provincia inicial
     */
    private void guardarFirebaseLugarTuristico() {
        app = (TurismoAplicacion) getApplicationContext();
        //subir datos a bdFirebase
        databaseReference = getPostReferenceProvincia(modeloLugarTuristicoNew.getIdFirebase(), modeloLugarTuristicoNew.getProvincia());
        databaseReference.setValue(modeloLugarTuristicoNew);
        if (!modeloLugarTuristicoNew.getProvincia().equals(modeloLugarTuristicoOld.getProvincia())) {
            databaseReference = getPostReferenceProvincia(modeloLugarTuristicoOld.getIdFirebase(), modeloLugarTuristicoOld.getProvincia());
            databaseReference.removeValue();
        }
        //actualizar sqlite
        SqliteLugar sqliteLugar=new SqliteLugar(this);
        sqliteLugar.remove(modeloLugarTuristicoOld);
        sqliteLugar.insert(modeloLugarTuristicoNew);

        //subir imagen a bdFirebase
        if (!mCurrentPhotoPath.isEmpty()) {
            File file = new File(mCurrentAbsolutePhotoPath);
            final Uri uri = Uri.fromFile(file);

            storageReference = app.getStorageReferenceLugarTuristico(ModeloUsuario.codificarNombre(modeloLugarTuristicoNew.getNombre()));
            StorageReference imageReference = storageReference.child(uri.getLastPathSegment());
            UploadTask uploadTask = imageReference.putFile(uri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditarLugarActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(EditarLugarActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void mostrarDatosLugarTuristico() {
        app = (TurismoAplicacion) getApplicationContext();

        editar_layout_tipo.setVisibility(View.GONE);
        editar_layout_pagina_web.setVisibility(View.GONE);

        String tipo= getString(R.string.tipo_acontecimientos_programados);
        if (modeloLugarTuristicoOld.getTipo().equals(tipo)) {
            editar_layout_fecha.setVisibility(View.VISIBLE);
        }else{
            editar_layout_fecha.setVisibility(View.GONE);
        }

        int idProvincia = getSelectedArray(modeloLugarTuristicoOld.getProvincia(),R.array.provincia);
        editar_spinner_provincia.setSelection(idProvincia);
        int idTipoTurismo = getSelectedArray(modeloLugarTuristicoOld.getTipo(),R.array.tipo_turismo);
        editar_spinner_tipo_turismo.setSelection(idTipoTurismo);

        editar_txt_nombre.setText(modeloLugarTuristicoOld.getNombre());
        editar_txt_actividad.setText(modeloLugarTuristicoOld.getActividad());
        editar_txt_descripcion.setText(modeloLugarTuristicoOld.getDescripcion());
        editar_txt_direccion.setText(modeloLugarTuristicoOld.getDireccion());
        editar_txt_telefono.setText(valueOf(modeloLugarTuristicoOld.getTelefono()));
        editar_txt_horario.setText(modeloLugarTuristicoOld.getHorario());
        editar_txt_latitud.setText(valueOf(modeloLugarTuristicoOld.getGpsX()));
        editar_txt_longitud.setText(valueOf(modeloLugarTuristicoOld.getGpsY()));
        editar_txt_linea.setText(modeloLugarTuristicoOld.getLinea());
        editar_txt_fecha.setText(modeloLugarTuristicoOld.getFecha());
    }

    private void mostrarImagenLugar() {
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
                        Picasso.with(EditarLugarActivity.this).load(uri.toString()).into(imageView);
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

    private boolean isValidLugarTuristico() {
        boolean isValidLugarTuristico = true;

        editar_txt_nombre.setError(null);
        editar_txt_actividad.setError(null);
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
        String actividad = editar_txt_actividad.getText().toString();
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
        if (actividad.isEmpty()) {
            editar_txt_actividad.setError("Llenar descripción");
            focusView = editar_txt_actividad;
            isValidLugarTuristico = false;
        }
        if (provincia.isEmpty()) {
            editar_txt_provincia.setError("Seleccione una provincia");
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

}
