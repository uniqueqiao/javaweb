package com.java.flect;

import java.lang.reflect.Method;

public class TestFlectMethod {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c=Class.forName("com.java.flect.Student");
        System.out.println(c.getPackage().getName());//包名
        System.out.println(c.getName());//类名
        System.out.println(c.getSuperclass().getName());//父类名
        Class[] inters = c.getInterfaces();//获取实现的所有接口
        System.out.println("实现接口数："+inters.length);
        for (Class inter:inters) {
            System.out.println(inter);
        }
        Method[] ms=c.getMethods();//获取所有的公开方法(本类+父类)
        System.out.println("获取本类+父类的公开方法数："+ms.length);
        for (Method m:ms) {
            System.out.println(m.getName());
        }
        Method[] ms2=c.getDeclaredMethods();//获取本类所有的方法(包含非公开)
        System.out.println("获取本类的所有方法数："+ms2.length);
        for (Method m:ms2) {
            System.out.println(m.getName());
        }

    }
}
