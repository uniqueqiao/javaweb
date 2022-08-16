package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.service.UserService;
import com.baizhi.qfl.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class TestUserService {
    private UserService userService;
    @Before
    public void before() {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        userService = ctx.getBean("userService", UserService.class);
    }
    @Test
    public void queryAllS(){
        List<User> list = userService.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void addS(){
        userService.add(new User(null,"testservDao",20,new Date()));
    }
}
