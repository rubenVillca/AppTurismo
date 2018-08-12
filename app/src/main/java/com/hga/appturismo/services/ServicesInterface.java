package com.hga.appturismo.services;

import java.util.ArrayList;

public interface ServicesInterface<T> {
    boolean insert(T element);
    void delete(int i);
    void update(T element);
    boolean create();
    ArrayList<T> list();
    T show(int i);
}
