package com.hga.appturismo.bdSQLite;

import com.hga.appturismo.activity.MainActivity;
import com.hga.appturismo.provider.Listas;

/**
 * Created by HGA on 21/7/2018
 */
public class DBSQLiteManager {
    public void resetSQLite(MainActivity mainActivity) {
        SqliteHotel hotel =new SqliteHotel(mainActivity);
        SqliteRestaurante restaurante =new SqliteRestaurante(mainActivity);
        SqliteLugar lugarTuristico =new SqliteLugar(mainActivity);
        SqliteUsuario usuario =new SqliteUsuario(mainActivity);


        Listas listas=new Listas();

        hotel.update(listas.getListaHoteles());
        lugarTuristico.update(listas.getListaLugares());
        restaurante.update(listas.getListaRestaurantes());
        usuario.update(listas.getListaUsuarios());
        usuario.updatePuntajeSQLite(listas.getListaPuntaje());
    }
}
