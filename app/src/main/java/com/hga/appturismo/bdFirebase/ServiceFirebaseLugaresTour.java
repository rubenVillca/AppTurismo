package com.hga.appturismo.bdFirebase;

import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.provider.Listas;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
class ServiceFirebaseLugaresTour {
    public void insertLugaresTuristicos(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference;//insertar lugares turisticos por provincia
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = listas.getListaLugares();

        for (ModeloLugarTuristico modeloLugarTuristico : modeloLugarTuristicos) {
            String provincia = modeloLugarTuristico.getProvincia();
            postReference = getDatabaseReferenceProvincia(app, provincia);
            postReference.push().setValue(modeloLugarTuristico);
        }
    }

    public void deleteLugaresTuristicos(TurismoAplicacion app) {
        DatabaseReference postReference;//eliinar lugares turisticos bdFirebase
        postReference = app.getDataBaseReferenceLugarTuristico("");
        postReference.removeValue();
    }

    private DatabaseReference getDatabaseReferenceProvincia(TurismoAplicacion app, String provincia) {
        DatabaseReference postReference;
        switch (provincia) {
            case Constants.FIREBASE_PROVINCIA_ARANI:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARANI);
                break;
            case Constants.FIREBASE_PROVINCIA_ARQUE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ARQUE);
                break;
            case Constants.FIREBASE_PROVINCIA_AYOPAYA:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_AYOPAYA);
                break;
            case Constants.FIREBASE_PROVINCIA_BOLIVAR:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_BOLIVAR);
                break;
            case Constants.FIREBASE_PROVINCIA_CAMPERO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAMPERO);
                break;
            case Constants.FIREBASE_PROVINCIA_CAPINOTA:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CAPINOTA);
                break;
            case Constants.FIREBASE_PROVINCIA_CERCADO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CERCADO);
                break;
            case Constants.FIREBASE_PROVINCIA_CHAPARE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_CHAPARE);
                break;
            case Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
                break;
            case Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
                break;
            case Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO);
                break;
            case Constants.FIREBASE_PROVINCIA_MIZQUE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_MIZQUE);
                break;
            case Constants.FIREBASE_PROVINCIA_PUNATA:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_PUNATA);
                break;
            case Constants.FIREBASE_PROVINCIA_QUILLACOLLO:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
                break;
            case Constants.FIREBASE_PROVINCIA_TAPACARI:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TAPACARI);
                break;
            case Constants.FIREBASE_PROVINCIA_TIRAQUE:
                postReference = app.getDataBaseReferenceLugarTuristico(Constants.FIREBASE_PROVINCIA_TIRAQUE);
                break;
            default:
                postReference = app.getDataBaseReferenceLugarTuristico("");
                break;
        }
        return postReference;
    }
}
