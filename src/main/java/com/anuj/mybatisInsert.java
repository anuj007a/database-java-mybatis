package com.anuj;

import com.anuj.dao.StudentsDAO;
import com.anuj.models.Student;

import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

public class mybatisInsert {
    private static final Logger logger = LoggerFactory.getLogger(mybatisInsert.class);
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("com/anuj/mybatis/sql-map-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //Create a new student object
        Student student = new Student("Mohammad", "It", 80, 984803322, "Mohammad@gmail.com");

        StudentsDAO studentsDAO = new StudentsDAO(session);
        //Insert student data
        studentsDAO.insertAll(student);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();

    }
}
