package com.java.hw;

public class Work3 {
    public static void main(String[] args) {
        String str="hello";
        char[] c=str.toCharArray();
        for (int i = c.length - 1; i>=0; i--) {
            System.out.print(c[i]);
        }
    }
}
