package com.hga.appturismo.bdFirebase;

import android.widget.Toast;

import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.provider.Listas;

/**
 * Created by HGA on 8/7/2018
 */
public class ResetFirebase {
    private MainActivity mainActivity;
    private TurismoAplicacion app;
    private Listas listas;

    public ResetFirebase(TurismoAplicacion app, MainActivity mainActivity) {
        this.app = app;
        this.mainActivity = mainActivity;
        listas=new Listas();
    }

    /**
     * Eliminar datos existentes en bdFirebase e insertar los datos de la clase Listas en bdFirebase
     */
    public void resetDatosFirebase() {
        resetHoteles();
        resetRestaurantes();
        resetLugares();
        //resetUsuarios(true);

        Toast.makeText(mainActivity,"Actualizado firebase",Toast.LENGTH_LONG).show();
    }

    private void resetHoteles() {
        ResetFirebaseHoteles resetFirebaseHoteles=new ResetFirebaseHoteles();
        resetFirebaseHoteles.deleteHoteles(app);
        resetFirebaseHoteles.insertHoteles(app,listas);
    }

    private void resetRestaurantes() {
        ResetFirebaseRestaurantes resetFirebaseRestaurantes=new ResetFirebaseRestaurantes();
        resetFirebaseRestaurantes.deleteRestaurantes(app);
        resetFirebaseRestaurantes.insertRestaurantes(app, listas);
    }

    private void resetLugares() {
        ResetFirebaseLugaresTour resetFirebaseLugaresTour=new ResetFirebaseLugaresTour();
        resetFirebaseLugaresTour.deleteLugaresTuristicos(app);
        resetFirebaseLugaresTour.insertLugaresTuristicos(app, listas);
    }

    private void resetUsuarios(){
        ResetFirebaseUsuarios resetFirebaseUsuarios =new ResetFirebaseUsuarios(mainActivity);
        resetFirebaseUsuarios.deleteUsuarios();
        resetFirebaseUsuarios.insertUsuarios(app,listas);
    }
}
