package com.hga.appturismo.bdSQLite;

import java.util.ArrayList;

/**
 * Created by HGA on 21/7/2018
 */
public interface SqliteInterface<T> {
    void insert(T item);

    void delete();

    void update(ArrayList<T> list);

    ArrayList<T> list();

    T getItem(String search);
}
