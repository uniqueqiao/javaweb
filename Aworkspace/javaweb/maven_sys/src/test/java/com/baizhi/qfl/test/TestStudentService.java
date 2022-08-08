package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.*;
import com.baizhi.qfl.service.CityService;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.service.StudentService;
import com.baizhi.qfl.service.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestStudentService {
    @Test
    public void queryAll(){
        StudentService ss =new StudentServiceImpl();
        List<Student> list= ss.getStudent(2);
        for (Student city : list) {
            System.out.println(city);
        }
    }
    @Test
    public void queryLike(){
        StudentService ss =new StudentServiceImpl();
        List<Student> list= ss.getStudentLike("name","yan" );
        for (Student s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void totalPage(){
        StudentService ss =new StudentServiceImpl();
        System.out.println(ss.getTotalPage());

    }
    @Test
    public void delete(){
        StudentService ss =new StudentServiceImpl();
        ss.deleteById(21);

    }
    @Test
    public void selectById(){
        StudentService ss =new StudentServiceImpl();
        System.out.println(ss.getStudentById(35));

    }
    @Test
    public void insert(){
        StudentService ss =new StudentServiceImpl();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        Student s=new Student(null,"111",null,"111111",
                "11111",new Date(),null,null,
                null,
                new Clazz(11,null,null,null),
                new Group(5,null,null,
                        new Clazz(11,null,null,null)),
                new City(4,null),
                new ArrayList<Tag>());
        System.out.println(s);
        ss.insert(s,list);

    }
}
