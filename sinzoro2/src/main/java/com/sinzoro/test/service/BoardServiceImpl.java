package com.sinzoro.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinzoro.test.dao.BoardDao;
import com.sinzoro.test.dao.CommonDao;
import com.sinzoro.test.vo.BoardVO;

@Service
public class BoardServiceImpl extends CommonServiceImpl<BoardVO> {
    
    private BoardDao dao;
    public BoardServiceImpl() {
        
    }
    
    @Autowired
    public BoardServiceImpl(CommonDao<BoardVO> commonDao) {
        super(commonDao);
        this.dao = (BoardDao) commonDao;
    }
    
    public int checkPassword(BoardVO vo) {
        return dao.checkPassword(vo);
    }

}
