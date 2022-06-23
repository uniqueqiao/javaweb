package com.java.hw;

public class W13 implements Runnable {
    public static void main(String[] args) {
        Thread t=new Thread(new W13());
        t.start();
    }

    public void run(int limit) {
        for(int i=0;i<limit;i++){
            System.out.println(i);
        }
    }

    @Override
    public void run() {

    }
}
