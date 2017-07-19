package com.sinzoro.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinzoro.test.dao.BoardDao;
import com.sinzoro.test.vo.BoardVO;

@Service
public class BoardServiceImpl implements CommonService<BoardVO> {
    
    @Autowired
    BoardDao dao;
    
    @Override
    public int countAll() {
        dao.countAll();
        return 0;
    }

    @Override
    public BoardVO findOneById(int Id) {
        dao.findOneById(Id);
        return null;
    }

    @Override
    public BoardVO findOneByParam(String param) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BoardVO> findAll(BoardVO obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BoardVO> findAllByParam(String param) {
        // TODO Auto-generated method stub
        
        
        
        
        return null;
    }

    

}
