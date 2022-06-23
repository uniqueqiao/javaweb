package com.java.flect;

public class TestFlect {
    public static void main(String[] args) throws ClassNotFoundException {
        //类的对象  实例
        Student s=new Student("aa",19,98.0);
        //获取类对象
        Class c=s.getClass();
        System.out.println(c);
        //方法2：类名.class
        Class c2=Student.class;
        System.out.println(c2);
        System.out.println(c==c2);
        //方法三：静态
        Class c3 = Class.forName("com.java.flect.Student");//如果类第一次使用，也会类加载
        System.out.println(c3);
        System.out.println(c==c3);

    }
}
