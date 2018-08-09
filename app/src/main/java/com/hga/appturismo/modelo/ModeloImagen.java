package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by HGA on 05/07/2017
 */

public class ModeloImagen implements Serializable {
    private int idSqlite;
    private int idImagen;//numero de imagen de un lugar
    private int idLugarReference;
    private String urlServer;
    private String urlApp;
    private String tipoImagen;

    public static String TIPO_RESTAURANTE="RESTAURANTES";
    public static String TIPO_HOTEL="HOTELES";
    public static String TIPO_LUGAR="LUGARES";

    public ModeloImagen() {
        this.idImagen = 0;
        this.urlServer = "";
        this.urlApp = "";
        this.tipoImagen = "";
        this.idLugarReference = 0;
    }

    public int getIdSqlite() {
        return idSqlite;
    }

    public void setIdSqlite(int id) {
        this.idSqlite = id;
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

    public int getIdLugarReference() {
        return idLugarReference;
    }

    public void setIdLugarReference(int idLugarReference) {
        this.idLugarReference = idLugarReference;
    }
}
