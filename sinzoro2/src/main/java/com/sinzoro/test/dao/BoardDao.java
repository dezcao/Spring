package com.sinzoro.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinzoro.test.vo.BoardVO;
import com.sinzoro.test.vo.PageVO;

@Repository
public class BoardDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public int countAll() {
        return sqlSession.selectOne("board.countAll");
    }

    public BoardVO findOneById(int Id) {
        return sqlSession.selectOne("board.findOneById", Id);
    }

    public List<BoardVO> findAllByPageVO(PageVO vo) {
        return sqlSession.selectList("board.findAllByPageVO", vo);
    }

    public int insert(BoardVO vo) {
        return sqlSession.insert("board.insert", vo);
    }

    public int update(BoardVO vo) {
        return sqlSession.update("board.update", vo);
    }

    public int delete(int Id) {
        return sqlSession.delete("board.delete", Id);
    }

    public int checkPassword(BoardVO vo) {
        return sqlSession.selectOne("board.checkPassword", vo);
    }

}