package com.sinzoro.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinzoro.test.dao.BoardDao;
import com.sinzoro.test.vo.BoardVO;
import com.sinzoro.test.vo.PageVO;

@Service
public class BoardServiceImpl implements CommonService<BoardVO> {
    
    @Autowired
    BoardDao dao;

    @Override
    public int countAll() {
        return dao.countAll();
    }

    @Override
    public BoardVO findOneById(int Id) {
        return dao.findOneById(Id);
    }

    public List<BoardVO> findAllByPageVO(PageVO vo) {
        return dao.findAllByPageVO(vo);
    }

    @Override
    public int insert(BoardVO vo) {
        return dao.insert(vo);
    }

    @Override
    public int update(BoardVO vo) {
        return dao.update(vo);
    }

    @Override
    public int delete(int Id) {
        return dao.delete(Id);
    }

    public int checkPassword(BoardVO vo) {
        return dao.checkPassword(vo);
    }

}
