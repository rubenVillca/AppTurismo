package com.hga.appturismo.bdSQLite;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.hga.appturismo.modelo.ModeloUsuario;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class SqliteUsuario extends DBSQLiteParent implements SqliteInterface<ModeloUsuario>{
    public SqliteUsuario(Context context) {
        super(context);
    }

    @Override
    public void update(ArrayList<ModeloUsuario> modeloUsuarios) {
        //helper.deleteTableUsuario(db);
        for (ModeloUsuario modeloUsuario : modeloUsuarios) {
            insert(modeloUsuario);
        }
    }

    @Override
    public void insert(ModeloUsuario modeloUsuario) {
        helper.insertarUsuario(db, modeloUsuario);
    }

    @Override
    public void delete() {

    }

    @Override
    public ModeloUsuario getItem(String nombreMarcador) {
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_USUARIOS
                + " where " + DBModel.USER_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloUsuario = getUsuarioCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloUsuario;
    }

    @Override
    public ArrayList<ModeloUsuario> list() {
        ArrayList<ModeloUsuario> modeloUsuarios = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_USUARIOS, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloUsuario modeloUsuario = getUsuarioCursor(cursor);
                modeloUsuarios.add(modeloUsuario);
                cursor.moveToNext();
            }
        }
        return modeloUsuarios;
    }

    @NonNull
    private ModeloUsuario getUsuarioCursor(Cursor cursor) {
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(cursor.getInt(cursor.getColumnIndex(DBModel.USER_SQLITE_ID)));
        modeloUsuario.setIdFirebase(cursor.getString(cursor.getColumnIndex(DBModel.USER_ID_FIREBASE)));
        modeloUsuario.setNombre(cursor.getString(cursor.getColumnIndex(DBModel.USER_NAME)));
        modeloUsuario.setTelefono(cursor.getString(cursor.getColumnIndex(DBModel.USER_TELEFONO)));
        modeloUsuario.setEmail(cursor.getString(cursor.getColumnIndex(DBModel.USER_EMAIL)));
        modeloUsuario.setEstado(cursor.getString(cursor.getColumnIndex(DBModel.USER_ESTADO)));
        return modeloUsuario;
    }
}
