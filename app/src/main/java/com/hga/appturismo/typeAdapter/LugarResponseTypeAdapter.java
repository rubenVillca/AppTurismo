package com.hga.appturismo.typeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hga.appturismo.api.ListaResponse;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HGA on 31/08/2017
 */

public class LugarResponseTypeAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public ListaResponse read(JsonReader in) throws IOException {
        final ListaResponse response = new ListaResponse();
        ArrayList<ModeloLugarTuristico> turisticos = new ArrayList<>();
        in.beginObject();
        while (in.hasNext()) {
            ArrayList<ModeloLugarTuristico> modeloLugarTuristicosProvincia =new ArrayList<>();
            try {
                modeloLugarTuristicosProvincia = readProvincia(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            turisticos.addAll(modeloLugarTuristicosProvincia);
        }
        in.endObject();
        response.setListModeloLugarTuristico(turisticos);
        return response;
    }

    private ArrayList<ModeloLugarTuristico> readProvincia(JsonReader inProvincia) throws IOException {
        ArrayList<ModeloLugarTuristico> turisticos = new ArrayList<>();
        inProvincia.nextName();//provincia
        inProvincia.beginObject();
        while (inProvincia.hasNext()) {
            ModeloLugarTuristico turistico = null;
            try {
                turistico = readTuristico(inProvincia);
            } catch (Exception e) {
                e.printStackTrace();
            }
            turisticos.add(turistico);
        }
        inProvincia.endObject();
        return turisticos;
    }

    private ModeloLugarTuristico readTuristico(JsonReader reader) throws IOException {
        ModeloLugarTuristico turistico = new ModeloLugarTuristico();
        turistico.setIdFirebase(reader.nextName());
        reader.beginObject();
        while (reader.hasNext()) {
            String next = reader.nextName();
            switch (next) {
                case "idSQLite":
                    turistico.setIdSQLite(reader.nextInt());
                    break;
                case "idFirebase":
                    reader.nextString();
                    //turistico.setIdFirebase(reader.nextString());
                    break;
                case "provincia":
                    turistico.setProvincia(reader.nextString());
                    break;
                case "tipo":
                    turistico.setTipo(reader.nextString());
                    break;
                case "nombre":
                    turistico.setNombre(reader.nextString());
                    break;
                case "imagenes":
                    turistico.setImagenesFirebase(readImagenes(reader));
                    break;
                case "descripcion":
                    turistico.setDescripcion(reader.nextString());
                    break;
                case "horario":
                    turistico.setHorario(reader.nextString());
                    break;
                case "direccion":
                    turistico.setDireccion(reader.nextString());
                    break;
                case "telefono":
                    turistico.setTelefono(reader.nextInt());
                    break;
                case "gpsX":
                    turistico.setGpsX(Float.parseFloat(reader.nextString()));
                    break;
                case "gpsY":
                    turistico.setGpsY(Float.parseFloat(reader.nextString()));
                    break;
                case "actividad":
                    turistico.setActividad(reader.nextString());
                    break;
                case "estado":
                    turistico.setEstado(reader.nextString());
                    break;
                case "fecha":
                    turistico.setFecha(reader.nextString());
                    break;
                case "linea":
                    turistico.setLinea(reader.nextString());
                    break;
                default:
                    reader.nextString();
                    break;
            }
        }
        reader.endObject();
        return turistico;
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
