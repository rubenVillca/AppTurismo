package com.hga.appturismo.util;

/**
 * Created by HGA on 17/08/2017
 */

public class Constants {
    //ruta base imagenes firebase
    public static final String FIREBASE_STORAGE_URL = "gs://mi-proyecto-4408d.appspot.com/TURISMO/";
    //ruta base bd firebase
    public final static String FIREBASE_BASE_URL= "https://mi-proyecto-4408d.firebaseio.com/";

    //imagenes
    public static final String FIREBASE_STORAGE_URL_HOTEL =  "HOTELES/";
    public static final String FIREBASE_STORAGE_URL_RESTAURANTE = "RESTAURANTES/";
    public static final String FIREBASE_STORAGE_URL_LUGAR_TURISTICO = "LUGARES/";
    public static final String FIREBASE_STORAGE_URL_ACONTECIMIENTO = "LUGARES/";

    //provincias
    public static final String FIREBASE_PROVINCIA_ARANI = "Arani";
    public static final String FIREBASE_PROVINCIA_ARQUE = "Arque";
    public static final String FIREBASE_PROVINCIA_AYOPAYA = "Ayopaya";
    public static final String FIREBASE_PROVINCIA_BOLIVAR = "Bolivar";
    public static final String FIREBASE_PROVINCIA_CAMPERO = "Campero";
    public static final String FIREBASE_PROVINCIA_CAPINOTA = "Capinota";
    public static final String FIREBASE_PROVINCIA_CERCADO = "Cercado";
    public static final String FIREBASE_PROVINCIA_CHAPARE = "Chapare";
    public static final String FIREBASE_PROVINCIA_ESTEBAN_ARZE = "Esteban Arze";
    public static final String FIREBASE_PROVINCIA_GERMAN_JORDAN = "German Jordan";
    public static final String FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO = "Jose Carrasco Torrico";
    public static final String FIREBASE_PROVINCIA_MIZQUE = "Mizque";
    public static final String FIREBASE_PROVINCIA_PUNATA = "Punata";
    public static final String FIREBASE_PROVINCIA_QUILLACOLLO = "Quillacollo";
    public static final String FIREBASE_PROVINCIA_TAPACARI = "Tapacari";
    public static final String FIREBASE_PROVINCIA_TIRAQUE = "Tiraque";

    //tipo de turismo
    //public static final String FIREBASE_TIPO_TURISMO = "TIPO_TURISMO";
    public static final String FIREBASE_TIPO_TURISMO_SITIOS_NATURALES = "TIPO_TURISMO/SITIOS_NATURALES";
    public static final String FIREBASE_TIPO_TURISMO_PATRIMONIOS = "TIPO_TURISMO/PATRIMONIO_URBANO_ARQUITECTONICO_ARTISTICO_MUSEOS_MANIFESTACIONES_CULTURALES";
    public static final String FIREBASE_TIPO_TURISMO_ETNOGRAFIA_FOLKLORE = "TIPO_TURISMO/ETNOGRAFIA_FOLKLORE";
    public static final String FIREBASE_TIPO_TURISMO_REALIZACIONES_TECNICAS_CIENTIFICAS = "TIPO_TURISMO/REALIZACIONES_TECNICAS_CIENTIFICAS";
    public static final String FIREBASE_TIPO_TURISMO_ACONTECIMIENTOS_PROGRAMADOS = "TIPO_TURISMO/ACONTECIMIENTOS_PROGRAMADOS";

    //base de daos firebase
    public static final String FIREBASE_DATABASE_LUGAR_TURISTICO = "LUGARES";
    public static final String FIREBASE_DATABASE_ACONTECIMIENTO = "ACONTECIMIENTOS";
    public static final String FIREBASE_DATABASE_HOTEL = "HOTELES";
    public static final String FIREBASE_DATABASE_RESTAURANTE = "RESTAURANTES";
    public static final String FIREBASE_DATABASE_USUARIO="USUARIO";
    public static final String FIREBASE_DATABASE_PUNTAJE ="PUNTAJE";//usuario_lugar

    //
    public static final String FIREBASE_TIPO_HOTEL ="Hotel";//usuario_lugar
    public static final String FIREBASE_TIPO_RESTAURANTE ="Restaurante";//usuario_lugar
    public static final String FIREBASE_TIPO_LUGAR_TURISTICO ="Lugar turistico";//usuario_lugar

    public static final int USUARIO_ROL_ADMIN=1;
    public static final int USUARIO_ROL_NORMAL=2;

    //estado de lugar
    public static final String ESTADO_LUGAR_VISIBLE="Visible";
    public static final String ESTADO_LUGAR_ELIMINADO="Eliminado";
    public static final String ESTADO_LUGAR_SUG_INSERTAR="Sugerir insercion";
    public static final String ESTADO_LUGAR_SUG_EDITAR="Sugerir edicion";
    public static final String ESTADO_LUGAR_SUG_ELIMINAR="Sugerir eliminado";
    public static final String ESTADO_LUGAR_SUG_ACEPTAR="Aceptar sugerencia";
    public static final String ESTADO_LUGAR_SUG_RECHAZAR="Rechazar sugerencia";

    //estado_usuario
    public static final String ESTADO_USUARIO_ACTIVO="Activo";
    public static final String ESTADO_USUARIO_ELIMINADO="Eliminado";
    public static final String ESTADO_USUARIO_SOLICITUD_REVISOR="Solicitud para revisor";
    public static final String ESTADO_USUARIO_SOLICITUD_RECHAZADA="Solicitud rechazada ";
    public static final String ESTADO_USUARIO_SOLICITUD_ACEPTADO="Solicitud aceptado";

}
