package com.hga.appturismo.bdFirebase;

import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class ServiceFirebaseHoteles {

    /**
     * insertar hoteles
     *
     * @param app:    conexion a la bd
     * @param listas: listas por defecto
     */
    public void insertHoteles(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference = app.getDataBaseReferenceHotel("");
        ArrayList<ModeloHotel> listHotel = listas.getListaHoteles();
        for (ModeloHotel hotel : listHotel) {
            postReference.push().setValue(hotel);
        }
    }

    /**
     * eliminar hoteles bdFirebase
     *
     * @param app: conexion a la bd
     */
    public void deleteHoteles(TurismoAplicacion app) {
        DatabaseReference postReference = app.getDataBaseReferenceHotel("");
        postReference.removeValue();
    }

    public void deleteHotel(TurismoAplicacion app, ModeloHotel modeloHotel) {
        DatabaseReference postReference = app.getDataBaseReferenceHotel(modeloHotel.getIdFirebase());
        postReference.removeValue();
    }
}
