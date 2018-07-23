package com.hga.appturismo.bdFirebase;

import com.google.firebase.database.DatabaseReference;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class ResetFirebaseHoteles {
    public void insertHoteles(TurismoAplicacion app, Listas listas) {
        DatabaseReference postReference;//insertar hoteles
        postReference = app.getDataBaseReferenceHotel("");
        ArrayList<ModeloHotel> listHotel = listas.getListaHoteles();
        for (ModeloHotel hotel : listHotel) {
            postReference.push().setValue(hotel);
        }
    }

    public void deleteHoteles(TurismoAplicacion app) {
        DatabaseReference postReference;//eliminar hoteles bdFirebase
        postReference = app.getDataBaseReferenceHotel("");
        postReference.removeValue();
    }
}
