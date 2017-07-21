package com.sinzoro.test.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinzoro.test.vo.BoardVO;

@Repository
public class BoardDao extends CommonDaoImpl<BoardVO> {
    
    @Autowired
    private SqlSessionTemplate sqlSession;
    
    // ���� �� Dao�� ������ �κи� �����Ѵ�.
    public int checkPassword(BoardVO vo) {
        return sqlSession.selectOne("BoardVO.checkPassword", vo);
    }
}