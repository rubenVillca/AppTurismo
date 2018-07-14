package com.hga.appturismo.typeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.modelo.ModeloPuntaje;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HGA on 31/08/2017
 */

public class PuntajeResponseTypeAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public ListaResponse read(JsonReader in) throws IOException {
        final ListaResponse response = new ListaResponse();
        ArrayList<ModeloPuntaje> modeloPuntajes = new ArrayList<>();

        in.beginObject();
        while (in.hasNext()) {
            try {
                ModeloPuntaje modeloPuntaje = readPuntaje(in);
                modeloPuntajes.add(modeloPuntaje);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        in.endObject();
        response.setListPuntaje(modeloPuntajes);
        return response;
    }

    private ModeloPuntaje readPuntaje(JsonReader in) throws IOException {
        ModeloPuntaje modeloPuntaje = new ModeloPuntaje();
        modeloPuntaje.setIdFirebase(in.nextName());
        in.beginObject();
        while (in.hasNext()) {
            String next = in.nextName();
            switch (next) {
                case "idLugarFirebase":
                    modeloPuntaje.setIdLugarFirebase(in.nextString());
                    break;
                case "idFirebase":
                    in.nextString();
                    //modeloUsuario.setIdFirebase(in.nextString());
                    break;
                case "idSqlite":
                    modeloPuntaje.setIdSqlite(in.nextInt());
                    break;
                case "idUsuarioFirebase":
                    modeloPuntaje.setIdUsuarioFirebase(in.nextString());
                    break;
                case "puntaje":
                    modeloPuntaje.setPuntaje(in.nextInt());
                    break;
                case "nroVisitas":
                    modeloPuntaje.setNroVisitas(in.nextInt());
                    break;
                case "tipo":
                    modeloPuntaje.setTipo(in.nextString());
                    break;
                default:
                    in.nextString();
                    System.out.println("Error al leer desde bdFirebase");
                    break;
            }
        }
        in.endObject();
        return modeloPuntaje;
    }
}
