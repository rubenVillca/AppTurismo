package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by HGA on 05/07/2017
 */

public class ModeloImagen implements Serializable {
    private int idSqlite;
    private int idImagen;
    private String urlServer;
    private String urlApp;
    private String tipoImagen;
    private int idLugarReference;
    public HashMap<String,Object> timestampCreated;//h

    public static String TIPO_RESTAURANTE="RESTAURANTES";
    public static String TIPO_HOTEL="HOTELES";
    public static String TIPO_LUGAR="LUGARES";

    public ModeloImagen() {
        this.idImagen = 0;
        this.urlServer = "";
        this.urlApp = "";
        this.tipoImagen = "";
        this.idLugarReference = 0;
        this.timestampCreated = new HashMap<>();
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
        urlApp=tipoImagen+"/"+urlServer;
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

    public HashMap<String, Object> getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(HashMap<String, Object> timestampCreated) {
        this.timestampCreated = timestampCreated;
    }
}
