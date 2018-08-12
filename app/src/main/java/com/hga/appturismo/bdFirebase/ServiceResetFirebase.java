package com.hga.appturismo.bdFirebase;

import android.widget.Toast;

import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.provider.Listas;

/**
 * Created by HGA on 8/7/2018
 */
public class ServiceResetFirebase {
    private MainActivity mainActivity;
    private TurismoAplicacion app;
    private Listas listas;

    public ServiceResetFirebase(MainActivity mainActivity) {
        app = (TurismoAplicacion) mainActivity.getApplicationContext();
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
        resetUsuarios();

        Toast.makeText(mainActivity,"Actualizado firebase",Toast.LENGTH_LONG).show();
    }

    private void resetHoteles() {
        ServiceFirebaseHoteles serviceFirebaseHoteles =new ServiceFirebaseHoteles();
        serviceFirebaseHoteles.deleteHoteles(app);
        serviceFirebaseHoteles.insertHoteles(app,listas);
    }

    private void resetRestaurantes() {
        ServiceFirebaseRestaurantes ServiceFirebaseRestaurantes =new ServiceFirebaseRestaurantes();
        ServiceFirebaseRestaurantes.deleteRestaurantes(app);
        ServiceFirebaseRestaurantes.insertRestaurantes(app, listas);
    }

    private void resetLugares() {
        ServiceFirebaseLugaresTour serviceFirebaseLugaresTour =new ServiceFirebaseLugaresTour();
        serviceFirebaseLugaresTour.deleteLugaresTuristicos(app);
        serviceFirebaseLugaresTour.insertLugaresTuristicos(app, listas);
    }

    private void resetUsuarios(){
        ServiceFirebaseUsuarios resetFirebaseUsuarios =new ServiceFirebaseUsuarios(mainActivity);
        resetFirebaseUsuarios.delete();
        resetFirebaseUsuarios.insert(app,listas);
    }
}
