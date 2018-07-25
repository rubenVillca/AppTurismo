package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ModeloHotel extends ModeloBaseLugares {
    private String provincia;
    private String paginaWeb;
    private String email;


    public ModeloHotel() {
        super();
        this.provincia = "";
        this.paginaWeb="";
        this.email="";
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public boolean equals(ModeloHotel modeloHotel) {
        return modeloHotel.getIdFirebase().equals(idFirebase)
                && modeloHotel.getIdSQLite() == idSQLite
                && modeloHotel.getNombre().equals(nombre);
    }
}
