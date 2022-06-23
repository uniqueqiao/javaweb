package com.java.hw;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.sql.SQLException;

public class W9 {
    public static void main(String[] args) {
        System.out.println("main 1");
        m1(1);
        System.out.println("main 2");
        System.out.println("********************");
        System.out.println("main 1");
        m1(2);
        System.out.println("main 2");
        System.out.println("********************");
        System.out.println("main 1");
        m1(3);
        System.out.println("main 2");
        System.out.println("********************");
        System.out.println("main 1");
        m1(4);
        System.out.println("main 2");
        System.out.println("********************");
        System.out.println("main 1");
        m1(5);
        System.out.println("main 2");
        System.out.println("********************");

    }
    public static void m1(int n) {
        try {
            System.out.println("ma1");
            m2(n);
            System.out.println("ma2");
        } catch (EOFException e) {
            System.out.println("catch EOFException");
        } catch (FileNotFoundException e) {
            System.out.println("catch IOException");
        } catch (SQLException e) {
            System.out.println("catch SQLException");
        } finally {
            System.out.println("In finally");
        }

    }
    public static void m2(int n) throws EOFException, FileNotFoundException, SQLException {
        System.out.println("mb1");
        if (n==1){throw new EOFException(); }
        if (n==2){ throw new FileNotFoundException(); }
        if (n==3){ throw new SQLException(); }
        if (n==4){ throw new NullPointerException(); }
        System.out.println("mb2");


    }
}
