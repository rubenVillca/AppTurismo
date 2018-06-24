package com.hga.appturismo.typeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hga.appturismo.api.ListaResponse;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HGA on 31/08/2017
 */

public class UsuarioResponseTypeAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public ListaResponse read(JsonReader in) throws IOException {
        final ListaResponse response = new ListaResponse();
        ArrayList<ModeloUsuario> modeloUsuarios = new ArrayList<>();

        in.beginObject();
        while (in.hasNext()) {
            ModeloUsuario modeloUsuario = null;
            try {
                modeloUsuario = readUsuario(in);
                modeloUsuarios.add(modeloUsuario);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        in.endObject();
        response.setListUsuarios(modeloUsuarios);
        return response;
    }

    private ModeloUsuario readUsuario(JsonReader in) throws IOException {
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdFirebase(in.nextName());
        in.beginObject();
        while (in.hasNext()) {
            String next = in.nextName();
            switch (next) {
                case "apellido":
                    modeloUsuario.setApellido(in.nextString());
                    break;
                case "contrasenia":
                    modeloUsuario.setContrasenia(in.nextString());
                    break;
                case "email":
                    modeloUsuario.setEmail(in.nextString());
                    break;
                case "idFirebase":
                    in.nextString();
                    //modeloUsuario.setIdFirebase(in.nextString());
                    break;
                case "idSqlite":
                    modeloUsuario.setIdSqlite(in.nextInt());
                    break;
                case "nombre":
                    modeloUsuario.setNombre(in.nextString());
                    break;
                case "telefono":
                    modeloUsuario.setTelefono(in.nextString());
                    break;
                case "rol":
                    modeloUsuario.setRol(in.nextInt());
                    break;
                case "estado":
                    modeloUsuario.setEstado(in.nextString());
                    break;
                default:
                    System.out.println("Error al leer desde firebase");
                    break;
            }
        }
        in.endObject();
        return modeloUsuario;
    }

}
