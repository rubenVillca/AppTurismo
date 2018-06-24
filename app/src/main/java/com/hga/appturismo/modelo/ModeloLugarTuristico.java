package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ModeloLugarTuristico implements Serializable {
    private int idSQLite;
    private String idFirebase;
    private String provincia;
    private String tipo;
    private String nombre;
    private ArrayList<ModeloImagen> imagenes;
    private String descripcion;
    private String horario;
    private String direccion;
    private int telefono;
    private float gpsX;
    private float gpsY ;
    private String actividad;
    private String estado;

    public ModeloLugarTuristico(){
        this.idSQLite = 1;
        this.idFirebase="";
        this.provincia = "";
        this.tipo = "";
        this.nombre = "";
        this.imagenes = new ArrayList<>();
        this.descripcion = "";
        this.horario = "";
        this.direccion = "";
        this.telefono = 0;
        this.gpsX = 0f;
        this.gpsY = 0f;
        this.actividad = "";
        this.estado = "";
    }

    public String getIdFirebase() {
        return idFirebase;
    }

    public void setIdFirebase(String idFirebase) {
        this.idFirebase = idFirebase;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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

    public int getIdSQLite() {
        return idSQLite;
    }

    public void setIdSQLite(int idSQLite) {
        this.idSQLite = idSQLite;
    }

    public ArrayList<ModeloImagen> getImagenes() {
        return imagenes;
    }

    public void setImagenesFirebase(ArrayList<ModeloImagen> listaImg) {
        this.imagenes = listaImg;
    }

    public void setImagenesFirebaseArreglo(String[] imagens) {
        int id=1;
        for(int i=0;i<imagens.length;i++){
            ModeloImagen imagenes=new ModeloImagen();
            imagenes.setIdImagen(id++);
            imagenes.setKey_id(this.idSQLite);
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
            imagenes.setKey_id(this.idSQLite);
            imagenes.setTipoImagen(ModeloImagen.TIPO_LUGAR);
            imagenes.setUrlApp(String.valueOf(imagen));
            this.imagenes.add(imagenes);
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public void setTelefonoString(String telefono) {
        if (telefono.isEmpty()){
            this.telefono=0;
        }else{
            this.telefono=Integer.parseInt(telefono);
        }
    }
    public String getActividad(){return actividad;}
    public void setActividad (String actividad) {this.actividad = actividad;}
    public String getEstado(){return estado;}
    public void setEstado (String estado) {this.estado = estado;}
}
