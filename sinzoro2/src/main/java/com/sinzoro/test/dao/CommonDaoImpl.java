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
    * �� Ŭ������ �߻� Ŭ������ ���������ν�, �������� �� Ŭ������ ����ü�� ����� ���� �����Ѵ�,
    * (��ħǥ�� ��� �� �ؼ��� �³� �𸣰ڴ�...)
    * ���� �߻�Ŭ������ �������� ������ getClass(). getGenericSuperClass()�� ������Ʈ�� �����Ѵ�.
    * �׷��� �ͼ����� �߻��Ѵ� �ֳ��ϸ� ������Ʈ Ŭ������ �Ķ���͸� ���� �����ڸ� ���� �� ���� �����̴�.
    * (�⺻ ������ �ȿ� �Ķ���͸� �ְ� �ʹ�, �׷��� �Ѵ�...�� ���ε�.)
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
