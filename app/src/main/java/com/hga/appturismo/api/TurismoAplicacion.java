package com.hga.appturismo.api;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hga.appturismo.util.Constants;

/**
 * Created by HGA on 17/08/2017
 */

public class TurismoAplicacion extends Application {
    //imagnes
    private FirebaseStorage firebaseStorage;
    //bd firebase
    private FirebaseDatabase firebaseDatabase;

    public TurismoAplicacion() {

    }
    @Override
    public void onCreate() {
        super.onCreate();

        //ruta imagenes
        firebaseStorage = FirebaseStorage.getInstance();

        //ruta BD
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
    }

    public StorageReference getStorageReferenceHotel(String nombre) {
        return firebaseStorage.getReferenceFromUrl(Constants.FIREBASE_STORAGE_URL+Constants.FIREBASE_STORAGE_URL_HOTEL + nombre);
    }

    public StorageReference getStorageReferenceRestaurante(String nombre) {
        return firebaseStorage.getReferenceFromUrl(Constants.FIREBASE_STORAGE_URL+Constants.FIREBASE_STORAGE_URL_RESTAURANTE + nombre);
    }

    public StorageReference getStorageReferenceLugarTuristico(String ruta) {
        return firebaseStorage.getReferenceFromUrl(Constants.FIREBASE_STORAGE_URL+Constants.FIREBASE_STORAGE_URL_LUGAR_TURISTICO + ruta);
    }
    public StorageReference getStorageReferenceImagen(String ruta) {
        return firebaseStorage.getReferenceFromUrl(Constants.FIREBASE_STORAGE_URL + ruta);
    }
    /**
    * base de datos hotel firebase
    * */
    public DatabaseReference getDataBaseReferenceHotel() {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_HOTEL);
    }

    /**
     * base de datos restaurante firebase
     * */
    public DatabaseReference getDataBaseReferenceRestaurante() {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_RESTAURANTE);
    }

    /**
     * base de datos lugar turistico firebase
     * */
    public DatabaseReference getDataBaseReferenceLugarTuristico(String provincia) {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_LUGAR_TURISTICO +"/"+provincia);
    }

    /**
     * base de datos usuario firebase
     * */
    public DatabaseReference getDataBaseReferenceUsuario() {
        return  firebaseDatabase.getReference(Constants.FIREBASE_BASE_URL+Constants.FIREBASE_DATABASE_USUARIO);
    }

    /**
     * base de datos puntaje firebase
     * */
    public DatabaseReference getDataBaseReferencePuntaje() {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_PUNTAJE);
    }


    /**
     * /**
     * base de datos hotel firebase
     * @param idFirebase: ide de firebase
     * @return DatabaseReference
     */
    public DatabaseReference getDataBaseReferenceHotel(String idFirebase) {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_HOTEL+"/"+idFirebase);
    }

    /**
     * base de datos restaurante firebase
     * */
    public DatabaseReference getDataBaseReferenceRestaurante(String idFirebase) {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_RESTAURANTE+"/"+idFirebase);
    }

    /**
     * base de datos lugar turistico firebase
     * */
    public DatabaseReference getDataBaseReferenceLugarTuristico(String provincia,String idFirebase) {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_LUGAR_TURISTICO +"/"+provincia+"/"+idFirebase);
    }

    /**
     * base de datos usuario firebase
     * */
    public DatabaseReference getDataBaseReferenceUsuario(String idFirebase) {
        return  firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_USUARIO+"/"+idFirebase);
    }

    /**
     * base de datos puntaje firebase
     * */
    public DatabaseReference getDataBaseReferencePuntaje(String idFirebase) {
        return firebaseDatabase.getReference(Constants.FIREBASE_DATABASE_PUNTAJE+"/"+idFirebase);
    }
}
