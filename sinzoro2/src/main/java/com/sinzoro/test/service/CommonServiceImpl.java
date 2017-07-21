package com.sinzoro.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinzoro.test.dao.CommonDao;
import com.sinzoro.test.vo.PageVO;

@Service
public class CommonServiceImpl<T> implements CommonService<T> {
    
    private CommonDao<T> commonDao;
    
    public CommonServiceImpl(CommonDao<T> commonDao) {
        this.commonDao = commonDao;
    }
    
    public CommonServiceImpl() {
    }
    
    @Override
    public int countAll() {
        return commonDao.countAll();
    }
    
    @Override
    public T findOneById(int Id) {
        return commonDao.findOneById(Id);
    }
    
    @Override
    public List<T> findAllByPageVO(PageVO vo) {
        return commonDao.findAllByPageVO(vo);
    }
    
    @Override
    @Transactional
    public int insert(T vo) {
        return commonDao.insert(vo);
    }
    
    @Override
    @Transactional
    public int update(T vo) {
        return commonDao.update(vo);
    }
    
    @Override
    @Transactional
    public int delete(int Id) {
        return commonDao.delete(Id);
    }

}
