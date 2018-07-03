package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by HGA on 2/7/2018
 */
public class ModeloAcontecimiento implements Serializable {
    private int idSQLite;
    private String idFirebase;
    private String tipo;
    private String nombre;
    private ArrayList<ModeloImagen> imagenes;
    private String descripcion;
    private String fecha;
    private String horario;
    private String direccion;
    private String linea;
    private int telefono;
    private float gpsX;
    private float gpsY ;
    private String provincia;
    private String actividad;
    private String estado;

    public ModeloAcontecimiento(){
        this.idSQLite = 1;
        this.idFirebase="";
        this.tipo = "";
        this.nombre = "";
        this.imagenes = new ArrayList<>();
        this.descripcion = "";
        this.fecha = "";
        this.horario = "";
        this.direccion = "";
        this.linea = "";
        this.telefono = 0;
        this.gpsX = 0f;
        this.gpsY = 0f;
        this.provincia = "";
        this.actividad = "";
        this.estado = "";
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<ModeloImagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<ModeloImagen> imagenes) {
        this.imagenes = imagenes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setImagenesAndroid(int[] listaImg) {
        int idImagen=1;
        for (Integer imagen:listaImg){
            ModeloImagen imagenes=new ModeloImagen();
            imagenes.setIdImagen(idImagen++);
            imagenes.setKey_id(idSQLite);
            imagenes.setTipoImagen(ModeloImagen.TIPO_HOTEL);
            imagenes.setUrlApp(String.valueOf(imagen));
            this.imagenes.add(imagenes);
        }
    }
    public void setImagenesFirebaseArreglo(String[] imagens) {
        int id=1;
        for(int i=0;i<imagens.length;i++){
            ModeloImagen imagenes=new ModeloImagen();
            imagenes.setIdImagen(id++);
            imagenes.setKey_id(this.idSQLite);
            imagenes.setTipoImagen(ModeloImagen.TIPO_HOTEL);
            imagenes.setUrlServer(imagens[i]);
            this.imagenes.add(imagenes);
        }
    }
    public void setImagenesFirebase(ArrayList<ModeloImagen> listImagenes) {
        imagenes=listImagenes;
    }
}
