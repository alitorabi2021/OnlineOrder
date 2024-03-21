package com.example.onlineorders.service;

import java.util.List;

public interface IService<T> {


    String saveOrUpdate(T t);
    T getById(Integer id);
    List<T> getAll();
    String delete(T t);





}
