package com.demo;


import com.demo.entity.Student;
import com.demo.mapper.StudentMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

public class StudentMapperTest extends DemoApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    @Rollback
    public void insertTest() throws Exception {
        Student student = new Student();
        student.setName("xiaoma");
        student.setAge(16);

        Integer insert = studentMapper.insert(student);
        System.out.println("insert value = " + insert);

    }

    @Test
    @Rollback
    public void updateByIdTest() {
        Student student = new Student();
        student.setAge(123);
        student.setName("weqee");
        student.setId(1L);

        Integer insert = studentMapper.updateById(student);
        System.out.println("return insert value = " + insert);
    }



}
