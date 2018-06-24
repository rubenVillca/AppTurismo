package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by HGA on 05/07/2017
 */

public class ModeloImagen implements Serializable {
    private int id;
    private int idImagen;
    private String urlServer;
    private String urlApp;
    private String tipoImagen;
    private int key_id;
    public HashMap<String,Object> timestampCreated;//h

    public static String TIPO_RESTAURANTE="RESTAURANTES";
    public static String TIPO_HOTEL="HOTELES";
    public static String TIPO_LUGAR="LUGARES";

    public ModeloImagen() {
        this.idImagen = 0;
        this.urlServer = "";
        this.urlApp = "";
        this.tipoImagen = "";
        this.key_id = 0;
        //this.timestampCreated = ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getTipoRestaurante() {
        return TIPO_RESTAURANTE;
    }

    public static void setTipoRestaurante(String tipoRestaurante) {
        TIPO_RESTAURANTE = tipoRestaurante;
    }

    public static String getTipoHotel() {
        return TIPO_HOTEL;
    }

    public static void setTipoHotel(String tipoHotel) {
        TIPO_HOTEL = tipoHotel;
    }

    public static String getTipoLugar() {
        return TIPO_LUGAR;
    }

    public static void setTipoLugar(String tipoLugar) {
        TIPO_LUGAR = tipoLugar;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getUrlServer() {
        return urlServer;
    }

    public void setUrlServer(String urlServer) {
        this.urlServer = urlServer;
    }

    public String getUrlApp() {
        return urlApp;
    }

    public void setUrlApp(String urlApp) {
        this.urlApp = urlApp;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }
    public HashMap<String, Object> getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(HashMap<String, Object> timestampCreated) {
        this.timestampCreated = timestampCreated;
    }
}
