package com.hga.appturismo.bdSQLite;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;

import java.util.ArrayList;

import static com.hga.appturismo.bdSQLite.DBModel.TABLE_RESTAURANTES;

/**
 * Created by HGA on 21/7/2018
 */
public class SqliteHotel extends DBSQLiteParent implements SqliteInterface<ModeloHotel>{
    public SqliteHotel(Context context) {
        super(context);
    }

    public ArrayList<ModeloHotel> list() {
        ArrayList<ModeloHotel> hoteles = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_HOTELES, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloHotel modeloHotel = getHotelCursor(cursor);

                hoteles.add(modeloHotel);
                cursor.moveToNext();
            }
        }
        return hoteles;
    }

    @NonNull
    private ModeloHotel getHotelCursor(Cursor cursor) {
        ModeloHotel modeloHotel = new ModeloHotel();
        modeloHotel.setIdSQLite(cursor.getInt(cursor.getColumnIndex(DBModel.HOTELES_SQLITE_ID)));
        modeloHotel.setIdFirebase(cursor.getString(cursor.getColumnIndex(DBModel.HOTELES_ID_FIREBASE)));
        modeloHotel.setNombre(cursor.getString(cursor.getColumnIndex(DBModel.HOTELES_NAME)));
        modeloHotel.setDireccion(cursor.getString(cursor.getColumnIndex(DBModel.HOTELES_DIRECCION)));
        modeloHotel.setTelefono(cursor.getInt(cursor.getColumnIndex(DBModel.HOTELES_TELEFONO)));
        modeloHotel.setPaginaWeb(cursor.getString(cursor.getColumnIndex(DBModel.HOTELES_PAGINA_WEB)));
        modeloHotel.setEmail(cursor.getString(cursor.getColumnIndex(DBModel.HOTELES_EMAIL)));
        modeloHotel.setGpsX(cursor.getFloat(cursor.getColumnIndex(DBModel.HOTELES_LATITUD)));
        modeloHotel.setGpsY(cursor.getFloat(cursor.getColumnIndex(DBModel.HOTELES_LONGITUD)));
        modeloHotel.setRegistradoPor(cursor.getString(cursor.getColumnIndex(DBModel.HOTELES_REGISTRADO_POR)));
        modeloHotel.setEstado(cursor.getString(cursor.getColumnIndex(DBModel.HOTELES_ESTADO)));

        modeloHotel.setImagenes(getListaImagenes(ModeloImagen.TIPO_HOTEL, modeloHotel.getIdSQLite()));
        return modeloHotel;
    }

    public ModeloHotel getItem(String nombreMarcador) {
        ModeloHotel modeloHotel = new ModeloHotel();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_HOTELES
                + " where " + DBModel.HOTELES_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloHotel = getHotelCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloHotel;
    }

    public void insert(ModeloHotel modeloHotel) {
        helper.insertarHotel(db, modeloHotel);
    }

    @Override
    public void delete() {
        helper.deleteDatosHotel(db);
    }
    public void deletePuntaje(){
        helper.deleteDatosPuntaje(db);
    }

    public void update(ArrayList<ModeloHotel> modeloHotels) {
        helper.deleteDatosHotel(db);
        for (ModeloHotel modeloHotel : modeloHotels) {
            insert(modeloHotel);
        }
    }
}
