package com.java.hw;
import java.util.*;
public class Work4 {
    public static void main(String[] args) {
        String str="ABCDEFGhijklmn1234567";
        char[] c=str.toCharArray();
        Random random = new Random();
        random.nextInt(c.length);
        for (int i =0; i<4; i++) {
            System.out.print(c[random.nextInt(c.length)]);
        }
    }
}
