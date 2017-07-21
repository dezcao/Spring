package com.sinzoro.test.dao;

import java.util.List;

import com.sinzoro.test.vo.PageVO;

public interface CommonDao<T> {
    
    public int countAll();
    public T findOneById(int Id);
    public List<T> findAllByPageVO(PageVO vo);
    public int insert(T obj);
    public int update(T obj);
    public int delete(int Id);

}
