package com.hga.appturismo.provider;

import android.content.Context;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

public class ListasPrueba extends Listas{
    private ArrayList<ModeloHotel> listaHoteles;
    private ArrayList<ModeloLugarTuristico> listaLugares;
    private ArrayList<ModeloRestaurante> listaRestaurantes;
    private ArrayList<ModeloUsuario> listaUsuarios;
    private ArrayList<ModeloPuntaje> listaPuntaje;
    private Context context;

    public ListasPrueba() {
        this.listaHoteles = new ArrayList<>();
        this.listaLugares = new ArrayList<>();
        this.listaRestaurantes = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaPuntaje = new ArrayList<>();

        int idLugar = setListaLugarTuristico();
        setListaAcontecimientos(idLugar);
        setListaHoteles();
        setListaRestaurantes();
        setListaUsuarios();
    }

    public ArrayList<ModeloHotel> getListaHoteles() {
        return listaHoteles;
    }

    public ArrayList<ModeloLugarTuristico> getListaLugares() {
        return listaLugares;
    }

    public ArrayList<ModeloRestaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public ArrayList<ModeloUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<ModeloPuntaje> getListaPuntaje() {
        return listaPuntaje;
    }

    private void setListaHoteles() {
        int idHotel = 0;
        ModeloHotel hotel;

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Adara Suites Apart Hotel Prueba");
        hotel.setActividad("Hospedaje, administración y manejo de hoteles, apart hoteles, prestación de todo tipo de servicios hoteleros, organización de eventos, recepciones, servicios de restaurant, cafetería, spa, café, bar, etc.");
        hotel.setLinea("");
        hotel.setGpsX(-17.38467001063881f);
        hotel.setGpsY(-66.16149187088013f);
        hotel.setDireccion("Calle Junín nro. 867 Zona: Central");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"adara suites apart hotel3.jpg", "adara suites apart hotel4.jpg", "adara suites apart hotel1.jpg", "adara suites apart hotel2.jpg"});
        hotel.setTelefono(4662020L);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("info@adarahotel.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);
    }

    private void setListaRestaurantes() {
        int idRestaurante = 0;
        ModeloRestaurante restaurante;

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Carne y Fuego");
        restaurante.setActividad("Restaurant - churrasquería");
        restaurante.setLinea("111");
        restaurante.setGpsX(-17.376764248067403f);
        restaurante.setGpsY(-66.17607034742832f);
        restaurante.setDireccion("Av. Melchor Pérez nro. 1555 Zona: Sarco");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{"carne y fuego3.png", "carne y fuego2.png" });
        restaurante.setTelefono(4243800L);
        restaurante.setEmail("emailrestautnate@gmail.com");
        restaurante.setPaginaWeb("www.gmai.com");
        restaurante.setHorario("Martes a Viernes 18:00-23:00 Sábado 18:00-23:00 Domingo 11:00-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);
    }

    private int setListaLugarTuristico() {
        int idLugTur = 0;
        ModeloLugarTuristico lugarTuristico;

        //SITIOS NATURALES
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Árbol de Jarka");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"arbol jarka2.jpg", "arbol jarka1.jpg" });
        lugarTuristico.setActividad("Árbol “Jarka”, es un árbol con el tronco torcido ubicado en la Plazuela 27 de mayo," +
                " también denominado árbol de la juventud. En años anteriores esta zona se llamaba “loza katu” por la venta de cerámica.");
        lugarTuristico.setHorario("");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0L);
        lugarTuristico.setGpsX(-17.6144987102532f);
        lugarTuristico.setGpsY(-66.02461002767086f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        return idLugTur;
    }
// Acontecimientos programados***********************************************************************************
    private void setListaAcontecimientos(int idAcontecimiento) {
        ModeloLugarTuristico acontecimiento;

        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Feria Internacional de Cochabamba");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"feria internacional de cochabamba.jpg", "feria internacional de cochabamba2.jpg" });
        acontecimiento.setDescripcion("La Feria Internacional de Cochabamba, nace como proyecto en 1971 por iniciativa de la Federación de Entidades Empresariales Privadas de Cochabamba (FEPC), como un primer ensayo realizado en el Estado Mayor, organizado y apoyado por la Cámara de Comercio de Cochabamba.");
        acontecimiento.setHorario("Abierto");
        acontecimiento.setDireccion("Circuito Bolivia, Cochabamba.");
        acontecimiento.setTelefono(0L);
        acontecimiento.setFecha("1561074325000");
        acontecimiento.setGpsX(-17.4092406f);
        acontecimiento.setGpsY(-66.1607367f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);
    }

    private void setListaUsuarios() {
        int idUser = 1;
        ModeloUsuario modeloUsuario;

        idUser++;
        modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(idUser);
        modeloUsuario.setNombre("Herminia");
        modeloUsuario.setApellido("Garcia");
        modeloUsuario.setEmail("hga.ax88@gmail.com");
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setTelefono(String.valueOf(60761942));
        modeloUsuario.setContrasenia("firebase123");
        modeloUsuario.setRol(Constants.USUARIO_ROL_ADMIN);
        modeloUsuario.setEstado(Constants.ESTADO_USUARIO_ACTIVO);
        listaUsuarios.add(modeloUsuario);

        idUser++;
        modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(idUser);
        modeloUsuario.setNombre("Juan");
        modeloUsuario.setApellido("Perez");
        modeloUsuario.setEmail("juan@gmail.com");
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setTelefono(String.valueOf(60761941));
        modeloUsuario.setContrasenia("firebase123");
        modeloUsuario.setRol(Constants.USUARIO_ROL_REVISOR);
        modeloUsuario.setEstado(Constants.ESTADO_USUARIO_ACTIVO);
        listaUsuarios.add(modeloUsuario);

        idUser++;
        modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(idUser);
        modeloUsuario.setNombre("Juana");
        modeloUsuario.setApellido("Gonzales");
        modeloUsuario.setEmail("juana@gmail.com");
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setTelefono(String.valueOf(60761940));
        modeloUsuario.setContrasenia("firebase123");
        modeloUsuario.setRol(Constants.USUARIO_ROL_REVISOR);
        modeloUsuario.setEstado(Constants.ESTADO_USUARIO_ACTIVO);
        listaUsuarios.add(modeloUsuario);
    }
}
