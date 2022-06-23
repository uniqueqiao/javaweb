package com.java.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestEx {
    public static void main(String[] args)throws Exception {
        System.out.println("main-----start-----1");
        m1(8);
        System.out.println("main------end------2");
        System.out.println("*********************");
        System.out.println("main-----start-----1");
        m1(2);
        System.out.println("main------end------2");
    }
    public static void m1(int n) throws IOException, ClassNotFoundException {
        System.out.println("m1()-----start-----3");
        m2(n);
        System.out.println("m1()------end------4");
    }
    public static void m2(int n) throws ClassNotFoundException, FileNotFoundException, EOFException {
        System.out.println("m2()-----start-----5");
        //异常不一定运行
        if (n==1){throw new  RuntimeException(); }
        //非运行时异常
        if (n==2){ throw new ClassNotFoundException(); }
        if (n==3){ throw new FileNotFoundException(); }
        if (n==4){ throw new EOFException(); }
        System.out.println("m2()------end------6");
    }
    public static int test() {
        return 0;
        //System.out.println();//Unreachable
    }
}
