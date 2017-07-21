package com.sinzoro.test.dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinzoro.test.vo.PageVO;

@SuppressWarnings({"unchecked", "rawtypes"})
@Repository
public abstract class CommonDaoImpl<T extends Serializable> implements CommonDao<T> {

    @Autowired
    private SqlSessionTemplate sqlSession;
    
    protected Class<? extends T> daoType;
    
    String sqlName = "";
    
    /**
    * By defining this class as abstract, we prevent Spring from creating 
    * instance of this class If not defined as abstract, 
    * getClass().getGenericSuperClass() would return Object. There would be 
    * exception because Object class does not hava constructor with parameters.
    * 
    * ???
    * 이 클래스를 추상 클래스로 정의함으로써, 스프링이 이 클래스를 구현체로 만드는 것을 방지한다,
    * (마침표가 없어서 이 해석이 맞나 모르겠다...)
    * 만약 추상클래스로 정의하지 않으면 getClass(). getGenericSuperClass()는 오브젝트를 리턴한다.
    * 그러면 익셉션이 발생한다 왜냐하면 오브젝트 클래스는 파라미터를 가진 생성자를 가질 수 없기 때문이다.
    * (기본 생성자 안에 파라미터를 넣고 싶다, 그래야 한다...는 말인듯.)
    */
    public CommonDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
        sqlName = daoType.getSimpleName();
    }
    
    public int countAll() {
      return sqlSession.selectOne(sqlName+".countAll");
    }
    
    public T findOneById(int Id) {
        return sqlSession.selectOne(sqlName+".findOneById", Id);
    }

    public List<T> findAllByPageVO(PageVO vo) {
        return sqlSession.selectList(sqlName+".findAllByPageVO", vo);
    }

    public int insert(T vo) {
        return sqlSession.insert(sqlName+".insert", vo);
    }

    public int update(T vo) {
        return sqlSession.update(sqlName+".update", vo);
    }

    public int delete(int Id) {
        return sqlSession.delete(sqlName+".delete", Id);
    }
}
