package com.java.set;
import java.util.*;
public class TestStudent {
    public static void main(String[] args) {
        Set<Student> stu=new HashSet<Student>();
        //创建多个学生对象
        stu.add(new Student("aa",38,99.0));
        stu.add(new Student("bb",18,89.0));
        stu.add(new Student("cc",28,87.0));
        stu.add(new Student("cc",28,87.0));
        //遍历
        for (Student s:stu) {
            System.out.println(s);
        }

    }
}
