package com.java.thread;

public class TestRunnable {
    public static void main(String[] args) {
        System.out.println("main----start---1");
//     创建任务对象
        MyTarget tg=new MyTarget();
        //创建线程对象
        Thread t=new Thread(tg);
        //开启线程
        t.start();
        for (int i=0; i<=1000;i++) {
            System.out.println("---444---"+i);
        }
        System.out.println("main----end---2");
    }
}
class MyTarget implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<=20;i++) {
            System.out.println("---333---"+i);
        }
    }
}