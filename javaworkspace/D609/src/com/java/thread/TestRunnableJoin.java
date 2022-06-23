package com.java.thread;

public class TestRunnableJoin {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main----start---1");
//     创建任务对象
        MyTarget2 tg=new MyTarget2();
        //创建线程对象
        Thread t=new Thread(tg);
        //开启线程
        t.start();
        t.join();//让线程先执行
        for (int i=0; i<=10;i++) {
            System.out.println("---444---"+i);
        }
        System.out.println("main----end---2");
    }
}
//线程任务类，run代表当前任务
class MyTarget2 implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<=20;i++) {
            System.out.println("---333---"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}