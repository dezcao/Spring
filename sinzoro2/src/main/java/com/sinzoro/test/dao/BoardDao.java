package com.sinzoro.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinzoro.test.vo.BoardVO;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insert(BoardVO boardVO) {
		return sqlSession.insert("board.insert", boardVO);
	}
	public int delete(int id) {
	    return sqlSession.delete("board.delete", id);
	}
	public int update(BoardVO boardVO) {
	    return sqlSession.update("board.update", boardVO);
	}
	public List<BoardVO> findAll() {
	    return sqlSession.selectList("board.findAll");
	}
	public BoardVO findOne(int id) {
	    return sqlSession.selectOne("board.findOne", id);
	}
	
}