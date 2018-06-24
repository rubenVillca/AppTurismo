package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ModeloHotel implements Serializable {
    private int idSQLite;
    private String idFirebase;
    private String nombre;
    private String direccion;
    private ArrayList<ModeloImagen> imagenes;
    private int telefono;
    private String provincia;
    private String paginaWeb;
    private float gpsX;
    private float gpsY;
    private String email;
    private String estado;

    public ModeloHotel() {
        this.idSQLite =1;
        this.idFirebase="";
        this.nombre="";
        this.direccion = "";
        this.imagenes = new ArrayList<>();
        this.telefono = 0;
        this.provincia = "";
        this.paginaWeb="";
        this.gpsX = 0;
        this.gpsY = 0;
        this.email="";
        this.estado="";
    }

    public String getIdFirebase() {
        return idFirebase;
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

    public void setIdFirebase(String idFirebase) {
        this.idFirebase = idFirebase;
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

    public void setImagenes(ArrayList<ModeloImagen> imagenes) {
        this.imagenes = imagenes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefonoString(String telefono) {
        if (telefono.isEmpty()){
            this.telefono=0;
        }else{
            this.telefono=Integer.parseInt(telefono);
        }
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
