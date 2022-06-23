package com.java.list;
import java.util.*;
public class TestAL3 {
    public static void main(String[] args) {
        //集合存储多个学生对象
        //创建对象
        List<Student> stu=new ArrayList<>();
        //添加对象
        Student s3=new Student("王四",28,88.0,"10062587954");
        Student s2=new Student("张二二",18,97.0,"10056985477");
        Student s1=new Student("王以",38,99.0,"10085963256");
        stu.add(s1);
        stu.add(s2);
        stu.add(s3);
        stu.add(new Student("李三",19,93.0,"15515865899"));
        //遍历学生信息
        for (Student s:stu) {
            System.out.println(s);
        }
        System.out.println("-------打印平均成绩------");
        //计算学生平均成绩
        double sum=0;
        for (Student s:stu) {
            sum+=s.getScore();
        }
        System.out.println("平均成绩"+sum/ stu.size());
        System.out.println("-------打印输出成绩>90------");
        //打印输出成绩>90
        for (Student s:stu) {
            if(s.getScore()>90)
                System.out.println(s);
        }
        System.out.println("------计算班级平均年龄-----");
        //计算班级平均年龄
        double sum1=0;
        for (Student s:stu) {
            sum1+=s.getAge();
        }
        System.out.println("平均年龄"+sum1/ stu.size());
        System.out.println("-------打印王同学学生信息------");
        //打印王同学学生信息
        for (Student s:stu) {
            if(s.getName().startsWith("王"))
                System.out.println(s);
        }
        System.out.println("----打印学生电话100开头的信息----");
        //打印学生电话100开头的信息
        for (Student s:stu) {
            if(s.getTel().startsWith("100"))
                System.out.println(s);
        }
    }
}
