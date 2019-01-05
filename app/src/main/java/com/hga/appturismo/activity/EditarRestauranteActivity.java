package com.hga.appturismo.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;

import static java.lang.String.valueOf;

public class EditarRestauranteActivity extends EditarActivity {

    private ModeloRestaurante modeloRestauranteOld;
    private ModeloRestaurante modeloRestauranteNew;

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

        recuperarDatosModelo();
        iniciarVista();
        iniciarVistaSpinner(Constants.SELECT_RESTAURANTE);
        mostrarDatosRestaurante();
    }

    private void recuperarDatosModelo() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.get("modeloRestaurante") != null) {
            modeloRestauranteOld = (ModeloRestaurante) bundle.get("modeloRestaurante");
        }
    }

    protected void iniciarVista() {
        super.iniciarVista();
        editar_btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modeloRestauranteOld != null) {
                    if (isValidRestaurante()) {
                        mostrarRestaurante();
                        guardarFirebaseRestaurante();
                        Toast.makeText(EditarRestauranteActivity.this, "Editado restaurante " + modeloRestauranteNew.getNombre(), Toast.LENGTH_SHORT).show();
                    /*Intent intent=new Intent(EditarActivity.this,ListaRestaurantesActivity.class);
                    startActivity(intent);*/
                    }
                }

                Intent intent = new Intent(EditarRestauranteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        if (modeloRestauranteOld != null) {
            mostrarImagenRestaurante();
        }
    }

    private void mostrarImagenRestaurante() {
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
                        Picasso.with(EditarRestauranteActivity.this).load(uri.toString()).into(imageView);
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

    private void mostrarRestaurante() {
        modeloRestauranteNew = new ModeloRestaurante();
        modeloRestauranteNew.setNombre(editar_txt_nombre.getText().toString());
        modeloRestauranteNew.setDescripcion(editar_txt_descripcion.getText().toString());
        modeloRestauranteNew.setLinea(editar_txt_linea.getText().toString());
        modeloRestauranteNew.setGpsX(Float.parseFloat(editar_txt_latitud.getText().toString()));
        modeloRestauranteNew.setGpsY(Float.parseFloat(editar_txt_longitud.getText().toString()));
        modeloRestauranteNew.setDireccion(editar_txt_direccion.getText().toString());
        modeloRestauranteNew.setIdSQLite(modeloRestauranteOld.getIdSQLite());
        modeloRestauranteNew.setIdFirebase(modeloRestauranteOld.getIdFirebase());
        modeloRestauranteNew.setTelefono(Long.parseLong(editar_txt_telefono.getText().toString()));
        modeloRestauranteNew.setEmail(editar_txt_email.getText().toString());
        modeloRestauranteNew.setHorario(editar_txt_horario.getText().toString());
        modeloRestauranteNew.setProvincia(editar_spinner_provincia.getSelectedItem().toString());
        modeloRestauranteNew.setPaginaWeb(editar_txt_paginaweb.getText().toString());
        modeloRestauranteNew.setImagenesFirebase(
                getModeloImagens(ModeloImagen.TIPO_RESTAURANTE,
                        modeloRestauranteNew.getIdSQLite(),
                        Constants.FIREBASE_STORAGE_URL_RESTAURANTE,
                        modeloRestauranteOld.getImagenes())
        );
    }

    /**
     * Guardar los cambios del restaurante seleccionado en Firebase
     */
    private void guardarFirebaseRestaurante() {
        app = (TurismoAplicacion) getApplicationContext();
        //subir datos a bdFirebase
        databaseReference = app.getDataBaseReferenceRestaurante();
        databaseReference.child(modeloRestauranteNew.getIdFirebase()).setValue(modeloRestauranteNew);
        if (!mCurrentPhotoPath.isEmpty()) {
            //subir imagen a bdFirebase
            File file = new File(mCurrentAbsolutePhotoPath);
            final Uri uri = Uri.fromFile(file);

            storageReference = app.getStorageReferenceRestaurante("");
            StorageReference imageReference = storageReference.child(uri.getLastPathSegment());
            UploadTask uploadTask = imageReference.putFile(uri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditarRestauranteActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(EditarRestauranteActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void mostrarDatosRestaurante() {
        app = (TurismoAplicacion) getApplicationContext();
        editar_layout_provincia.setVisibility(View.GONE);
        editar_layout_tipoTurismo.setVisibility(View.GONE);
        editar_layout_descripcion.setVisibility(View.VISIBLE);
        editar_layout_pagina_web.setVisibility(View.GONE);
        editar_layout_linea.setVisibility(View.VISIBLE);
        editar_layout_fecha.setVisibility(View.GONE);
        editar_layout_direccion.setVisibility(View.VISIBLE);
        editar_layout_latitud.setVisibility(View.VISIBLE);
        editar_layout_longitud.setVisibility(View.VISIBLE);
        editar_layout_email.setVisibility(View.VISIBLE);
        editar_layout_horario.setVisibility(View.VISIBLE);
        editar_layout_telefono.setVisibility(View.VISIBLE);

        //editar_spinner_tipo.setText(modeloRestauranteOld.get());
        //editar_spinner_provincia.setText(modeloRestauranteOld.get());
        //editar_spinner_tipo_turismo.setText(modeloRestauranteOld.get());
        editar_txt_nombre.setText(modeloRestauranteOld.getNombre());
        editar_txt_descripcion.setText(modeloRestauranteOld.getDescripcion());
        editar_txt_linea.setText(modeloRestauranteOld.getLinea());
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
                        Picasso.with(EditarRestauranteActivity.this).load(uri.toString()).into(imageView);
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

    private boolean isValidRestaurante() {
        boolean isValidRestaurante = true;
        editar_txt_nombre.setError(null);
        editar_txt_descripcion.setError(null);
        editar_txt_latitud.setError(null);
        editar_txt_longitud.setError(null);
        focusView = null;
        String nombre = editar_txt_nombre.getText().toString();
        String descripcion = editar_txt_descripcion.getText().toString();
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
        if (descripcion.isEmpty()) {
            editar_txt_descripcion.setError("Llenar Actividad");
            focusView = editar_txt_descripcion;
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
}
