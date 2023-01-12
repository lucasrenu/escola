package com.utils;

import java.util.List;

public interface GenericDAO <E>{
    boolean insert(E e);
    public E select(int id);
    public List<E> select();
    public List<E> select(String nome);
    public boolean update(E e);
    public boolean delete(E e);
    public boolean delete(int id);
}
