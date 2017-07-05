package com.sinzoro.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinzoro.test.vo.HomeVO;

@Repository
public class HomeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<HomeVO> zoro() {
		return sqlSession.selectList("sql.zoro");
	}

	public HomeVO getUserByName(String username) {
		return sqlSession.selectOne("sql.getUser", username);
	}
	
	public int insertUser(HomeVO vo) {
		return sqlSession.insert("sql.insertUser", vo);
	}
	
	public int insertAuthority(HomeVO vo) {
		return sqlSession.insert("sql.insertAuth", vo);
	}
	
}