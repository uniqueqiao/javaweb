package com.java.thread;

public class TestMyThread {
    public static void main(String[] args) {
        System.out.println("main---start--1");
       //创建线程对象
        MyThread t = new MyThread();
        //开启线程
        t.start();//默认run
        for (int i=0;i<700;i++) {
            System.out.println("main---center--"+i);
        }
        System.out.println("main---end--2");

    }
}
class MyThread  extends Thread{
    public void run(){//覆盖
        for (int i=0; i<=20;i++) {
            System.out.println("---333---"+i);
        }
    }
}