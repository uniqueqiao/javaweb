package com.baizi.qfl.test;

import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class TestUserDao {
    private UserDao userDao;
    @Before
    public void before() {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
         userDao = ctx.getBean("userDao", UserDao.class);
    }
    @Test
    public void queryAll(){
        List<User> list = userDao.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    /*@Test
    public void queryAllS(){
        UserService us= new UserServiceImpl();
        List<User> list = us.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }*/
    @Test
    public void add(){
        userDao.insert(new User(null,"testaddDaoSSM注解式",20,new Date()));

    }
   /* @Test
    public void addS(){
        UserService dao= new UserServiceImpl();
        dao.add(new User(null,"testservDao",20,new Date()));
        DBUtil.commit();
    }*/
}
