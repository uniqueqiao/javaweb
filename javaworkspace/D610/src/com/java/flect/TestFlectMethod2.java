package com.java.flect;

import java.util.ArrayList;

public class TestFlectMethod2 {
    public static void main(String[] args) throws Exception {
        //通过反射技术获取实例
        //获取类对象
//        Class c=Class.forName("com.java.flect.Student");
//        //获取实例
//        Object obj=c.newInstance();
//        Student s=(Student) obj;//会调用无参构造
//        s.setAge(18);
//        System.out.println(obj);
        Object obj=getObject("com.java.flect.Student");
        System.out.println(obj);
        Object array=getObject("java.util.ArrayList");
        ArrayList list = (ArrayList)array;
        list.add(12);
        System.out.println(array);

    }
    public static Object getObject(String className) throws Exception {
        //通过类名获取类对象
        Class c=Class.forName(className);
        //通过对象获取实例
        Object obj=c.newInstance();
        return obj;
    }
}
