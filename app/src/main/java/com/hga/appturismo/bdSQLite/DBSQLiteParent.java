package com.hga.appturismo.bdSQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloPuntaje;

import java.util.ArrayList;

/**
 * Created by HGA on 05/07/2017
 */

public abstract class DBSQLiteParent {
    protected DBModel helper;
    protected SQLiteDatabase db;

    public DBSQLiteParent(Context context) {
        helper = new DBModel(context, DBModel.DATABASE_NAME, null, DBModel.DATABASE_VERSION);
        db = helper.getWritableDatabase();
    }

    protected ArrayList<ModeloImagen> getListaImagenes(String type, int idKeyType) {
        ArrayList<ModeloImagen> modeloImagenArrayList = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * "
                        + " from " + DBModel.TABLE_IMAGENES
                        + " where " + DBModel.IMAGENES_TIPO + "='" + type + "' and " + DBModel.IMAGENES_KEY_ID + "=" + idKeyType
                , null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloImagen modeloImagen = new ModeloImagen();

                modeloImagen.setId(cursor.getInt(cursor.getColumnIndex(DBModel.IMAGENES_ID)));
                modeloImagen.setIdImagen(cursor.getInt(cursor.getColumnIndex(DBModel.IMAGENES_ID_IMAGEN_SQLITE)));
                modeloImagen.setTipoImagen(cursor.getString(cursor.getColumnIndex(DBModel.IMAGENES_TIPO)));
                modeloImagen.setKey_id(cursor.getInt(cursor.getColumnIndex(DBModel.IMAGENES_KEY_ID)));
                modeloImagen.setUrlApp(cursor.getString(cursor.getColumnIndex(DBModel.IMAGENES_RUTA_APP)));
                modeloImagen.setUrlServer(cursor.getString(cursor.getColumnIndex(DBModel.IMAGENES_RUTA_SERVER)));

                modeloImagenArrayList.add(modeloImagen);
                cursor.moveToNext();
            }
        }
        return modeloImagenArrayList;
    }

    protected ModeloPuntaje getPuntajeCursor(Cursor cursor) {
        ModeloPuntaje modeloPuntaje = new ModeloPuntaje();
        modeloPuntaje.setIdFirebase(cursor.getString(cursor.getColumnIndex(DBModel.PUNTAJE_ID_FIREBASE)));
        modeloPuntaje.setIdSqlite(cursor.getInt(cursor.getColumnIndex(DBModel.PUNTAJE_ID_SQLITE)));
        modeloPuntaje.setIdLugarFirebase(cursor.getString(cursor.getColumnIndex(DBModel.PUNTAJE_ID_LUGAR_FIREBASE)));
        modeloPuntaje.setPuntaje(cursor.getInt(cursor.getColumnIndex(DBModel.PUNTAJE_CANTIDAD)));
        modeloPuntaje.setNroVisitas(cursor.getInt(cursor.getColumnIndex(DBModel.PUNTAJE_NRO_VISITAS)));
        modeloPuntaje.setTipo(cursor.getString(cursor.getColumnIndex(DBModel.PUNTAJE_TIPO)));
        return modeloPuntaje;
    }

    public void updatePuntajeSQLite(ArrayList<ModeloPuntaje> modeloUsuariosLugar) {
        helper.deleteDatosPuntaje(db);
        for (ModeloPuntaje modeloPuntaje : modeloUsuariosLugar) {
            insertarPuntaje(modeloPuntaje);
        }
    }

    public ArrayList<ModeloPuntaje> getPuntaje() {
        ArrayList<ModeloPuntaje> modeloPuntajes = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_PUNTAJE, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloPuntaje modeloPuntaje = getPuntajeCursor(cursor);
                modeloPuntajes.add(modeloPuntaje);
                cursor.moveToNext();
            }
        }
        return modeloPuntajes;
    }

    private void insertarPuntaje(ModeloPuntaje modeloPuntaje) {
        helper.insertarPuntaje(db, modeloPuntaje);
    }
}
