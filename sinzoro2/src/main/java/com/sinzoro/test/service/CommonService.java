package com.sinzoro.test.service;

import java.util.List;

public interface CommonService<T> {
    
    public int countAll();
    
    public T findOneById(int Id);
    public T findOneByParam(String param);
    
    public List<T> findAll(T obj);
    public List<T> findAllByParam(String param);
    
}
