package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.UserDaoHW;
import com.baizhi.qfl.entity.Abc;
import com.baizhi.qfl.entity.Person;
import com.baizhi.qfl.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHw {
    @Test
    public void testPerson(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_hw.xml");
        //ctx就是工厂
        //获取对象
       Person p = (Person) ctx.getBean("person");
       p.test();
    }
    @Test
    public void testAbc(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_hw.xml");
        //ctx就是工厂
        //获取对象
        Abc abc = (Abc) ctx.getBean("abc");
        Abc abc1 = (Abc) ctx.getBean("abc");
        Abc abc2 = (Abc) ctx.getBean("abc");
        System.out.println(abc);//com.baizhi.qfl.entity.Abc@b3d7190
        System.out.println(abc1); //com.baizhi.qfl.entity.Abc@5fdba6f9
        System.out.println(abc2);//com.baizhi.qfl.entity.Abc@10d59286
    }
    @Test
    public void testUserDao(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_hw.xml");
        //ctx就是工厂
        //获取对象
        UserDaoHW udh = (UserDaoHW) ctx.getBean("userdao");
        UserDaoHW udh1 = (UserDaoHW) ctx.getBean("userdao");
        System.out.println(udh==udh1);
        System.out.println(udh);
        System.out.println(udh1);
    }
    @Test
    public void testUserService(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_hw.xml");
        //ctx就是工厂
        //获取对象
        UserServiceImpl usi = (UserServiceImpl) ctx.getBean("userServiceSet");
        usi.print();
    }
    @Test
    public void testUserServiceAuto(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_hw.xml");
        //ctx就是工厂
        //获取对象
        UserServiceImpl usi = (UserServiceImpl) ctx.getBean("userServiceSetAuto");
        usi.print();
    }
    @Test
    public void testUserServiceAutoName(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_hw.xml");
        //ctx就是工厂
        //获取对象
        //UserServiceImpl usi = (UserServiceImpl) ctx.getBean("userServiceSetAutoName");
        UserServiceImpl usi =ctx.getBean("userServiceSetAutoName",UserServiceImpl.class );//不用强转
        usi.print();
    }
}
