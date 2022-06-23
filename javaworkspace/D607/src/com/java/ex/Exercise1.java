package com.java.ex;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise1 {
    public static void main(String[] args) throws FileNotFoundException {
        MyImpl m=new MyImpl();
        m.m1(2);
        m.m1(1);
    }
}
interface IA{
    void m1(int n);
}
class MyImpl implements IA {
    @Override
    public void m1(int n) {
        try {
            if (n==1)throw new FileNotFoundException("FileNotFoundException");
            if (n==2)throw new EOFException("EOFException异常！");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}