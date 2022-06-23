package com.java.object;

public class TestGC {
    public static void main(String[] args) {
        new Student();
        System.gc();
        for(int i=0;i<600000;i++){
            new Student();
        }
        System.out.println("end");
    }
}
