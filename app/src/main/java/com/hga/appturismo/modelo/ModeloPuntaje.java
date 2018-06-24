package com.hga.appturismo.modelo;

import java.io.Serializable;

/**
 * Created by HGA on 01/12/2017
 */

public class ModeloPuntaje implements Serializable {

    private String idFirebase;
    private int idSqlite;
    private String idUsuarioFirebase;
    private String idLugarFirebase;
    private int nroVisitas;
    private int puntaje;
    private String tipo;

    public ModeloPuntaje() {
        this.idFirebase = "";
        this.idSqlite = 0;
        this.idUsuarioFirebase = "";
        this.idLugarFirebase = "";
        this.nroVisitas = 0;
        this.puntaje = 0;
        this.tipo = "";
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdFirebase() {
        return idFirebase;
    }

    public void setIdFirebase(String idFirebase) {
        this.idFirebase = idFirebase;
    }

    public int getIdSqlite() {
        return idSqlite;
    }

    public void setIdSqlite(int idSqlite) {
        this.idSqlite = idSqlite;
    }

    public String getIdUsuarioFirebase() {
        return idUsuarioFirebase;
    }

    public void setIdUsuarioFirebase(String idUsuarioFirebase) {
        this.idUsuarioFirebase = ModeloUsuario.encriptar(idUsuarioFirebase);
    }

    public String getIdLugarFirebase() {
        return idLugarFirebase;
    }

    public void setIdLugarFirebase(String idLugarFirebase) {
        this.idLugarFirebase = idLugarFirebase;
    }

    public int getNroVisitas() {
        return nroVisitas;
    }

    public void setNroVisitas(int nroVisitas) {
        this.nroVisitas = nroVisitas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
