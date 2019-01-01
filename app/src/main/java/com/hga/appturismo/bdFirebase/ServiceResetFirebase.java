package com.hga.appturismo.bdFirebase;

import android.widget.Toast;

import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.bdSQLite.SqliteUsuario;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.provider.Listas;
import com.hga.appturismo.provider.ListasPrueba;

import java.util.ArrayList;

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
        SqliteUsuario sqliteUsuario=new SqliteUsuario(mainActivity);

        ServiceFirebaseUsuarios resetFirebaseUsuarios =new ServiceFirebaseUsuarios(mainActivity);
        resetFirebaseUsuarios.delete(app,sqliteUsuario.list());
        resetFirebaseUsuarios.insert(app,listas);
    }
}
