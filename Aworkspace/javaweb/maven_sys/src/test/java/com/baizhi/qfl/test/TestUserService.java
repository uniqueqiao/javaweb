package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.service.CityService;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.service.UserService;
import com.baizhi.qfl.service.UserServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestUserService {
    @Test
    public void insert(){
        UserService us=new UserServiceImpl();
        us.regist(new User(null,"qfl","111",new Date(),"admin",null));
    }
    @Test
    public void insert2(){
        UserService us=new UserServiceImpl();
        us.regist(new User(null,"stu","111",new Date(),"student",null));
    }
    @Test
    public void login(){
         UserService us=new UserServiceImpl();
         User user = new User(null,"qfl","111",null,"admin","null");
         us.Login(user);
    }

}
