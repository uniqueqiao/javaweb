package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.service.TestServiceImpl;
import com.baizhi.qfl.service.TestServiceImplAuto;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring2 {
    @Test
    public void test1(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
        //ctx就是工厂
        //获取对象
        TestServiceImpl ts=(TestServiceImpl) ctx.getBean("testService");
        System.out.println(ts.toString());
        ts.test();
    }
    @Test
    public void testAuto(){
        //启动工厂
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_auto.xml");
        //ctx就是工厂
        //获取对象
        TestServiceImplAuto ts=(TestServiceImplAuto) ctx.getBean("userService");
        ts.test();
    }
}
