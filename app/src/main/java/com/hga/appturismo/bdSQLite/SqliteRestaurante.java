package com.hga.appturismo.bdSQLite;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class SqliteRestaurante extends DBSQLiteParent implements SqliteInterface<ModeloRestaurante>{
    public SqliteRestaurante(Context context) {
        super(context);
    }

    @NonNull
    private ModeloRestaurante getRestauranteCursor(Cursor cursor) {
        ModeloRestaurante modeloRestaurante = new ModeloRestaurante();
        modeloRestaurante.setIdSQLite(cursor.getInt(cursor.getColumnIndex(DBModel.RESTAURANTES_ID_SQLITE)));
        modeloRestaurante.setIdFirebase(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_ID_FIREBASE)));
        modeloRestaurante.setNombre(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_NAME)));
        modeloRestaurante.setDescripcion(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_DESCRIPCION)));
        modeloRestaurante.setDireccion(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_DIRECCION)));
        modeloRestaurante.setHorario(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_HORARIO)));
        modeloRestaurante.setTelefono(cursor.getLong(cursor.getColumnIndex(DBModel.RESTAURANTES_TELEFONO)));
        modeloRestaurante.setEmail(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_EMAIL)));
        modeloRestaurante.setGpsX(cursor.getFloat(cursor.getColumnIndex(DBModel.RESTAURANTES_LATITUD)));
        modeloRestaurante.setGpsY(cursor.getFloat(cursor.getColumnIndex(DBModel.RESTAURANTES_LONGITUD)));
        modeloRestaurante.setEstado(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_ESTADO)));
        modeloRestaurante.setLinea(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_LINEA)));
        modeloRestaurante.setPaginaWeb(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_PAGINA_WEB)));
        modeloRestaurante.setRegistradoPor(cursor.getString(cursor.getColumnIndex(DBModel.RESTAURANTES_REGISTRADO_POR)));
        modeloRestaurante.setImagenesFirebase(getListaImagenes(ModeloImagen.TIPO_RESTAURANTE, modeloRestaurante.getIdSQLite()));
        return modeloRestaurante;
    }

    public ModeloRestaurante getItem(String nombreMarcador) {
        ModeloRestaurante modeloRestaurante = new ModeloRestaurante();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_RESTAURANTES
                + " where " + DBModel.RESTAURANTES_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloRestaurante = getRestauranteCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloRestaurante;
    }

    public ArrayList<ModeloRestaurante> list() {
        ArrayList<ModeloRestaurante> modeloRestaurantes = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_RESTAURANTES, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloRestaurante modeloRestaurante = getRestauranteCursor(cursor);

                modeloRestaurantes.add(modeloRestaurante);
                cursor.moveToNext();
            }

        }
        return modeloRestaurantes;
    }

    public ArrayList<ModeloRestaurante> listActive() {
        ArrayList<ModeloRestaurante> modeloRestaurantes = new ArrayList<>();
        Cursor cursor = db.rawQuery(
                "Select * "
                    + " from " + DBModel.TABLE_RESTAURANTES
                    + " where "+DBModel.RESTAURANTES_ESTADO+"="+"'"+Constants.ESTADO_RESTAURANTE_VISIBLE+"'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloRestaurante modeloRestaurante = getRestauranteCursor(cursor);

                modeloRestaurantes.add(modeloRestaurante);
                cursor.moveToNext();
            }

        }
        return modeloRestaurantes;
    }

    public void update(ArrayList<ModeloRestaurante> modeloRestaurantes) {
        helper.deleteDatosRestaurante(db);
        for (ModeloRestaurante modeloRestaurante : modeloRestaurantes) {
            insert(modeloRestaurante);
        }
    }

    public void insert(ModeloRestaurante modeloRestaurante) {
        helper.insertarRestaurante(db, modeloRestaurante);
    }

    @Override
    public void delete() {
        helper.deleteDatosRestaurante(db);
    }

    public ArrayList<ModeloRestaurante> listSugeridos() {
        ArrayList<ModeloRestaurante> modeloRestaurantes = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_RESTAURANTES+" where "+DBModel.RESTAURANTES_ESTADO+"="+"'"+ Constants.ESTADO_HOTEL_SUG_INSERTAR+"'", null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloRestaurante modeloRestaurante = getRestauranteCursor(cursor);

                modeloRestaurantes.add(modeloRestaurante);
                cursor.moveToNext();
            }

        }
        return modeloRestaurantes;
    }

    public void remove(ModeloRestaurante modeloRestaurante) {
        helper.deleteLugarRestaurante(db,modeloRestaurante.getIdSQLite());
    }
}
