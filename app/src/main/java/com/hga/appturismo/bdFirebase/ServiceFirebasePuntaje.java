package com.hga.appturismo.bdFirebase;

import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class ServiceFirebasePuntaje {

    /**
     * eliminar hoteles bdFirebase
     * @param app: conexion a la bd
     */
    public void deletePuntaje(TurismoAplicacion app) {
        DatabaseReference postReference;
        postReference = app.getDataBaseReferencePuntaje();
        postReference.removeValue();
    }

    public void deletePuntaje(TurismoAplicacion app, ModeloPuntaje modeloPuntaje) {
        DatabaseReference postReference;
        postReference = app.getDataBaseReferencePuntaje(modeloPuntaje.getIdFirebase());
        postReference.removeValue();
    }
}
