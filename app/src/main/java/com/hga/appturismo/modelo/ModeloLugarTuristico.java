package com.hga.appturismo.modelo;

public class ModeloLugarTuristico extends ModeloBaseLugares{

    private String provincia;
    private String tipo;
    private String horario;
    private String fecha;
    private String linea;
    private String actividad;
    private String descripcion;

    public ModeloLugarTuristico(){
        super();
        this.provincia = "";
        this.tipo = "";
        this.horario = "";
        this.actividad = "";
        this.fecha="";
        this.linea="";
        this.descripcion = "";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public boolean equals(ModeloLugarTuristico modeloLugarTuristico) {
        return modeloLugarTuristico.getIdFirebase().equals(idFirebase)
                && modeloLugarTuristico.getIdSQLite() == idSQLite
                && modeloLugarTuristico.getNombre().equals(nombre)
                && modeloLugarTuristico.getProvincia().equals(provincia);
    }
}
