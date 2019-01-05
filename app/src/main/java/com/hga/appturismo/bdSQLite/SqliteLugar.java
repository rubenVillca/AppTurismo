package com.hga.appturismo.bdSQLite;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by HGA on 21/7/2018
 */
public class SqliteLugar extends DBSQLiteParent implements SqliteInterface<ModeloLugarTuristico> {
    public SqliteLugar(Context context) {
        super(context);
    }

    public void insert(ModeloLugarTuristico modeloLugarTuristico) {
        helper.insertarLugarTuristico(db, modeloLugarTuristico);
    }

    @Override
    public void delete() {
        helper.deleteDatosLugarTuristico(db);
    }

    public void update(ArrayList<ModeloLugarTuristico> lugaresTuristicos) {
        delete();
        for (ModeloLugarTuristico lugar : lugaresTuristicos) {
            insert(lugar);
        }
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
    public ArrayList<ModeloLugarTuristico> listActive() {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_LUGARES+" where "+DBModel.LUGARES_ESTADO+"="+"'"+Constants.ESTADO_LUGAR_VISIBLE+"'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloLugarTuristico modeloLugarTuristico = getLugarTuristicoCursor(cursor);
                modeloLugarTuristicos.add(modeloLugarTuristico);
                cursor.moveToNext();
            }
        }
        return modeloLugarTuristicos;
    }

    public ArrayList<ModeloLugarTuristico> listSugeridos(){
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DBModel.TABLE_LUGARES+" where "+DBModel.LUGARES_ESTADO+"="+"'"+Constants.ESTADO_HOTEL_SUG_INSERTAR+"'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloLugarTuristico modeloLugarTuristico = getLugarTuristicoCursor(cursor);
                modeloLugarTuristicos.add(modeloLugarTuristico);
                cursor.moveToNext();
            }
        }
        return modeloLugarTuristicos;
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

    public ArrayList<ModeloLugarTuristico> selectProvincia(String provincia) {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos=new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_LUGARES
                + " where " + DBModel.LUGARES_PROVINCIA + "='" + provincia + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloLugarTuristicos.add(getLugarTuristicoCursor(cursor));

                cursor.moveToNext();
            }
        }
        return modeloLugarTuristicos;
    }

    public ArrayList<ModeloLugarTuristico> selectProvinciaActive(String provincia) {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos=new ArrayList<>();
        Cursor cursor = db.rawQuery(
                "SELECT * "
                + " FROM " + DBModel.TABLE_LUGARES
                + " WHERE " + DBModel.LUGARES_PROVINCIA + "='" + provincia + "'"
                + " AND " +DBModel.LUGARES_ESTADO+"="+"'"+Constants.ESTADO_LUGAR_VISIBLE+"'", null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloLugarTuristicos.add(getLugarTuristicoCursor(cursor));

                cursor.moveToNext();
            }
        }
        return modeloLugarTuristicos;
    }

    public ArrayList<ModeloLugarTuristico> listAcontecimientos() {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DBModel.TABLE_LUGARES
                + " where " + DBModel.LUGARES_TIPO + "='" + Constants.TIPO_LUGAR_ACONTECIMIENTOS + "'", null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloLugarTuristico modeloLugarTuristico = getLugarTuristicoCursor(cursor);
                modeloLugarTuristicos.add(modeloLugarTuristico);
                cursor.moveToNext();
            }
        }
        return modeloLugarTuristicos;
    }

    public ArrayList<ModeloLugarTuristico> listAcontecimientosActivos() {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = listAcontecimientos();
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicosRes = new ArrayList<>();
        for (ModeloLugarTuristico modelo : modeloLugarTuristicos) {
            if (modelo.getEstado().equals(Constants.ESTADO_LUGAR_VISIBLE)) {
                String fechaString = modelo.getFecha();
                String mesString = "";
                int dia = 0;
                int mes;
                if (fechaString.length() > 5) {
                    mesString = fechaString.substring(2, fechaString.length());
                    dia = Integer.parseInt(fechaString.substring(0, 2).trim());
                    mesString = mesString.trim().toLowerCase();
                } else {
                    System.out.println("Fecha no valida");
                }

                mes = getMes(mesString);
                Calendar fecha = new GregorianCalendar();
                int mesActual = fecha.get(Calendar.MONTH);
                int diaActual = fecha.get(Calendar.DAY_OF_MONTH);
                if (mes >= mesActual && dia >= diaActual) {
                    modeloLugarTuristicosRes.add(modelo);
                }
            }
        }
        return modeloLugarTuristicosRes;
    }

    private int getMes(String mesString) {
        int mes;
        switch (mesString) {
            case "enero":
                mes = 1;
                break;
            case "febrero":
                mes = 2;
                break;
            case "marzo":
                mes = 3;
                break;
            case "abril":
                mes = 4;
                break;
            case "mayo":
                mes = 5;
                break;
            case "junio":
                mes = 6;
                break;
            case "julio":
                mes = 7;
                break;
            case "agosto":
                mes = 8;
                break;
            case "septiembre":
                mes = 9;
                break;
            case "octubre":
                mes = 10;
                break;
            case "noviembre":
                mes = 11;
                break;
            case "diciembre":
                mes = 12;
                break;
            default:
                mes = 0;
                break;
        }
        return mes;
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
        modeloLugarTuristico.setTelefono(cursor.getLong(cursor.getColumnIndex(DBModel.LUGARES_TELEFONO)));
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

    public void remove(ModeloLugarTuristico modeloLugar) {
        helper.deleteLugarTuristico(db,modeloLugar.getIdSQLite());
    }
}
