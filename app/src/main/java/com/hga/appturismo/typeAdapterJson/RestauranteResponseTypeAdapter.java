package com.hga.appturismo.typeAdapterJson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloRestaurante;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HGA on 31/08/2017
 */

public class RestauranteResponseTypeAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public ListaResponse read(JsonReader in) throws IOException {
        final ListaResponse response = new ListaResponse();
        ArrayList<ModeloRestaurante> modeloRestaurantes = new ArrayList<>();
        in.beginObject();
        while (in.hasNext()) {
            ModeloRestaurante modeloRestaurante = null;
            try {
                modeloRestaurante = readRestaurante(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modeloRestaurantes.add(modeloRestaurante);
        }
        in.endObject();
        response.setListModeloRestaurante(modeloRestaurantes);
        return response;
    }

    private ModeloRestaurante readRestaurante(JsonReader reader) throws IOException {
        ModeloRestaurante modeloRestaurante = new ModeloRestaurante();
        modeloRestaurante.setIdFirebase(reader.nextName());
        reader.beginObject();
        while (reader.hasNext()) {
            String next = reader.nextName();
            switch (next) {
                case "idSQLite":
                    modeloRestaurante.setIdSQLite(reader.nextInt());
                    break;
                case "idFirebase":
                    reader.nextString();
                    break;
                case "nombre":
                    modeloRestaurante.setNombre(reader.nextString());
                    break;
                case "gpsX":
                    modeloRestaurante.setGpsX(Float.parseFloat(reader.nextString()));
                    break;
                case "gpsY":
                    modeloRestaurante.setGpsY(Float.parseFloat(reader.nextString()));
                    break;
                case "horario":
                    modeloRestaurante.setHorario(reader.nextString());
                    break;
                case "direccion":
                    modeloRestaurante.setDireccion(reader.nextString());
                    break;
                case "imagenes":
                    modeloRestaurante.setImagenesFirebase(readImagenes(reader));
                    break;
                case "telefono":
                    modeloRestaurante.setTelefono(reader.nextInt());
                    break;
                case "provincia":
                    modeloRestaurante.setProvincia(reader.nextString());
                    break;
                case "paginaWeb":
                    modeloRestaurante.setPaginaWeb(reader.nextString());
                    break;
                case "email":
                    modeloRestaurante.setEmail(reader.nextString());
                    break;
                case "estado":
                    modeloRestaurante.setEstado(reader.nextString());
                    break;
                case "registradoPor":
                    modeloRestaurante.setRegistradoPor(reader.nextString());
                    break;
                case "descripcion":
                    modeloRestaurante.setDescripcion(reader.nextString());
                    break;
                default:
                    reader.nextString();
                    break;
            }
        }
        reader.endObject();
        return modeloRestaurante;
    }

    private ArrayList<ModeloImagen> readImagenes(JsonReader readerImg) throws IOException {
        ArrayList<ModeloImagen> modeloImagenArrayList = new ArrayList<>();
        readerImg.beginArray();
        while (readerImg.hasNext()) {
            ModeloImagen modeloImagen = readImagen(readerImg);
            modeloImagenArrayList.add(modeloImagen);
        }
        readerImg.endArray();
        return modeloImagenArrayList;
    }

    private ModeloImagen readImagen(JsonReader readImg) throws IOException {
        ModeloImagen modeloImagen = new ModeloImagen();
        readImg.beginObject();
        while (readImg.hasNext()) {
            String name = readImg.nextName();
            switch (name) {
                case "idSqlite":
                    modeloImagen.setIdSqlite(readImg.nextInt());
                    break;
                case "idImagen":
                    modeloImagen.setIdImagen(readImg.nextInt());
                    break;
                case "idLugarReference":
                    modeloImagen.setIdLugarReference(readImg.nextInt());
                    break;
                case "tipoImagen":
                    modeloImagen.setTipoImagen(readImg.nextString());
                    break;
                case "urlApp":
                    modeloImagen.setUrlApp(readImg.nextString());
                    break;
                case "urlServer":
                    modeloImagen.setUrlServer(readImg.nextString());
                    break;
                default:
                    readImg.nextString();
                    break;
            }
        }
        readImg.endObject();

        return modeloImagen;
    }
}
