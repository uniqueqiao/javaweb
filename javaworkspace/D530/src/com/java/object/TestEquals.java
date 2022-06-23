package com.java.object;
public class TestEquals {
    public static void main(String[] args) {
        Student s=new Student("aa",18,99.5);
        Student s1=new Student("aa",18,99.5);
        Student s2=new Student();
        System.out.println(s.equals(s1));
        System.out.println(s);
        System.out.println(s2);
    }
}
