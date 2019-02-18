package com.hga.appturismo.bdSQLite;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class SqlitePuntaje extends DBSQLiteParent implements SqliteInterface<ModeloPuntaje>{
    public SqlitePuntaje(Context context) {
        super(context);
    }

    public ArrayList<ModeloPuntaje> list() {
        ArrayList<ModeloPuntaje> puntajes = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_PUNTAJE, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloPuntaje modeloPuntaje = getPuntajeCursor(cursor);

                puntajes.add(modeloPuntaje);
                cursor.moveToNext();
            }
        }
            return puntajes;
    }

    @Override
    public ModeloPuntaje getItem(String idSQLite) {
        ModeloPuntaje modeloPuntaje=new ModeloPuntaje();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_PUNTAJE
                + " where " + DBModel.PUNTAJE_ID_SQLITE + "='" + idSQLite + "' ", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloPuntaje = getPuntajeCursor(cursor);
                cursor.moveToNext();
            }
        }
        return modeloPuntaje;
    }

    @NonNull
    protected ModeloPuntaje getPuntajeCursor(Cursor cursor) {
        ModeloPuntaje modeloPuntaje = new ModeloPuntaje();
        modeloPuntaje.setIdUsuarioFirebase(cursor.getString(cursor.getColumnIndex(DBModel.PUNTAJE_EMAIL)));
        modeloPuntaje.setIdFirebase(cursor.getString(cursor.getColumnIndex(DBModel.PUNTAJE_ID_FIREBASE)));
        modeloPuntaje.setIdLugarFirebase(cursor.getString(cursor.getColumnIndex(DBModel.PUNTAJE_ID_LUGAR_FIREBASE)));
        //modeloPuntaje.setIdSqlite(cursor.getInt(cursor.getColumnIndex(DBModel.PUNTAJE_ID_SQLITE)));
        modeloPuntaje.setNroVisitas(cursor.getInt(cursor.getColumnIndex(DBModel.PUNTAJE_NRO_VISITAS)));
        modeloPuntaje.setTipo(cursor.getString(cursor.getColumnIndex(DBModel.PUNTAJE_TIPO)));
        modeloPuntaje.setPuntaje(cursor.getInt(cursor.getColumnIndex(DBModel.PUNTAJE_CANTIDAD)));

        return modeloPuntaje;
    }

    public ModeloPuntaje getItem(String email,String nameSite) {
        ModeloPuntaje modeloPuntaje = new ModeloPuntaje();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_PUNTAJE
                + " where " + DBModel.PUNTAJE_EMAIL + "='" + email + "' " +
                "AND "+DBModel.PUNTAJE_ID_LUGAR_FIREBASE + "='" + nameSite, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloPuntaje = getPuntajeCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloPuntaje;
    }

    public void insert(ModeloPuntaje modeloPuntaje) {
        helper.insertarPuntaje(db, modeloPuntaje);
    }

    @Override
    public void delete() {
        helper.deleteDatosPuntaje(db);
    }

    @Override
    public void update(ArrayList<ModeloPuntaje> modeloPuntajes) {
        helper.deleteDatosPuntaje(db);
        for (ModeloPuntaje modeloPuntaje : modeloPuntajes) {
            insert(modeloPuntaje);
        }
    }

    public void deletePuntaje(){
        helper.deleteDatosPuntaje(db);
    }

    public void update(ArrayList<ModeloPuntaje> modeloPuntajes,String type) {
        helper.deleteDatosPuntajeType(db,type);
        for (ModeloPuntaje modeloPuntaje : modeloPuntajes) {
            insert(modeloPuntaje);
        }
    }

    public ArrayList<ModeloPuntaje> listSugeridos() {
        ArrayList<ModeloPuntaje> puntajes = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_PUNTAJE, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloPuntaje modeloPuntaje = getPuntajeCursor(cursor);

                puntajes.add(modeloPuntaje);
                cursor.moveToNext();
            }
        }
        return puntajes;
    }
}
