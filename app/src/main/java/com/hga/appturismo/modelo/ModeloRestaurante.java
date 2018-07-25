package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by HGA on 29/04/2017
 */

public class ModeloRestaurante extends ModeloBaseLugares{
    private String email;
    private String horario;
    private String provincia;
    private String paginaWeb;

    public ModeloRestaurante() {
        this.email = "";
        this.horario = "";
        this.provincia = "";
        this.paginaWeb = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public boolean equals(ModeloRestaurante modeloRestaurante) {
        return modeloRestaurante.getIdFirebase().equals(idFirebase)
                && modeloRestaurante.getIdSQLite() == idSQLite
                && modeloRestaurante.getNombre().equals(nombre);
    }
}
