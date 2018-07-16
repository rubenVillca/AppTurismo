package com.hga.appturismo.typeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hga.appturismo.bdFirebase.ListaResponse;
import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HGA on 31/08/2017
 */

public class HotelResponseTypeAdapter extends TypeAdapter {
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public ListaResponse read(JsonReader in) throws IOException {
        final ListaResponse response = new ListaResponse();
        ArrayList<ModeloHotel> modeloHotels = new ArrayList<>();
        in.beginObject();
        while (in.hasNext()) {
            ModeloHotel modeloHotel = null;
            try {
                modeloHotel = readHotel(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modeloHotels.add(modeloHotel);
        }
        in.endObject();
        response.setListModeloHotel(modeloHotels);
        return response;
    }

    public ModeloHotel readHotel(JsonReader reader) throws IOException {
        ModeloHotel modeloHotel = new ModeloHotel();
        modeloHotel.setIdFirebase(reader.nextName());
        reader.beginObject();
        while (reader.hasNext()) {
            String next = reader.nextName();
            switch (next) {
                case "idSQLite":
                    modeloHotel.setIdSQLite(reader.nextInt());
                    break;
                case "idFirebase":
                    reader.nextString();
                    //modeloHotel.setIdFirebase(reader.nextString());
                    break;
                case "nombre":
                    modeloHotel.setNombre(reader.nextString());
                    break;
                case "gpsX":
                    modeloHotel.setGpsX(Float.parseFloat(reader.nextString()));
                    break;
                case "gpsY":
                    modeloHotel.setGpsY(Float.parseFloat(reader.nextString()));
                    break;
                case "direccion":
                    modeloHotel.setDireccion(reader.nextString());
                    break;
                case "imagenes":
                    modeloHotel.setImagenes(readImagenes(reader));
                    break;
                case "telefono":
                    modeloHotel.setTelefono(reader.nextInt());
                    break;
                case "provincia":
                    modeloHotel.setProvincia(reader.nextString());
                    break;
                case "paginaWeb":
                    modeloHotel.setPaginaWeb(reader.nextString());
                    break;
                case "email":
                    modeloHotel.setEmail(reader.nextString());
                    break;
                case "estado":
                    modeloHotel.setEstado(reader.nextString());
                    break;
                case "registradoPor":
                    modeloHotel.setRegistradoPor(reader.nextString());
                    break;
                default:
                    reader.nextString();//no usado
                    break;
            }
        }
        reader.endObject();
        return modeloHotel;
    }

    public ArrayList<ModeloImagen> readImagenes(JsonReader readerImg) throws IOException {
        ArrayList<ModeloImagen> modeloImagenArrayList = new ArrayList<>();
        readerImg.beginArray();
        while (readerImg.hasNext()) {
            ModeloImagen modeloImagen = readImagen(readerImg);
            modeloImagenArrayList.add(modeloImagen);
        }
        readerImg.endArray();
        return modeloImagenArrayList;
    }

    public ModeloImagen readImagen(JsonReader readImg) throws IOException {
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
