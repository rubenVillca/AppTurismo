package com.hga.appturismo.bdFirebase;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HGA on 31/08/2017
 */

public interface TurismoFirebaseService {
    @GET("HOTELES.json")
    Call<ListaResponse> getListHotel();

    @GET("RESTAURANTES.json")
    Call<ListaResponse> getListRestaurante();

    @GET("LUGARES.json")
    Call<ListaResponse> getListLugarTuristico();

    @GET("USUARIO.json")
    Call<ListaResponse> getListUsuarios();

    @GET("PUNTAJE.json")
    Call<ListaResponse> getListPuntaje();
}
