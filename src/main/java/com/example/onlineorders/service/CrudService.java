package com.example.onlineorders.service;

import java.util.List;

public interface CrudService<T> {


    T update(T t);
    String save(T t);
    T getById(Integer id);
    List<T> getAll();
    String delete(T t);





}
