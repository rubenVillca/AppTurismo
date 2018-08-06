package com.hga.appturismo.modelo;

import com.hga.appturismo.util.Constants;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by HGA on 14/7/2018
 */
public class ModeloBaseLugares implements Serializable {
    protected int idSQLite;
    protected String idFirebase;
    protected String nombre;
    protected String direccion;
    protected ArrayList<ModeloImagen> imagenes;
    protected int telefono;
    protected float gpsX;
    protected float gpsY;
    protected String estado;
    protected String descripcion;
    protected String registradoPor;
    public ModeloBaseLugares() {
        this.idSQLite = 0;
        this.idFirebase = "";
        this.nombre = "";
        this.direccion = "";
        this.imagenes = new ArrayList<>();
        this.telefono = 0;
        this.gpsX = 0f;
        this.gpsY = 0f;
        this.estado = Constants.ESTADO_LUGAR_VISIBLE;
        this.descripcion="";
        this.registradoPor = "hga.ax88@gmail.com";
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdSQLite() {
        return idSQLite;
    }

    public void setIdSQLite(int idSQLite) {
        this.idSQLite = idSQLite;
    }

    public String getIdFirebase() {
        return idFirebase;
    }

    public void setIdFirebase(String idFirebase) {
        this.idFirebase = idFirebase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(String registradoPor) {
        this.registradoPor = registradoPor;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<ModeloImagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<ModeloImagen> imagenes) {
        this.imagenes = imagenes;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public float getGpsX() {
        return gpsX;
    }

    public void setGpsX(float gpsX) {
        this.gpsX = gpsX;
    }

    public float getGpsY() {
        return gpsY;
    }

    public void setGpsY(float gpsY) {
        this.gpsY = gpsY;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setTelefonoString(String telefono) {
        if (telefono.isEmpty()){
            this.telefono=0;
        }else{
            this.telefono=Integer.parseInt(telefono);
        }
    }

    public void setImagenesFirebaseArreglo(String[] imagens) {
        int id=1;
        for(int i=0;i<imagens.length;i++){
            ModeloImagen imagenes=new ModeloImagen();
            imagenes.setIdImagen(id++);
            imagenes.setIdLugarReference(this.idSQLite);
            imagenes.setTipoImagen(ModeloImagen.TIPO_LUGAR);
            imagenes.setUrlServer(imagens[i]);
            this.imagenes.add(imagenes);
        }
    }

    public void setImagenesAndroid(int[] listaImg) {
        int id=1;
        for (Integer imagen:listaImg){
            ModeloImagen imagenes=new ModeloImagen();
            imagenes.setIdImagen(id++);
            imagenes.setIdLugarReference(this.idSQLite);
            imagenes.setTipoImagen(ModeloImagen.TIPO_LUGAR);
            imagenes.setUrlApp(String.valueOf(imagen));
            this.imagenes.add(imagenes);
        }
    }

    public void setImagenesFirebase(ArrayList<ModeloImagen> listaImg) {
        this.imagenes = listaImg;
    }
}
