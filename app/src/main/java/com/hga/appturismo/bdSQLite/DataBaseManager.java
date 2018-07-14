package com.hga.appturismo.bdSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 04/07/2017
 */

public class DataBaseManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 87;
    public static final String DATABASE_NAME = "APP_TURISMO";

    public static final String TABLE_IMAGENES = "IMAGENES";
    public static final String IMAGENES_ID = "ID_IMAGEN";
    public static final String IMAGENES_ID_IMAGEN_SQLITE = "ID_IMAGEN_SQLITE";
    public static final String IMAGENES_KEY_ID = "KEY_TIPO_ID_IMGEN";
    public static final String IMAGENES_TIPO = "TIPO_IMAGEN";
    public static final String IMAGENES_RUTA_APP = "RUTA_APP_IMAGEN";
    public static final String IMAGENES_RUTA_SERVER = "RUTA_SERVER_IMAGEN";

    public static final String TABLE_LUGARES = "LUGARES_TURISTICOS";
    public static final String LUGARES_ID_SQLITE = "ID_SQLITE_LUGAR";
    public static final String LUGARES_ID_FIREBASE = "ID_FIREBASE_LUGAR";
    public static final String LUGARES_NAME = "NOMBRE_LUGAR";
    public static final String LUGARES_DESCRIPCION = "DESCRIPCION_LUGAR";
    public static final String LUGARES_UBICACION = "UBICACION_LUGAR";
    public static final String LUGARES_HORARIO_ATENCION = "HORARIO_LUGAR";
    public static final String LUGARES_TELEFONO = "TELEFONO_LUGAR";
    public static final String LUGARES_LATITUD = "LATITUD_LUGAR";
    public static final String LUGARES_LONGITUD = "LONGITUD_LUGAR";
    public static final String LUGARES_PROVINCIA = "PROVINCIA_LUGAR";
    public static final String LUGARES_ACTIVIDAD = "ACTIVIDAD_LUGAR";
    public static final String LUGARES_ESTADO= "ESTADO_LUGAR";
    public static final String LUGARES_FECHA= "FECHA_LUGAR";
    public static final String LUGARES_LINEA= "LINEA_LUGAR";

    public static final String TABLE_RESTAURANTES = "RESTAURANTES";
    public static final String RESTAURANTES_ID_SQLITE = "ID_SQLITE_REST";
    public static final String RESTAURANTES_ID_FIREBASE = "ID_FIREBASE_REST";
    public static final String RESTAURANTES_NAME = "NOMBRE_REST";
    public static final String RESTAURANTES_DIRECCION = "DIRECCION_REST";
    public static final String RESTAURANTES_HORARIO = "HORARIO_REST";
    public static final String RESTAURANTES_TELEFONO = "TEL_REST";
    public static final String RESTAURANTES_EMAIL = "EMAIL_REST";
    public static final String RESTAURANTES_LATITUD = "LATITUD_REST";
    public static final String RESTAURANTES_LONGITUD = "LONGITUD_REST";
    public static final String RESTAURANTES_ESTADO= "ESTADO_REST";

    public static final String TABLE_HOTELES = "HOTELES";
    public static final String HOTELES_SQLITE_ID = "ID_SQLITE_HOTEL";
    public static final String HOTELES_ID_FIREBASE = "ID_FIREBASE_HOTEL";
    public static final String HOTELES_NAME = "NOMBRE_HOTEL";
    public static final String HOTELES_DIRECCION = "DIR_HOTEL";
    public static final String HOTELES_TELEFONO = "TEL_HOTEL";
    public static final String HOTELES_PAGINA_WEB = "PAGWEB_HOTEL";
    public static final String HOTELES_EMAIL = "EMAIL_HOTEL";
    public static final String HOTELES_LATITUD = "LATITUD_HOTEL";
    public static final String HOTELES_LONGITUD = "LONGITUD_HOTEL";
    public static final String HOTELES_ESTADO= "ESTADO_HOTEL";

    public static final String TABLE_USUARIOS = "USUARIOS";
    public static final String USER_SQLITE_ID = "ID_SQLITE_USER";
    public static final String USER_ID_FIREBASE = "ID_FIREBASE_USER";
    public static final String USER_NAME = "NOMBRE_USER";
    public static final String USER_APELLIDO = "APELLIDO_USER";
    public static final String USER_EMAIL = "EMAIL_USER";
    public static final String USER_TELEFONO = "TELEFONO_USER";
    public static final String USER_PWD = "PWD_USER";
    public static final String USER_ROL="USER_ROL";
    public static final String USER_ESTADO= "ESTADO_USER";//para solicitudes

    public static final String TABLE_PUNTAJE = "USUARIOS_LUGAR";//
    public static final String PUNTAJE_ID_SQLITE = "ID_SQLITE_PUNTAJE";
    public static final String PUNTAJE_ID_FIREBASE = "ID_FIREBASE_PUNTAJE";
    public static final String PUNTAJE_ID_LUGAR_FIREBASE = "ID_ID_LUGAR_FIREBASE_PUNTAJE";
    public static final String PUNTAJE_CANTIDAD = "PUNTAJE_PUNTAJE";
    public static final String PUNTAJE_NRO_VISITAS = "NRO_VISITAS_PUNTAJE";
    public static final String PUNTAJE_TIPO = "TIPO_PUNTAJE";

    public DataBaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getTableImagenes());
        db.execSQL(getTableUsuarios());
        db.execSQL(getTablePuntaje());
        db.execSQL(getTableSitioTurisico());
        db.execSQL(getTableRestaurantes());
        db.execSQL(getTableHoteles());

        insertarDatosSQLite(db);
    }

    private String getTableImagenes() {
        return "create table " + TABLE_IMAGENES + " ("
                + IMAGENES_ID + " integer primary key autoincrement,"
                + IMAGENES_KEY_ID + " integer,"
                + IMAGENES_ID_IMAGEN_SQLITE + " integer,"
                + IMAGENES_TIPO + " text,"
                + IMAGENES_RUTA_APP + " text,"
                + IMAGENES_RUTA_SERVER + " text"
                + ");";
    }

    private String getTableUsuarios() {
        return "create table " + TABLE_USUARIOS + " ("
                + USER_SQLITE_ID + " integer primary key AUTOINCREMENT,"
                + USER_ID_FIREBASE + " text,"
                + USER_NAME + " text,"
                + USER_APELLIDO + " text,"
                + USER_EMAIL + " text,"
                + USER_TELEFONO + " text,"
                + USER_PWD + " text,"
                + USER_ROL +" integer,"
                + USER_ESTADO+" text"
                + ");";
    }

    private String getTablePuntaje() {
        return "create table " + TABLE_PUNTAJE + " ("
                + PUNTAJE_ID_SQLITE + " integer primary key autoincrement,"
                + PUNTAJE_ID_FIREBASE + " text,"
                + PUNTAJE_ID_LUGAR_FIREBASE + " text,"
                + PUNTAJE_CANTIDAD + " integer,"
                + PUNTAJE_NRO_VISITAS + " integer,"
                + PUNTAJE_TIPO + " text"
                + ");";
    }

    private String getTableSitioTurisico() {
        return "create table " + TABLE_LUGARES + " ("
                + LUGARES_ID_SQLITE + " integer primary key,"
                + LUGARES_ID_FIREBASE + " text,"
                + LUGARES_NAME + " text,"
                + LUGARES_PROVINCIA + " text,"
                + LUGARES_DESCRIPCION + " text,"
                + LUGARES_UBICACION + " text,"
                + LUGARES_HORARIO_ATENCION + " text,"
                + LUGARES_TELEFONO + " text,"
                + LUGARES_LATITUD + " text,"
                + LUGARES_LONGITUD + " text,"
                + LUGARES_ACTIVIDAD + " text,"
                + LUGARES_ESTADO + " text,"
                + LUGARES_LINEA + " text,"
                + LUGARES_FECHA + " text"
                + ");";
    }


    private String getTableRestaurantes() {
        return "create table " + TABLE_RESTAURANTES + " ("
                + RESTAURANTES_ID_SQLITE + " integer primary key,"
                + RESTAURANTES_ID_FIREBASE + " text,"
                + RESTAURANTES_NAME + " text,"
                + RESTAURANTES_DIRECCION + " text,"
                + RESTAURANTES_HORARIO + " text,"
                + RESTAURANTES_TELEFONO + " text,"
                + RESTAURANTES_EMAIL + " text,"
                + RESTAURANTES_LATITUD + " text,"
                + RESTAURANTES_LONGITUD + " text,"
                + RESTAURANTES_ESTADO + " text"
                + ");";
    }

    private String getTableHoteles() {
        return "create table " + TABLE_HOTELES + " ("
                + HOTELES_SQLITE_ID + " integer primary key,"
                + HOTELES_ID_FIREBASE + " text,"
                + HOTELES_NAME + " text,"
                + HOTELES_DIRECCION + " text,"
                + HOTELES_TELEFONO + " text,"
                + HOTELES_PAGINA_WEB + " text,"
                + HOTELES_EMAIL + " text,"
                + HOTELES_LATITUD + " text,"
                + HOTELES_LONGITUD + " text,"
                + HOTELES_ESTADO + " text"
                + ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGENES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LUGARES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANTES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTELES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PUNTAJE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGENES);

        onCreate(db);
    }

    private void insertarDatosSQLite(SQLiteDatabase db) {
        Listas listas = new Listas();
        insertarLugares(listas.getListaLugares(), db);
        insertarHoteles(listas.getListaHoteles(), db);
        insertarRestaurantes(listas.getListaRestaurantes(), db);
        insertarUsuarios(listas.getListaUsuarios(), db);

    }

    private void insertarImagenes(ArrayList<ModeloImagen> modeloImagenArrayList, SQLiteDatabase db) {
        for (ModeloImagen modeloImagen : modeloImagenArrayList) {
            insertarImagen(db, modeloImagen);
        }
    }

    public void insertarImagen(SQLiteDatabase db, ModeloImagen modeloImagen) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseManager.IMAGENES_ID_IMAGEN_SQLITE, modeloImagen.getIdImagen());
        contentValues.put(DataBaseManager.IMAGENES_KEY_ID, modeloImagen.getKey_id());
        contentValues.put(DataBaseManager.IMAGENES_TIPO, modeloImagen.getTipoImagen());
        contentValues.put(DataBaseManager.IMAGENES_RUTA_APP, modeloImagen.getUrlApp());
        contentValues.put(DataBaseManager.IMAGENES_RUTA_SERVER, modeloImagen.getUrlServer());

        if (db.insert(DataBaseManager.TABLE_IMAGENES, null, contentValues) == -1) {
            System.out.println("Error en la base de datos");
        }
    }

    private void insertarRestaurantes(ArrayList<ModeloRestaurante> listaModeloRestaurantes, SQLiteDatabase db) {
        for (ModeloRestaurante modeloRestaurante : listaModeloRestaurantes) {
            insertarRestaurante(db, modeloRestaurante);
        }
    }

    public void insertarRestaurante(SQLiteDatabase db, ModeloRestaurante modeloRestaurante) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseManager.RESTAURANTES_ID_SQLITE, modeloRestaurante.getIdSQLite());
        contentValues.put(DataBaseManager.RESTAURANTES_ID_FIREBASE, modeloRestaurante.getIdFirebase());
        contentValues.put(DataBaseManager.RESTAURANTES_NAME, modeloRestaurante.getNombre());
        contentValues.put(DataBaseManager.RESTAURANTES_DIRECCION, modeloRestaurante.getDireccion());
        contentValues.put(DataBaseManager.RESTAURANTES_HORARIO, modeloRestaurante.getHorario());
        contentValues.put(DataBaseManager.RESTAURANTES_TELEFONO, String.valueOf(modeloRestaurante.getTelefono()));
        contentValues.put(DataBaseManager.RESTAURANTES_EMAIL, modeloRestaurante.getEmail());
        contentValues.put(DataBaseManager.RESTAURANTES_LATITUD, String.valueOf(modeloRestaurante.getGpsX()));
        contentValues.put(DataBaseManager.RESTAURANTES_LONGITUD, String.valueOf(modeloRestaurante.getGpsY()));
        contentValues.put(DataBaseManager.RESTAURANTES_ESTADO, String.valueOf(modeloRestaurante.getEstado()));

        if (db.insert(DataBaseManager.TABLE_RESTAURANTES, null, contentValues) == -1) {
            System.out.println("Error en la base de datos restaurante: " + contentValues.toString() + "\nModeloRestaurante:" + modeloRestaurante.toString());
        } else {
            insertarImagenes(modeloRestaurante.getImagenes(), db);
        }
    }

    private void insertarHoteles(ArrayList<ModeloHotel> listaHoteles, SQLiteDatabase db) {
        for (ModeloHotel modeloHotel : listaHoteles) {
            insertarHotel(db, modeloHotel);
        }
    }

    public void insertarHotel(SQLiteDatabase db, ModeloHotel modeloHotel) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseManager.HOTELES_SQLITE_ID, modeloHotel.getIdSQLite());
        contentValues.put(DataBaseManager.HOTELES_ID_FIREBASE, modeloHotel.getIdFirebase());
        contentValues.put(DataBaseManager.HOTELES_NAME, modeloHotel.getNombre());
        contentValues.put(DataBaseManager.HOTELES_DIRECCION, modeloHotel.getDireccion());
        contentValues.put(DataBaseManager.HOTELES_TELEFONO, String.valueOf(modeloHotel.getTelefono()));
        contentValues.put(DataBaseManager.HOTELES_PAGINA_WEB, modeloHotel.getPaginaWeb());
        contentValues.put(DataBaseManager.HOTELES_EMAIL, modeloHotel.getEmail());
        contentValues.put(DataBaseManager.HOTELES_LATITUD, String.valueOf(modeloHotel.getGpsX()));
        contentValues.put(DataBaseManager.HOTELES_LONGITUD, String.valueOf(modeloHotel.getGpsY()));
        contentValues.put(DataBaseManager.HOTELES_ESTADO, String.valueOf(modeloHotel.getEstado()));

        if (db.insert(DataBaseManager.TABLE_HOTELES, null, contentValues) == -1) {
            System.out.println("Error en la base de datos hotel: " + contentValues.toString() + "\nModeloHotel: " + modeloHotel.toString());
        } else {
            insertarImagenes(modeloHotel.getImagenes(), db);
        }
    }

    private void insertarLugares(ArrayList<ModeloLugarTuristico> listaLugares, SQLiteDatabase db) {
        for (ModeloLugarTuristico lugar : listaLugares) {
            insertarLugarTuristico(db, lugar);
        }
    }


    public void insertarLugarTuristico(SQLiteDatabase db, ModeloLugarTuristico lugar) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseManager.LUGARES_ID_SQLITE, lugar.getIdSQLite());
        contentValues.put(DataBaseManager.LUGARES_ID_FIREBASE, String.valueOf(lugar.getIdFirebase()));
        contentValues.put(DataBaseManager.LUGARES_NAME, String.valueOf(lugar.getNombre()));
        contentValues.put(DataBaseManager.LUGARES_DESCRIPCION, String.valueOf(lugar.getDescripcion()));
        contentValues.put(DataBaseManager.LUGARES_UBICACION, String.valueOf(lugar.getDireccion()));
        contentValues.put(DataBaseManager.LUGARES_HORARIO_ATENCION, lugar.getHorario());
        contentValues.put(DataBaseManager.LUGARES_TELEFONO, String.valueOf(lugar.getTelefono()));
        contentValues.put(DataBaseManager.LUGARES_LATITUD, String.valueOf(lugar.getGpsX()));
        contentValues.put(DataBaseManager.LUGARES_LONGITUD, String.valueOf(lugar.getGpsY()));
        contentValues.put(DataBaseManager.LUGARES_ACTIVIDAD, String.valueOf(lugar.getActividad()));
        contentValues.put(DataBaseManager.LUGARES_ESTADO, String.valueOf(lugar.getEstado()));
        contentValues.put(DataBaseManager.LUGARES_LINEA,String.valueOf(lugar.getLinea()));
        contentValues.put(DataBaseManager.LUGARES_FECHA,String.valueOf(lugar.getFecha()));
        contentValues.put(DataBaseManager.LUGARES_PROVINCIA,lugar.getProvincia());

        if (db.insert(DataBaseManager.TABLE_LUGARES, null, contentValues) == -1) {
            System.out.println("Error en la base de datos turismo: " + contentValues.toString() + "\nmodelo:" + lugar.toString());
        } else {
            insertarImagenes(lugar.getImagenes(), db);
        }
    }


    private void insertarUsuarios(ArrayList<ModeloUsuario> listaUsuarios, SQLiteDatabase db) {
        for (ModeloUsuario modeloUsuario : listaUsuarios) {
            insertarUsuario(db, modeloUsuario);
        }
    }

    public void insertarUsuario(SQLiteDatabase db, ModeloUsuario modeloUsuario) {
        ContentValues contentValues = new ContentValues();

        //contentValues.put(DataBaseManager.USER_SQLITE_ID, modeloUsuario.getIdSqlite());
        contentValues.put(DataBaseManager.USER_ID_FIREBASE, String.valueOf(modeloUsuario.getIdFirebase()));
        contentValues.put(DataBaseManager.USER_NAME, modeloUsuario.getNombre());
        contentValues.put(DataBaseManager.USER_APELLIDO, modeloUsuario.getApellido());
        contentValues.put(DataBaseManager.USER_EMAIL, modeloUsuario.getEmail());
        contentValues.put(DataBaseManager.USER_TELEFONO, modeloUsuario.getTelefono());
        contentValues.put(DataBaseManager.USER_ROL,modeloUsuario.getRol());
        contentValues.put(DataBaseManager.USER_PWD, String.valueOf(modeloUsuario.getTelefono()));
        contentValues.put(DataBaseManager.USER_ESTADO, String.valueOf(modeloUsuario.getEstado()));

        if (db.insert(DataBaseManager.TABLE_USUARIOS, null, contentValues) == -1) {
            System.out.println("Error en la base de datos Usuario: " + contentValues.toString() + "\nmodelo:" + modeloUsuario.toString());
        }
    }

    public void insertarPuntaje(SQLiteDatabase db, ModeloPuntaje modeloPuntaje) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseManager.PUNTAJE_ID_FIREBASE, String.valueOf(modeloPuntaje.getIdFirebase()));
        //contentValues.put(DataBaseManager.PUNTAJE_ID_SQLITE, modeloPuntaje.getIdUsuarioFirebase());
        contentValues.put(DataBaseManager.PUNTAJE_ID_LUGAR_FIREBASE, modeloPuntaje.getIdLugarFirebase());
        contentValues.put(DataBaseManager.PUNTAJE_CANTIDAD, modeloPuntaje.getPuntaje());
        contentValues.put(DataBaseManager.PUNTAJE_NRO_VISITAS, modeloPuntaje.getNroVisitas());
        contentValues.put(DataBaseManager.PUNTAJE_TIPO, modeloPuntaje.getTipo());

        if (db.insert(DataBaseManager.TABLE_PUNTAJE, null, contentValues) == -1) {
            System.out.println("Error en la base de datos Usuario lugar: " + contentValues.toString() + "\nmodelo:" + modeloPuntaje.toString());
        }
    }

    public void deleteDatosLugarTuristico(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_LUGARES);
    }

    public void deleteDatosRestaurante(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_RESTAURANTES);
    }

    public void deleteDatosHotel(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_HOTELES);
    }

    public void deleteDatosUsuario(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_USUARIOS);
    }

    public void deleteDatosPuntaje(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_PUNTAJE);
    }

    public void deleteDatosImagenes(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_IMAGENES);
    }

    public void deleteAllDatos(SQLiteDatabase db) {
        deleteDatosLugarTuristico(db);
        deleteDatosRestaurante(db);
        deleteDatosHotel(db);
        deleteDatosUsuario(db);
        deleteDatosPuntaje(db);
        deleteDatosImagenes(db);
    }
}
