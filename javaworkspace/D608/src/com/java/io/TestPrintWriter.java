package com.java.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
    public static void main(String[] args) throws IOException {
        //创建字节流作为基础流
        FileWriter fw = new FileWriter("file/d.txt");
        //创建过滤流，基础流作为参数传递
        PrintWriter pw = new PrintWriter(fw);
        //写
        pw.println("一月又一月一样一样");
        pw.println("红红火火恍恍惚惚");
        pw.println("呵呵哈哈哈");
        //关闭
        pw.close();
    }
}
