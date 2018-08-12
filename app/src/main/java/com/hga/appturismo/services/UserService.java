package com.hga.appturismo.services;

import android.content.Context;

import com.hga.appturismo.bdSQLite.SqliteUsuario;
import com.hga.appturismo.modelo.ModeloUsuario;

import java.util.ArrayList;

public class UserService implements ServicesInterface<ModeloUsuario> {

    private ArrayList<ModeloUsuario> modeloUsuarios;
    private SqliteUsuario sqliteUsuario;
    private Context context;

    public UserService(Context context) {
        this.context = context;
    }

    @Override
    public boolean insert(ModeloUsuario element) {
        return false;
    }

    @Override
    public void delete(int i) {

    }

    @Override
    public void update(ModeloUsuario element) {

    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public ArrayList<ModeloUsuario> list() {
        modeloUsuarios = new ArrayList<>();
        sqliteUsuario = new SqliteUsuario(context);
        ArrayList<ModeloUsuario> aux = sqliteUsuario.list();
        modeloUsuarios.addAll(aux);
        return modeloUsuarios;
    }

    @Override
    public ModeloUsuario show(int i) {
        return null;
    }
}
