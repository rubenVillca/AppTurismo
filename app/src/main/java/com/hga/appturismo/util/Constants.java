package com.hga.appturismo.util;

/**
 * Created by HGA on 17/08/2017
 */

public class Constants {
    //ruta base imagenes bdFirebase
    public static final String FIREBASE_STORAGE_URL = "gs://mi-proyecto-4408d.appspot.com/TURISMO/";
    //ruta base bd bdFirebase
    public final static String FIREBASE_BASE_URL= "https://mi-proyecto-4408d.firebaseio.com/";

    //imagenes
    public static final String FIREBASE_STORAGE_URL_HOTEL =  "HOTELES/";
    public static final String FIREBASE_STORAGE_URL_RESTAURANTE = "RESTAURANTES/";
    public static final String FIREBASE_STORAGE_URL_LUGAR_TURISTICO = "LUGARES/";

    //provincias
    public static final String FIREBASE_PROVINCIA_ARANI = "Arani";
    public static final String FIREBASE_PROVINCIA_ARQUE = "Arque";
    public static final String FIREBASE_PROVINCIA_AYOPAYA = "Ayopaya";
    public static final String FIREBASE_PROVINCIA_BOLIVAR = "Bolívar";
    public static final String FIREBASE_PROVINCIA_CAMPERO = "Narciso Campero";
    public static final String FIREBASE_PROVINCIA_CAPINOTA = "Capinota";
    public static final String FIREBASE_PROVINCIA_CERCADO = "Cercado";
    public static final String FIREBASE_PROVINCIA_CHAPARE = "Chapare";
    public static final String FIREBASE_PROVINCIA_ESTEBAN_ARZE = "Esteban Arce";
    public static final String FIREBASE_PROVINCIA_GERMAN_JORDAN = "Germán Jordán";
    public static final String FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO = "José Carrasco";
    public static final String FIREBASE_PROVINCIA_MIZQUE = "Mizque";
    public static final String FIREBASE_PROVINCIA_PUNATA = "Punata";
    public static final String FIREBASE_PROVINCIA_QUILLACOLLO = "Quillacollo";
    public static final String FIREBASE_PROVINCIA_TAPACARI = "Tapacarí";
    public static final String FIREBASE_PROVINCIA_TIRAQUE = "Tiraque";

    //base de daos bdFirebase
    public static final String FIREBASE_DATABASE_LUGAR_TURISTICO = "LUGARES";
    public static final String FIREBASE_DATABASE_HOTEL = "HOTELES";
    public static final String FIREBASE_DATABASE_RESTAURANTE = "RESTAURANTES";
    public static final String FIREBASE_DATABASE_USUARIO="USUARIO";
    public static final String FIREBASE_DATABASE_PUNTAJE ="PUNTAJE";//usuario_lugar

    //
    public static final String FIREBASE_TIPO_HOTEL ="Hotel";//usuario_lugar
    public static final String FIREBASE_TIPO_RESTAURANTE ="Restaurante";//usuario_lugar
    public static final String FIREBASE_TIPO_LUGAR_TURISTICO ="Lugar turistico";//usuario_lugar

    public static final int USUARIO_ROL_ADMIN=1;
    public static final int USUARIO_ROL_REVISOR =2;

    //estado de lugar
    public static final String ESTADO_LUGAR_VISIBLE="Visible";
    public static final String ESTADO_LUGAR_ELIMINADO="Eliminado";
    public static final String ESTADO_LUGAR_SUG_INSERTAR="Sugerir insercion";
    public static final String ESTADO_LUGAR_SUG_EDITAR="Sugerir edicion";
    public static final String ESTADO_LUGAR_SUG_ELIMINAR="Sugerir eliminado";
    public static final String ESTADO_LUGAR_SUG_RECHAZAR="Rechazar sugerencia";

    //estado de restaurante
    public static final String ESTADO_RESTAURANTE_VISIBLE="Visible";
    public static final String ESTADO_RESTAURANTELUGAR_ELIMINADO="Eliminado";
    public static final String ESTADO_RESTAURANTE_SUG_INSERTAR="Sugerir insercion";
    public static final String ESTADO_RESTAURANTE_SUG_EDITAR="Sugerir edicion";
    public static final String ESTADO_RESTAURANTE_SUG_ELIMINAR="Sugerir eliminado";
    public static final String ESTADO_RESTAURANTE_SUG_RECHAZAR="Rechazar sugerencia";

    //estado de hotel
    public static final String ESTADO_HOTEL_VISIBLE="Visible";
    public static final String ESTADO_HOTEL_ELIMINADO="Eliminado";
    public static final String ESTADO_HOTEL_SUG_INSERTAR="Sugerir insercion";
    public static final String ESTADO_HOTEL_SUG_EDITAR="Sugerir edicion";
    public static final String ESTADO_HOTEL_SUG_ELIMINAR="Sugerir eliminado";
    public static final String ESTADO_HOTEL_SUG_RECHAZAR="Rechazar sugerencia";

    //estado_usuario
    public static final String ESTADO_USUARIO_ACTIVO="Activo";
    public static final String ESTADO_USUARIO_ELIMINADO="Eliminado";
    public static final String ESTADO_USUARIO_SOLICITUD_REVISOR="Solicitud para revisor";
    public static final String ESTADO_USUARIO_SOLICITUD_RECHAZADA="Solicitud rechazada ";
    public static final String ESTADO_USUARIO_SOLICITUD_ACEPTADO="Solicitud aceptado";

    public static final boolean IS_READ_FIREBASE = false;

    public static int SELECT_HOTEL = 0;
    public static int SELECT_RESTAURANTE = 1;
    public static int SELECT_LUGAR = 2;

    public static String TIPO_LUGAR_SITIOS_NATURALES = "Sitios Naturales";
    public static String TIPO_LUGAR_PATRIMONIO = "Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales";
    public static String TIPO_LUGAR_ETNOGRAFIA = "Etnografía y Folklore";
    public static String TIPO_LUGAR_REALIZACIONES = "Realizaciones Técnicas y Científicas";
    public static String TIPO_LUGAR_ACONTECIMIENTOS = "Acontecimientos Programados";
}
