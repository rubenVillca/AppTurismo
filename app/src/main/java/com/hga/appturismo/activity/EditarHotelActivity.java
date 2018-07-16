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
import com.hga.appturismo.R;
import com.hga.appturismo.bdFirebase.TurismoAplicacion;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.util.Constants;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class EditarHotelActivity extends EditarActivity {
    private ModeloHotel modeloHotelOld;
    private ModeloHotel modeloHotelNew;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        app = (TurismoAplicacion) getApplicationContext();

        recuperarDatosModelo();
        iniciarVista();
        iniciarVistaSpinner(Constants.SELECT_HOTEL);
        mostrarDatosHotel();
    }

    private void recuperarDatosModelo() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.get("modeloHotel") != null) {
            modeloHotelOld = (ModeloHotel) bundle.get("modeloHotel");
        }
    }

    protected void iniciarVista() {
        super.iniciarVista();

        editar_btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modeloHotelOld != null) {
                    if (isValidHotel()) {
                        mostrarHotel();
                        guardarFirebaseHotel();
                        Toast.makeText(EditarHotelActivity.this, "Editado hotel " + modeloHotelNew.getNombre(), Toast.LENGTH_SHORT).show();
                    }
                }

                Intent intent = new Intent(EditarHotelActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if (modeloHotelOld != null) {
            mostrarImagenHotel();
        }
    }

    private void mostrarImagenHotel() {
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
                        Picasso.with(EditarHotelActivity.this).load(uri.toString()).into(imageView);
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

    @NonNull
    private ArrayList<ModeloImagen> getModeloImagens(String tipo, int id, String ruta) {
        return super.getModeloImagens(tipo, id, ruta, modeloHotelOld.getImagenes());
    }


    private void mostrarHotel() {
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
        //subir datos a bdFirebase
        databaseReference = app.getDataBaseReferenceHotel();
        databaseReference.child(modeloHotelNew.getIdFirebase()).setValue(modeloHotelNew);
        if (!mCurrentPhotoPath.isEmpty()) {
            //subir imagen a bdFirebase
            File file = new File(mCurrentAbsolutePhotoPath);
            final Uri uri = Uri.fromFile(file);

            storageReference = app.getStorageReferenceHotel("");
            StorageReference imageReference = storageReference.child(uri.getLastPathSegment());
            UploadTask uploadTask = imageReference.putFile(uri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditarHotelActivity.this, "Error al subir la imagen", Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(EditarHotelActivity.this, "ModeloImagen subida con exito", Toast.LENGTH_LONG).show();
                }
            });
        }
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
                        Picasso.with(EditarHotelActivity.this).load(uri.toString()).into(imageView);
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

}
