package com.hga.appturismo.bdSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.provider.Listas;

import java.util.ArrayList;

/**
 * Created by HGA on 04/07/2017
 */

public class DBModel extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 95;
    public static final String DATABASE_NAME = "APP_TURISMO";

    public static final String TABLE_IMAGENES = "IMAGENES";
    public static final String IMAGENES_ID_SQLITE = "ID_IMAGEN";
    public static final String IMAGENES_POSICION_IMAGEN = "ID_IMAGEN_SQLITE";
    public static final String IMAGENES_REFERENCE_LUGAR_ID = "KEY_TIPO_ID_IMGEN";
    public static final String IMAGENES_TIPO = "TIPO_IMAGEN";
    public static final String IMAGENES_RUTA_APP = "RUTA_APP_IMAGEN";
    public static final String IMAGENES_RUTA_SERVER = "RUTA_SERVER_IMAGEN";

    public static final String TABLE_LUGARES = "LUGARES_TURISTICOS";
    public static final String LUGARES_ID_SQLITE = "ID_SQLITE_LUGAR";
    public static final String LUGARES_ID_FIREBASE = "ID_FIREBASE_LUGAR";
    public static final String LUGARES_TIPO = "TIPO_FIREBASE_LUGAR";
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
    public static final String LUGARES_REGISTRADO_POR = "REGISTRADO_POR";


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
    public static final String RESTAURANTES_REGISTRADO_POR = "REGISTRADO_POR";


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
    public static final String HOTELES_REGISTRADO_POR = "REGISTRADO_POR";


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

    public DBModel(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
                + IMAGENES_ID_SQLITE + " integer primary key autoincrement,"
                + IMAGENES_REFERENCE_LUGAR_ID + " integer,"
                + IMAGENES_POSICION_IMAGEN + " integer,"
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
                + LUGARES_TIPO + " text,"
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
                + LUGARES_FECHA + " text,"
                + LUGARES_REGISTRADO_POR + " text"
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
                + RESTAURANTES_ESTADO + " text,"
                + RESTAURANTES_REGISTRADO_POR + " text"
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
                + HOTELES_ESTADO + " text,"
                + HOTELES_REGISTRADO_POR + " text"
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

    private void insertarImagenes(ArrayList<ModeloImagen> modeloImagenArrayList, SQLiteDatabase db,long idReference) {
        for (ModeloImagen modeloImagen : modeloImagenArrayList) {
            modeloImagen.setIdLugarReference((int) idReference);
            insertarImagen(db, modeloImagen);
        }
    }

    public void insertarImagen(SQLiteDatabase db, ModeloImagen modeloImagen) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBModel.IMAGENES_POSICION_IMAGEN, modeloImagen.getIdImagen());
        contentValues.put(DBModel.IMAGENES_REFERENCE_LUGAR_ID, modeloImagen.getIdLugarReference());
        contentValues.put(DBModel.IMAGENES_TIPO, modeloImagen.getTipoImagen());
        contentValues.put(DBModel.IMAGENES_RUTA_APP, modeloImagen.getUrlApp());
        contentValues.put(DBModel.IMAGENES_RUTA_SERVER, modeloImagen.getUrlServer());

        long idSqlite=db.insert(DBModel.TABLE_IMAGENES, null, contentValues);
        if ( idSqlite== -1) {
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

        //contentValues.put(DBModel.RESTAURANTES_ID_SQLITE, modeloRestaurante.getIdSQLite());
        contentValues.put(DBModel.RESTAURANTES_ID_FIREBASE, modeloRestaurante.getIdFirebase());
        contentValues.put(DBModel.RESTAURANTES_NAME, modeloRestaurante.getNombre());
        contentValues.put(DBModel.RESTAURANTES_DIRECCION, modeloRestaurante.getDireccion());
        contentValues.put(DBModel.RESTAURANTES_HORARIO, modeloRestaurante.getHorario());
        contentValues.put(DBModel.RESTAURANTES_TELEFONO, String.valueOf(modeloRestaurante.getTelefono()));
        contentValues.put(DBModel.RESTAURANTES_EMAIL, modeloRestaurante.getEmail());
        contentValues.put(DBModel.RESTAURANTES_LATITUD, String.valueOf(modeloRestaurante.getGpsX()));
        contentValues.put(DBModel.RESTAURANTES_LONGITUD, String.valueOf(modeloRestaurante.getGpsY()));
        contentValues.put(DBModel.RESTAURANTES_ESTADO, String.valueOf(modeloRestaurante.getEstado()));
        contentValues.put(DBModel.RESTAURANTES_REGISTRADO_POR, modeloRestaurante.getRegistradoPor());

        long idSqlite=db.insert(DBModel.TABLE_RESTAURANTES, null, contentValues);
        if (idSqlite == -1) {
            System.out.println("Error en la base de datos restaurante: " + contentValues.toString() + "\nModeloRestaurante:" + modeloRestaurante.toString());
        } else {
            insertarImagenes(modeloRestaurante.getImagenes(), db,idSqlite);
        }
    }

    private void insertarHoteles(ArrayList<ModeloHotel> listaHoteles, SQLiteDatabase db) {
        for (ModeloHotel modeloHotel : listaHoteles) {
            insertarHotel(db, modeloHotel);
        }
    }

    public void insertarHotel(SQLiteDatabase db, ModeloHotel modeloHotel) {
        ContentValues contentValues = new ContentValues();

        //contentValues.put(DBModel.HOTELES_SQLITE_ID, modeloHotel.getIdSQLite());
        contentValues.put(DBModel.HOTELES_ID_FIREBASE, modeloHotel.getIdFirebase());
        contentValues.put(DBModel.HOTELES_NAME, modeloHotel.getNombre());
        contentValues.put(DBModel.HOTELES_DIRECCION, modeloHotel.getDireccion());
        contentValues.put(DBModel.HOTELES_TELEFONO, String.valueOf(modeloHotel.getTelefono()));
        contentValues.put(DBModel.HOTELES_PAGINA_WEB, modeloHotel.getPaginaWeb());
        contentValues.put(DBModel.HOTELES_EMAIL, modeloHotel.getEmail());
        contentValues.put(DBModel.HOTELES_LATITUD, String.valueOf(modeloHotel.getGpsX()));
        contentValues.put(DBModel.HOTELES_LONGITUD, String.valueOf(modeloHotel.getGpsY()));
        contentValues.put(DBModel.HOTELES_ESTADO, String.valueOf(modeloHotel.getEstado()));
        contentValues.put(DBModel.HOTELES_REGISTRADO_POR, modeloHotel.getRegistradoPor());

        long idSqliteReference=db.insert(DBModel.TABLE_HOTELES, null, contentValues);
        if (idSqliteReference == -1) {
            System.out.println("Error en la base de datos hotel: " + contentValues.toString() + "\nModeloHotel: " + modeloHotel.toString());
        } else {
            insertarImagenes(modeloHotel.getImagenes(), db,idSqliteReference);
        }
    }

    private void insertarLugares(ArrayList<ModeloLugarTuristico> listaLugares, SQLiteDatabase db) {
        for (ModeloLugarTuristico lugar : listaLugares) {
            insertarLugarTuristico(db, lugar);
        }
    }


    public void insertarLugarTuristico(SQLiteDatabase db, ModeloLugarTuristico lugar) {
        ContentValues contentValues = new ContentValues();

        //contentValues.put(DBModel.LUGARES_ID_SQLITE, lugar.getIdSQLite());
        contentValues.put(DBModel.LUGARES_ID_FIREBASE, String.valueOf(lugar.getIdFirebase()));
        contentValues.put(DBModel.LUGARES_NAME, String.valueOf(lugar.getNombre()));
        contentValues.put(DBModel.LUGARES_TIPO, String.valueOf(lugar.getTipo()));
        contentValues.put(DBModel.LUGARES_DESCRIPCION, String.valueOf(lugar.getDescripcion()));
        contentValues.put(DBModel.LUGARES_UBICACION, String.valueOf(lugar.getDireccion()));
        contentValues.put(DBModel.LUGARES_HORARIO_ATENCION, lugar.getHorario());
        contentValues.put(DBModel.LUGARES_TELEFONO, String.valueOf(lugar.getTelefono()));
        contentValues.put(DBModel.LUGARES_LATITUD, String.valueOf(lugar.getGpsX()));
        contentValues.put(DBModel.LUGARES_LONGITUD, String.valueOf(lugar.getGpsY()));
        contentValues.put(DBModel.LUGARES_ACTIVIDAD, String.valueOf(lugar.getActividad()));
        contentValues.put(DBModel.LUGARES_ESTADO, String.valueOf(lugar.getEstado()));
        contentValues.put(DBModel.LUGARES_LINEA,String.valueOf(lugar.getLinea()));
        contentValues.put(DBModel.LUGARES_FECHA,String.valueOf(lugar.getFecha()));
        contentValues.put(DBModel.LUGARES_PROVINCIA,lugar.getProvincia());
        contentValues.put(DBModel.LUGARES_REGISTRADO_POR, lugar.getRegistradoPor());

        long idSqlite=db.insert(DBModel.TABLE_LUGARES, null, contentValues) ;
        if (idSqlite== -1) {
            System.out.println("Error en la base de datos turismo: " + contentValues.toString() + "\nmodelo:" + lugar.toString());
        } else {
            insertarImagenes(lugar.getImagenes(), db,idSqlite);
        }
    }


    private void insertarUsuarios(ArrayList<ModeloUsuario> listaUsuarios, SQLiteDatabase db) {
        for (ModeloUsuario modeloUsuario : listaUsuarios) {
            insertarUsuario(db, modeloUsuario);
        }
    }

    public void insertarUsuario(SQLiteDatabase db, ModeloUsuario modeloUsuario) {
        ContentValues contentValues = new ContentValues();

        //contentValues.put(DBModel.USER_SQLITE_ID, modeloUsuario.getIdSqlite());
        contentValues.put(DBModel.USER_ID_FIREBASE, String.valueOf(modeloUsuario.getIdFirebase()));
        contentValues.put(DBModel.USER_NAME, modeloUsuario.getNombre());
        contentValues.put(DBModel.USER_APELLIDO, modeloUsuario.getApellido());
        contentValues.put(DBModel.USER_EMAIL, modeloUsuario.getEmail());
        contentValues.put(DBModel.USER_TELEFONO, modeloUsuario.getTelefono());
        contentValues.put(DBModel.USER_ROL,modeloUsuario.getRol());
        contentValues.put(DBModel.USER_PWD, String.valueOf(modeloUsuario.getTelefono()));
        contentValues.put(DBModel.USER_ESTADO, String.valueOf(modeloUsuario.getEstado()));

        if (db.insert(DBModel.TABLE_USUARIOS, null, contentValues) == -1) {
            System.out.println("Error en la base de datos Usuario: " + contentValues.toString() + "\nmodelo:" + modeloUsuario.toString());
        }
    }

    public void insertarPuntaje(SQLiteDatabase db, ModeloPuntaje modeloPuntaje) {
        ContentValues contentValues = new ContentValues();

        //contentValues.put(DBModel.PUNTAJE_ID_SQLITE, modeloPuntaje.getIdSqlite());
        contentValues.put(DBModel.PUNTAJE_ID_FIREBASE, String.valueOf(modeloPuntaje.getIdFirebase()));
        contentValues.put(DBModel.PUNTAJE_ID_LUGAR_FIREBASE, modeloPuntaje.getIdLugarFirebase());
        contentValues.put(DBModel.PUNTAJE_CANTIDAD, modeloPuntaje.getPuntaje());
        contentValues.put(DBModel.PUNTAJE_NRO_VISITAS, modeloPuntaje.getNroVisitas());
        contentValues.put(DBModel.PUNTAJE_TIPO, modeloPuntaje.getTipo());

        if (db.insert(DBModel.TABLE_PUNTAJE, null, contentValues) == -1) {
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

    public void deleteTableUsuario(SQLiteDatabase db) {
        db.execSQL("DELETE FROM " + TABLE_USUARIOS);
    }
}
