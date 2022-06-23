package com.java.exception;

public class TestFinally {
    public static void main(String[] args) {
        test(1);
        System.out.println("----------");
        test(2);
    }

    public static void test(int n) {
        try {
            System.out.println("try----1");
            if(n==1){throw new ClassNotFoundException();}
            System.out.println("try----2");
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException处理----3");
        }finally {
            System.out.println("finally---4");
        }
    }
}
