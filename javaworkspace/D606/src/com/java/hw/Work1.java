package com.java.hw;

public class Work1 {
    public static void main(String[] args) throws Exception {
        m1(2);
        m1(1);
        m2(2);
        m2(1);
    }
//1.使用两种方式处理 m1方法中的异常.
    public static void m1(int n) throws Exception{//方法一
       if(n==2) throw new Exception("");
    }
    public static void m2(int n) {//方法2
        try {
            if(n==2) throw new ClassNotFoundException();
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException-Catch");
        }
    }
}
