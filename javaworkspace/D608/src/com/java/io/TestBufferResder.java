package com.java.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferResder {
    public static void main(String[] args) throws IOException {
        //创建字节流作为基础流
        FileReader fr = new FileReader("file/d.txt");
        //创建过滤流，基础流作为参数传递
        BufferedReader br = new BufferedReader(fr);
        //读
        while (true) {
            String n=br.readLine();
            if (n == null) {
                break;
            }
            System.out.println(n);
        }
        //关闭流
        br.close();
    }
}
