package com.java.thread;

public class TestMyThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main---start--1");
       //创建线程对象
        MyThread1 t = new MyThread1();
        //开启线程
        t.start();//默认run
        for (int i=0;i<20;i++) {
            System.out.println("main---center--"+i);
            Thread.sleep(500);//可消极处理
        }
        System.out.println("main---end--2");

    }
}

class MyThread1  extends Thread{
    public void run(){//覆盖
        for (int i=0; i<=20;i++) {
            System.out.println("---333---"+i);
            try {//不可消极处理因为是覆盖的run，不能抛出比父类更广的异常
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}