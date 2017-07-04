package com.sinzoro.test.dao;

import java.util.HashMap;
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
		System.out.println("???????");
		return sqlSession.selectOne("sql.getUser", username);
	}
	
}