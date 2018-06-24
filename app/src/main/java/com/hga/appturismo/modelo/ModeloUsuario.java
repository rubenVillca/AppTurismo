package com.hga.appturismo.modelo;

import java.io.Serializable;
import java.text.Normalizer;

/**
 * Created by HGA on 01/11/2017
 */

public class ModeloUsuario implements Serializable {
    private String idFirebase;
    private int idSqlite;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String contrasenia;
    private int rol;
    private String estado;

    public ModeloUsuario() {
        this.idFirebase = "";
        this.idSqlite = 0;
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = 0;
        this.contrasenia = "";
        this.rol = 0;
        estado = "";
    }

    /**
     * @param idFirebase: email para ser encriptado
     */
    public static String encriptar(String idFirebase) {
        idFirebase = idFirebase.replace(".", " ");
        idFirebase = idFirebase.replace("@", "  ");
        return idFirebase;
    }

    /**
     * quitar estacios y tildes a los nombres
     *
     * @param nombre: nombre a codifcar
     * @return String: nombre codificado
     */
    public static String codificarNombre(String nombre) {
        String res = nombre.trim();
        //convertir a minusculas
        res = res.toLowerCase();
        // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
        res = Normalizer.normalize(res, Normalizer.Form.NFD);
        // Regresar a la forma compuesta, para poder comparar la enie con la tabla de valores
        res = Normalizer.normalize(res, Normalizer.Form.NFC);
        return res;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdFirebase() {
        return idFirebase;
    }

    public void setIdFirebase(String idFirebase) {
        this.idFirebase = encriptar(idFirebase);
    }

    public int getIdSqlite() {
        return idSqlite;
    }

    public void setIdSqlite(int idSqlite) {
        this.idSqlite = idSqlite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.isEmpty())
            this.telefono = Integer.parseInt(telefono);
        else
            this.telefono = 0;

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
