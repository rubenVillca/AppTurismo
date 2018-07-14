package com.hga.appturismo.bdFirebase;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.modelo.ModeloPuntaje;

import java.util.ArrayList;

/**
 * Created by HGA on 31/08/2017
 */

public class ListaResponse {

    private ArrayList<ModeloHotel> listModeloHotel;
    private ArrayList<ModeloRestaurante> listModeloRestaurante;
    private ArrayList<ModeloLugarTuristico> listModeloLugarTuristico;
    private ArrayList<ModeloUsuario> listUsuarios;
    private ArrayList<ModeloPuntaje> listPuntaje;

    public void setListModeloHotel(ArrayList<ModeloHotel> listModeloHotel) {
        this.listModeloHotel = listModeloHotel;
    }

    public ArrayList<ModeloHotel> getListModeloHotel(){
        return listModeloHotel;
    }

    public ArrayList<ModeloRestaurante> getListModeloRestaurante() {
        return listModeloRestaurante;
    }

    public void setListModeloRestaurante(ArrayList<ModeloRestaurante> listModeloRestaurante) {
        this.listModeloRestaurante = listModeloRestaurante;
    }

    public ArrayList<ModeloLugarTuristico> getListModeloLugarTuristico() {
        return listModeloLugarTuristico;
    }

    public void setListModeloLugarTuristico(ArrayList<ModeloLugarTuristico> listModeloLugarTuristico) {
        this.listModeloLugarTuristico = listModeloLugarTuristico;
    }

    public ArrayList<ModeloUsuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(ArrayList<ModeloUsuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public ArrayList<ModeloPuntaje> getListPuntaje() {
        return listPuntaje;
    }

    public void setListPuntaje(ArrayList<ModeloPuntaje> listUsuariosLugar) {
        this.listPuntaje = listUsuariosLugar;
    }
}
