package com.hga.appturismo.bdSQLite;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public class SqliteLugar extends DBSQLiteParent implements SqliteInterface<ModeloLugarTuristico> {
    public SqliteLugar(Context context) {
        super(context);
    }

    /**
     * @return ArrayList: lista de lugares turisticos
     */
    public ArrayList<ModeloLugarTuristico> list() {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_LUGARES, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloLugarTuristico modeloLugarTuristico = getLugarTuristicoCursor(cursor);
                modeloLugarTuristicos.add(modeloLugarTuristico);
                cursor.moveToNext();
            }
        }
        return modeloLugarTuristicos;
    }

    public ArrayList<ModeloLugarTuristico> listAcontecimientos() {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_LUGARES
                + " where " + DBModel.LUGARES_TIPO +"='"+Constants.TIPO_LUGAR_ACONTECIMIENTOS+"'",null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloLugarTuristico modeloLugarTuristico = getLugarTuristicoCursor(cursor);
                modeloLugarTuristicos.add(modeloLugarTuristico);
                cursor.moveToNext();
            }
        }
        return modeloLugarTuristicos;
    }

    /**
     * obtener un lugar turistico
     *
     * @param cursor: tuplas SQlite
     * @return Lugar turistico
     */
    @NonNull
    private ModeloLugarTuristico getLugarTuristicoCursor(Cursor cursor) {
        ModeloLugarTuristico modeloLugarTuristico = new ModeloLugarTuristico();

        modeloLugarTuristico.setIdSQLite(cursor.getInt(cursor.getColumnIndex(DBModel.LUGARES_ID_SQLITE)));
        modeloLugarTuristico.setProvincia(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_PROVINCIA)));
        modeloLugarTuristico.setIdFirebase(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_ID_FIREBASE)));
        modeloLugarTuristico.setTipo(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_TIPO)));
        modeloLugarTuristico.setNombre(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_NAME)));
        modeloLugarTuristico.setDescripcion(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_DESCRIPCION)));
        modeloLugarTuristico.setHorario(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_HORARIO_ATENCION)));
        modeloLugarTuristico.setDireccion(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_UBICACION)));
        modeloLugarTuristico.setTelefono(cursor.getInt(cursor.getColumnIndex(DBModel.LUGARES_TELEFONO)));
        modeloLugarTuristico.setGpsX(cursor.getFloat(cursor.getColumnIndex(DBModel.LUGARES_LATITUD)));
        modeloLugarTuristico.setGpsY(cursor.getFloat(cursor.getColumnIndex(DBModel.LUGARES_LONGITUD)));
        modeloLugarTuristico.setActividad(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_ACTIVIDAD)));
        modeloLugarTuristico.setEstado(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_ESTADO)));
        modeloLugarTuristico.setLinea(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_LINEA)));
        modeloLugarTuristico.setFecha(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_FECHA)));
        modeloLugarTuristico.setRegistradoPor(cursor.getString(cursor.getColumnIndex(DBModel.LUGARES_REGISTRADO_POR)));

        modeloLugarTuristico.setImagenesFirebase(getListaImagenes(ModeloImagen.TIPO_LUGAR, modeloLugarTuristico.getIdSQLite()));
        return modeloLugarTuristico;
    }

    public ModeloLugarTuristico getItem(String nombreMarcador) {
        ModeloLugarTuristico modeloLugarTuristico = new ModeloLugarTuristico();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_LUGARES
                + " where " + DBModel.LUGARES_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloLugarTuristico = getLugarTuristicoCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloLugarTuristico;
    }

    public void insert(ModeloLugarTuristico modeloLugarTuristico) {
        helper.insertarLugarTuristico(db, modeloLugarTuristico);
    }

    @Override
    public void delete() {
        helper.deleteDatosLugarTuristico(db);
    }

    public void update(ArrayList<ModeloLugarTuristico> lugaresTuristicos) {
        helper.deleteDatosLugarTuristico(db);
        for (ModeloLugarTuristico lugar : lugaresTuristicos) {
            insert(lugar);
        }
    }

}
