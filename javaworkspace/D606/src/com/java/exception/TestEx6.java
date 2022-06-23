package com.java.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class TestEx6 {
    public static void main(String[] args) {
        System.out.println("main-----start-----1");
        m1(8);
        System.out.println("main------end------2");
        System.out.println("********************");
        System.out.println("main-----start-----1");
        m1(2);
        System.out.println("main------end------2");
        System.out.println("********************");
        System.out.println("main-----start-----1");
        m1(5);
        System.out.println("main------end------2");
    }
    public static void m1(int n) {
        System.out.println("m1()-----start-----3");
        try {
            m2(n);
        }catch (SQLException e) {
            System.out.println("3+");
        }
        System.out.println("m1()------end------4");
    }
    public static void m2(int n) throws SQLException {
        System.out.println("m2()-----start-----5");
        try{
            if (n==1){throw new  RuntimeException(); }
            if (n==2){ throw new ClassNotFoundException(); }
            if (n==3){ throw new EOFException(); }
            if (n==4){ throw new FileNotFoundException(); }
            if (n==5){ throw new SQLException(); }
            System.out.println("tryend-无异常----7");
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException异常已被处理----8");
        } catch (EOFException e) {
            System.out.println("Exception异常已被处理----9");
        } catch (IOException e) {//duotai
            System.out.println("Exception异常已被处理----9");
        }finally {
            System.out.println("finally");
        }

        System.out.println("m2()------end------6");
    }
}
