package com.hga.appturismo.typeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hga.appturismo.api.ListaResponse;
import com.hga.appturismo.modelo.ModeloAcontecimiento;
import com.hga.appturismo.modelo.ModeloImagen;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HGA on 2/7/2018
 */
public  class AcontecimientoResponseTypeAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public ListaResponse read(JsonReader in) throws IOException {
        final ListaResponse response = new ListaResponse();
        ArrayList<ModeloAcontecimiento> modeloAcontecimientos = new ArrayList<>();
        in.beginObject();
        while (in.hasNext()) {
            ArrayList<ModeloAcontecimiento> modeloAcontecimiento =new ArrayList<>();
            try {
                modeloAcontecimiento = readProvincia(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modeloAcontecimientos.addAll(modeloAcontecimiento);
        }
        in.endObject();
        response.setListModeloAcontecimiento(modeloAcontecimientos);
        return response;
    }

    private ArrayList<ModeloAcontecimiento> readProvincia(JsonReader acontecimiento) throws IOException {
        ArrayList<ModeloAcontecimiento> modeloAcontecimientos = new ArrayList<>();
        acontecimiento.nextName();//provincia
        acontecimiento.beginObject();
        while (acontecimiento.hasNext()) {
            ModeloAcontecimiento modeloAcontecimiento = null;
            try {
                modeloAcontecimiento = readTuristico(acontecimiento);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modeloAcontecimientos.add(modeloAcontecimiento);
        }
        acontecimiento.endObject();
        return modeloAcontecimientos;
    }

    private ModeloAcontecimiento readTuristico(JsonReader reader) throws IOException {
        ModeloAcontecimiento modeloAcontecimiento = new ModeloAcontecimiento();
        modeloAcontecimiento.setIdFirebase(reader.nextName());
        reader.beginObject();
        while (reader.hasNext()) {
            String next = reader.nextName();
            switch (next) {
                case "idSQLite":
                    modeloAcontecimiento.setIdSQLite(reader.nextInt());
                    break;
                case "idFirebase":
                    reader.nextString();
                    //turistico.setIdFirebase(reader.nextString());
                    break;
                case "provincia":
                    modeloAcontecimiento.setProvincia(reader.nextString());
                    break;
                case "tipo":
                    modeloAcontecimiento.setTipo(reader.nextString());
                    break;
                case "nombre":
                    modeloAcontecimiento.setNombre(reader.nextString());
                    break;
                case "imagenes":
                    modeloAcontecimiento.setImagenesFirebase(readImagenes(reader));
                    break;
                case "descripcion":
                    modeloAcontecimiento.setDescripcion(reader.nextString());
                    break;
                case "horario":
                    modeloAcontecimiento.setHorario(reader.nextString());
                    break;
                case "direccion":
                    modeloAcontecimiento.setDireccion(reader.nextString());
                    break;
                case "telefono":
                    modeloAcontecimiento.setTelefono(reader.nextInt());
                    break;
                case "gpsX":
                    modeloAcontecimiento.setGpsX(Float.parseFloat(reader.nextString()));
                    break;
                case "gpsY":
                    modeloAcontecimiento.setGpsY(Float.parseFloat(reader.nextString()));
                    break;
                case "actividad":
                    modeloAcontecimiento.setActividad(reader.nextString());
                    break;
                case "estado":
                    modeloAcontecimiento.setEstado(reader.nextString());
                    break;
                default:
                    reader.nextString();
                    break;
            }
        }
        reader.endObject();
        return modeloAcontecimiento;
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
                case "id":
                    modeloImagen.setId(readImg.nextInt());
                    break;
                case "idImagen":
                    modeloImagen.setIdImagen(readImg.nextInt());
                    break;
                case "key_id":
                    modeloImagen.setKey_id(readImg.nextInt());
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
