package com.java.hw;

import java.io.FileInputStream;
import java.io.IOException;

public class W18 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("file/t.txt");
            System.out.println(fis.read());
            fis.close();
        }catch (Exception e) {

        }
    }
}
