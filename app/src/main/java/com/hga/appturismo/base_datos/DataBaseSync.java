package com.hga.appturismo.base_datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 05/07/2017
 */

public class DataBaseSync {
    private DataBaseManager helper;
    private SQLiteDatabase db;

    public DataBaseSync(Context context) {
        helper = new DataBaseManager(context, DataBaseManager.DATABASE_NAME, null, DataBaseManager.DATABASE_VERSION);
        db = helper.getWritableDatabase();
    }

    public ArrayList<ModeloUsuario> getListaUsuarios() {
        ArrayList<ModeloUsuario> modeloUsuarios = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DataBaseManager.TABLE_USUARIOS, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloUsuario modeloUsuario = getUsuarioCursor(cursor);
                modeloUsuarios.add(modeloUsuario);
                cursor.moveToNext();
            }
        }
        return modeloUsuarios;
    }

    public ArrayList<ModeloPuntaje> getPuntaje() {
        ArrayList<ModeloPuntaje> modeloPuntajes = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DataBaseManager.TABLE_PUNTAJE, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloPuntaje modeloPuntaje = getPuntajeCursor(cursor);
                modeloPuntajes.add(modeloPuntaje);
                cursor.moveToNext();
            }
        }
        return modeloPuntajes;
    }

    /**
     * @return ArrayList: lista de lugares turisticos
     */
    public ArrayList<ModeloLugarTuristico> getListaLugarTuristco() {
        ArrayList<ModeloLugarTuristico> modeloLugarTuristicos = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DataBaseManager.TABLE_LUGARES, null);
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

        modeloLugarTuristico.setIdSQLite(cursor.getInt(cursor.getColumnIndex(DataBaseManager.LUGARES_ID_SQLITE)));
        modeloLugarTuristico.setProvincia(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_PROVINCIA)));
        modeloLugarTuristico.setIdFirebase(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_ID_FIREBASE)));
        modeloLugarTuristico.setNombre(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_NAME)));
        modeloLugarTuristico.setDescripcion(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_DESCRIPCION)));
        modeloLugarTuristico.setHorario(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_HORARIO_ATENCION)));
        modeloLugarTuristico.setDireccion(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_UBICACION)));
        modeloLugarTuristico.setTelefono(cursor.getInt(cursor.getColumnIndex(DataBaseManager.LUGARES_TELEFONO)));
        modeloLugarTuristico.setGpsX(cursor.getFloat(cursor.getColumnIndex(DataBaseManager.LUGARES_LATITUD)));
        modeloLugarTuristico.setGpsY(cursor.getFloat(cursor.getColumnIndex(DataBaseManager.LUGARES_LONGITUD)));
        modeloLugarTuristico.setActividad(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_ACTIVIDAD)));
        modeloLugarTuristico.setEstado(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_ESTADO)));
        modeloLugarTuristico.setLinea(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_LINEA)));
        modeloLugarTuristico.setFecha(cursor.getString(cursor.getColumnIndex(DataBaseManager.LUGARES_FECHA)));
        modeloLugarTuristico.setImagenesFirebase(getListaImagenes(ModeloImagen.TIPO_LUGAR, modeloLugarTuristico.getIdSQLite()));
        return modeloLugarTuristico;
    }

    public ModeloLugarTuristico getLugarTuristico(String nombreMarcador) {
        ModeloLugarTuristico modeloLugarTuristico = new ModeloLugarTuristico();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DataBaseManager.TABLE_LUGARES
                + " where " + DataBaseManager.LUGARES_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloLugarTuristico = getLugarTuristicoCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloLugarTuristico;
    }

    public ArrayList<ModeloRestaurante> getListaRestaurantes() {
        ArrayList<ModeloRestaurante> modeloRestaurantes = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DataBaseManager.TABLE_RESTAURANTES, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloRestaurante modeloRestaurante = getRestauranteCursor(cursor);

                modeloRestaurantes.add(modeloRestaurante);
                cursor.moveToNext();
            }

        }
        return modeloRestaurantes;
    }

    @NonNull
    private ModeloRestaurante getRestauranteCursor(Cursor cursor) {
        ModeloRestaurante modeloRestaurante = new ModeloRestaurante();
        modeloRestaurante.setIdSQLite(cursor.getInt(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_ID_SQLITE)));
        modeloRestaurante.setIdFirebase(cursor.getString(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_ID_FIREBASE)));
        modeloRestaurante.setNombre(cursor.getString(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_NAME)));
        modeloRestaurante.setDireccion(cursor.getString(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_DIRECCION)));
        modeloRestaurante.setHorario(cursor.getString(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_HORARIO)));
        modeloRestaurante.setTelefono(cursor.getInt(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_TELEFONO)));
        modeloRestaurante.setEmail(cursor.getString(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_EMAIL)));
        modeloRestaurante.setGpsX(cursor.getFloat(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_LATITUD)));
        modeloRestaurante.setGpsY(cursor.getFloat(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_LONGITUD)));
        modeloRestaurante.setEstado(cursor.getString(cursor.getColumnIndex(DataBaseManager.RESTAURANTES_ESTADO)));
        modeloRestaurante.setImagenesFirebase(getListaImagenes(ModeloImagen.TIPO_RESTAURANTE, modeloRestaurante.getIdSQLite()));
        return modeloRestaurante;
    }

    public ModeloRestaurante getRestaurante(String nombreMarcador) {
        ModeloRestaurante modeloRestaurante = new ModeloRestaurante();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DataBaseManager.TABLE_RESTAURANTES
                + " where " + DataBaseManager.RESTAURANTES_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloRestaurante = getRestauranteCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloRestaurante;
    }

    public ArrayList<ModeloHotel> getListaHoteles() {
        ArrayList<ModeloHotel> hoteles = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from " + DataBaseManager.TABLE_HOTELES, null);
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
        modeloHotel.setIdSQLite(cursor.getInt(cursor.getColumnIndex(DataBaseManager.HOTELES_SQLITE_ID)));
        modeloHotel.setIdFirebase(cursor.getString(cursor.getColumnIndex(DataBaseManager.HOTELES_ID_FIREBASE)));
        modeloHotel.setNombre(cursor.getString(cursor.getColumnIndex(DataBaseManager.HOTELES_NAME)));
        modeloHotel.setDireccion(cursor.getString(cursor.getColumnIndex(DataBaseManager.HOTELES_DIRECCION)));
        modeloHotel.setTelefono(cursor.getInt(cursor.getColumnIndex(DataBaseManager.HOTELES_TELEFONO)));
        modeloHotel.setPaginaWeb(cursor.getString(cursor.getColumnIndex(DataBaseManager.HOTELES_PAGINA_WEB)));
        modeloHotel.setEmail(cursor.getString(cursor.getColumnIndex(DataBaseManager.HOTELES_EMAIL)));
        modeloHotel.setGpsX(cursor.getFloat(cursor.getColumnIndex(DataBaseManager.HOTELES_LATITUD)));
        modeloHotel.setGpsY(cursor.getFloat(cursor.getColumnIndex(DataBaseManager.HOTELES_LONGITUD)));
        modeloHotel.setEstado(cursor.getString(cursor.getColumnIndex(DataBaseManager.HOTELES_ESTADO)));

        modeloHotel.setImagenes(getListaImagenes(ModeloImagen.TIPO_HOTEL, modeloHotel.getIdSQLite()));
        return modeloHotel;
    }

    public ModeloHotel getHotel(String nombreMarcador) {
        ModeloHotel modeloHotel = new ModeloHotel();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DataBaseManager.TABLE_HOTELES
                + " where " + DataBaseManager.HOTELES_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloHotel = getHotelCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloHotel;
    }

    private ArrayList<ModeloImagen> getListaImagenes(String type, int idKeyType) {
        ArrayList<ModeloImagen> modeloImagenArrayList = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * "
                        + " from " + DataBaseManager.TABLE_IMAGENES
                        + " where " + DataBaseManager.IMAGENES_TIPO + "='" + type + "' and " + DataBaseManager.IMAGENES_KEY_ID + "=" + idKeyType
                , null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ModeloImagen modeloImagen = new ModeloImagen();

                modeloImagen.setId(cursor.getInt(cursor.getColumnIndex(DataBaseManager.IMAGENES_ID)));
                modeloImagen.setIdImagen(cursor.getInt(cursor.getColumnIndex(DataBaseManager.IMAGENES_ID_IMAGEN_SQLITE)));
                modeloImagen.setTipoImagen(cursor.getString(cursor.getColumnIndex(DataBaseManager.IMAGENES_TIPO)));
                modeloImagen.setKey_id(cursor.getInt(cursor.getColumnIndex(DataBaseManager.IMAGENES_KEY_ID)));
                modeloImagen.setUrlApp(cursor.getString(cursor.getColumnIndex(DataBaseManager.IMAGENES_RUTA_APP)));
                modeloImagen.setUrlServer(cursor.getString(cursor.getColumnIndex(DataBaseManager.IMAGENES_RUTA_SERVER)));

                modeloImagenArrayList.add(modeloImagen);
                cursor.moveToNext();
            }
        }
        return modeloImagenArrayList;
    }


    @NonNull
    private ModeloUsuario getUsuarioCursor(Cursor cursor) {
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(cursor.getInt(cursor.getColumnIndex(DataBaseManager.USER_SQLITE_ID)));
        modeloUsuario.setIdFirebase(cursor.getString(cursor.getColumnIndex(DataBaseManager.USER_ID_FIREBASE)));
        modeloUsuario.setNombre(cursor.getString(cursor.getColumnIndex(DataBaseManager.USER_NAME)));
        modeloUsuario.setTelefono(cursor.getString(cursor.getColumnIndex(DataBaseManager.USER_TELEFONO)));
        modeloUsuario.setEmail(cursor.getString(cursor.getColumnIndex(DataBaseManager.USER_EMAIL)));
        modeloUsuario.setEstado(cursor.getString(cursor.getColumnIndex(DataBaseManager.USER_ESTADO)));
        return modeloUsuario;
    }

    public ModeloUsuario getUsuario(String nombreMarcador) {
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        Cursor cursor = db.rawQuery("Select * "
                + " from " + DataBaseManager.TABLE_USUARIOS
                + " where " + DataBaseManager.USER_NAME + "='" + nombreMarcador + "'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modeloUsuario = getUsuarioCursor(cursor);

                cursor.moveToNext();
            }
        }
        return modeloUsuario;
    }

    @NonNull
    private ModeloPuntaje getPuntajeCursor(Cursor cursor) {
        ModeloPuntaje modeloPuntaje = new ModeloPuntaje();
        modeloPuntaje.setIdFirebase(cursor.getString(cursor.getColumnIndex(DataBaseManager.PUNTAJE_ID_FIREBASE)));
        modeloPuntaje.setIdSqlite(cursor.getInt(cursor.getColumnIndex(DataBaseManager.PUNTAJE_ID_SQLITE)));
        modeloPuntaje.setIdLugarFirebase(cursor.getString(cursor.getColumnIndex(DataBaseManager.PUNTAJE_ID_LUGAR_FIREBASE)));
        modeloPuntaje.setPuntaje(cursor.getInt(cursor.getColumnIndex(DataBaseManager.PUNTAJE_CANTIDAD)));
        modeloPuntaje.setNroVisitas(cursor.getInt(cursor.getColumnIndex(DataBaseManager.PUNTAJE_NRO_VISITAS)));
        modeloPuntaje.setTipo(cursor.getString(cursor.getColumnIndex(DataBaseManager.PUNTAJE_TIPO)));
        return modeloPuntaje;
    }

    public void insertarLugarTuristico(ModeloLugarTuristico modeloLugarTuristico) {
        helper.insertarLugarTuristico(db, modeloLugarTuristico);
    }

    public void insertarRestaurante(ModeloRestaurante modeloRestaurante) {
        helper.insertarRestaurante(db, modeloRestaurante);
    }

    public void insertarHotel(ModeloHotel modeloHotel) {
        helper.insertarHotel(db, modeloHotel);
    }

    public void insertarUsuarios(ModeloUsuario modeloUsuario) {
        helper.insertarUsuario(db, modeloUsuario);
    }

    public void insertarUsuarioLugar(ModeloPuntaje modeloPuntaje) {
        helper.insertarPuntaje(db, modeloPuntaje);
    }

    public void updateLugarTuristicoSQLite(ArrayList<ModeloLugarTuristico> lugaresTuristicos) {
        helper.deleteDatosLugarTuristico(db);
        for (ModeloLugarTuristico lugar : lugaresTuristicos) {
            insertarLugarTuristico(lugar);
        }
    }

    public void updateRestauranteSQLite(ArrayList<ModeloRestaurante> modeloRestaurantes) {
        helper.deleteDatosRestaurante(db);
        for (ModeloRestaurante modeloRestaurante : modeloRestaurantes) {
            insertarRestaurante(modeloRestaurante);
        }
    }

    public void updateHotelSQLite(ArrayList<ModeloHotel> modeloHotels) {
        helper.deleteDatosHotel(db);
        for (ModeloHotel modeloHotel : modeloHotels) {
            insertarHotel(modeloHotel);
        }
    }

    public void updateUsuariosSQLite(ArrayList<ModeloUsuario> modeloUsuarios) {
        //helper.deleteTableUsuario(db);
        for (ModeloUsuario modeloUsuario : modeloUsuarios) {
            insertarUsuarios(modeloUsuario);
        }
    }

    public void updatePuntajeSQLite(ArrayList<ModeloPuntaje> modeloUsuariosLugar) {
        helper.deleteDatosPuntaje(db);
        for (ModeloPuntaje modeloPuntaje : modeloUsuariosLugar) {
            insertarUsuarioLugar(modeloPuntaje);
        }
    }

    public void resetSQLite() {
        helper.deleteAllDatos(db);

        Listas listas=new Listas();
        updateHotelSQLite(listas.getListaHoteles());
        updateLugarTuristicoSQLite(listas.getListaLugares());
        updateRestauranteSQLite(listas.getListaRestaurantes());
        updateUsuariosSQLite(listas.getListaUsuarios());
        updatePuntajeSQLite(listas.getListaPuntaje());
    }
}
