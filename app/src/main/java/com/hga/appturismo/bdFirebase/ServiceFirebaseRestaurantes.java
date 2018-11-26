package com.hga.appturismo.bdFirebase;

import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class ServiceFirebaseRestaurantes {

    public void deleteRestaurantes(TurismoAplicacion app) {
        DatabaseReference postReference;//eliminar restaurantes bdFirebase
        postReference = app.getDataBaseReferenceRestaurante("");
        postReference.removeValue();
    }

    public void insertRestaurantes(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference;//insertar restaurantes
        postReference = app.getDataBaseReferenceRestaurante("");
        ArrayList<ModeloRestaurante> restaurantes = listas.getListaRestaurantes();
        for (ModeloRestaurante r : restaurantes) {
            postReference.push().setValue(r);
        }
    }

    public void deleteRestaurante(TurismoAplicacion app, ModeloRestaurante modeloRestaurante) {
        DatabaseReference postReference;//eliminar restaurantes bdFirebase
        postReference = app.getDataBaseReferenceRestaurante(modeloRestaurante.getIdFirebase());
        postReference.removeValue();
    }
}
