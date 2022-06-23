package com.java.hw;

public class W1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main-s-1");
        //创建线程对象
        MyThread1 t1 = new MyThread1();
        //开启线程
        t1.start();//默认run
        MyThread1 t2 = new MyThread1();
        //开启线程
        t2.start();//默认run
        //t1.join();
        System.out.println("main-e-2");
    }
}

//(1)一个线程输出1~26，另一个线程输出A~Z
//(2)一个线程使用继承Thread类的写法，另一个线程使用实现Runnable接口的写法
class MyThread1  extends Thread{
    public synchronized void run(){//覆盖
        for (int i=1; i<=26;i++) {
            System.out.println(i);
        }
    }
}

class MyTarget implements Runnable{
    @Override
    public synchronized void run() {
        for (char i='A'; i<='Z';i++) {
            System.out.println(i);
        }
    }
}