package com.sinzoro.test.service;

public interface PageService<T> {
    
    void pagination(T obj, int totalCount);
    void pagination(T obj, int totalCount, int pageContents, int perPage);

}
