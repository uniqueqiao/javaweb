package com.java.object;

import java.util.Objects;

public class TestToString {
    public static void main(String[] args) {
        Student s=new Student("aa",18,99.5);
        Student s1=new Student("bb",19,90.5);
        Student s2=new Student("cc",20,95.5);
        System.out.println(s.toString());
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
