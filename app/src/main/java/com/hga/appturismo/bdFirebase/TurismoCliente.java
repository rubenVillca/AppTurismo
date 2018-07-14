package com.hga.appturismo.bdFirebase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hga.appturismo.typeAdapter.HotelResponseTypeAdapter;
import com.hga.appturismo.typeAdapter.LugarResponseTypeAdapter;
import com.hga.appturismo.typeAdapter.PuntajeResponseTypeAdapter;
import com.hga.appturismo.typeAdapter.RestauranteResponseTypeAdapter;
import com.hga.appturismo.typeAdapter.UsuarioResponseTypeAdapter;
import com.hga.appturismo.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HGA on 31/08/2017
 */

public class TurismoCliente {
    private Retrofit retrofit;

    public TurismoCliente(HotelResponseTypeAdapter hotelResponseTypeAdapter){

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ListaResponse.class,hotelResponseTypeAdapter)
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.FIREBASE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public TurismoCliente(RestauranteResponseTypeAdapter restauranteResponseTypeAdapter){

        Gson gson = new GsonBuilder()
                //.setLenient()
                .registerTypeAdapter(ListaResponse.class,restauranteResponseTypeAdapter)
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.FIREBASE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public TurismoCliente(LugarResponseTypeAdapter lugarResponseTypeAdapter){

        Gson gson = new GsonBuilder()
                //.setLenient()
                .registerTypeAdapter(ListaResponse.class,lugarResponseTypeAdapter)
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.FIREBASE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public TurismoCliente(UsuarioResponseTypeAdapter usuarioResponseTypeAdapter){
        Gson gson = new GsonBuilder()
                //.setLenient()
                .registerTypeAdapter(ListaResponse.class,usuarioResponseTypeAdapter)
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.FIREBASE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public TurismoCliente(PuntajeResponseTypeAdapter usuarioResponseTypeAdapter){
        Gson gson = new GsonBuilder()
                //.setLenient()
                .registerTypeAdapter(ListaResponse.class,usuarioResponseTypeAdapter)
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.FIREBASE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public TurismoFirebaseService getService(){
        return retrofit.create(TurismoFirebaseService.class);
    }
}
