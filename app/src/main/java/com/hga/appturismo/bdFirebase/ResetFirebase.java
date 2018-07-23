package com.hga.appturismo.bdFirebase;

import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.provider.Listas;

/**
 * Created by HGA on 8/7/2018
 */
public class ResetFirebase {
    private MainActivity mainActivity;
    private TurismoAplicacion app;

    public ResetFirebase(TurismoAplicacion app, MainActivity mainActivity) {
        this.app = app;
        this.mainActivity = mainActivity;
    }

    /**
     * Eliminar datos existentes en bdFirebase e insertar los datos de la clase Listas en bdFirebase
     */
    public void resetDatosFirebase() {
        Listas listas = new Listas();

        //ResetFirebaseUsuarios resetFirebaseUsuarios =new ResetFirebaseUsuarios(mainActivity);
        ResetFirebaseHoteles resetFirebaseHoteles=new ResetFirebaseHoteles();
        ResetFirebaseRestaurantes resetFirebaseRestaurantes=new ResetFirebaseRestaurantes();
        ResetFirebaseLugaresTour reserFirebaseLugaresTour=new ResetFirebaseLugaresTour();

        //resetFirebaseUsuarios.deleteUsuarios();
        resetFirebaseHoteles.deleteHoteles(app);
        resetFirebaseRestaurantes.deleteRestaurantes(app);
        reserFirebaseLugaresTour.deleteLugaresTuristicos(app);

        //resetFirebaseUsuarios.insertUsuarios(app,listas);
        resetFirebaseHoteles.insertHoteles(app, listas);
        resetFirebaseRestaurantes.insertRestaurantes(app, listas);
        reserFirebaseLugaresTour.insertLugaresTuristicos(app, listas);
    }
}
