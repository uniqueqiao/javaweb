package com.java.baozhuanglei;

public class TestStudent {
    public static void main(String[] args) {
        Student s1=new Student("aa",18);
        Student s2 = new Student("bb",19,0.0);
        Student s3 = new Student("bb",19,0.0);
        System.out.println(s1);
        System.out.println(s2);
        s3.setScore(10.0);//double->Double
        double s=s3.getScore();//Double->double
        System.out.println(s);
    }
}
