package com.anuj.dao;

import com.anuj.models.Student;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentsDAO {
    private static final Logger logger = LoggerFactory.getLogger(StudentsDAO.class);
    private SqlSession sqlSession;

    public StudentsDAO(SqlSession sqlSession) {
        if (sqlSession == null) {
            throw new IllegalArgumentException("sqlSession should not be null");
        }
        this.sqlSession = sqlSession;
    }

    public void insertAll(Student student){
        try {
            sqlSession.insert("com.anuj.mybatis.mappers.Student.insert", student);
        }
        catch ( Exception e){
            throw e;
        }
    }
}
