package com.java.hw;

public class W15 {
    public static void main(String[] args) {
        Thread t1=new MyThread("hello");
        Thread t2=new MyThread("world");
        t1.start();
        t2.start();
    }
}
class MyThread extends Thread {
    private String data;

    public MyThread(String data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data){
            for (int i = 0;i<10;i++) {
                try {
                    System.out.println("sleepstart");
                    Thread.sleep((int)Math.random()*1000);
                    System.out.println("SleepEnd");
                }catch (Exception e) { }
                System.out.println(data);
            }
        }
    }

    public MyThread() {
    }
}