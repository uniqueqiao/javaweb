package com.java.io;

import java.io.*;

public class TestOutputStreamWriter {
    public static void main(String[] args) throws Exception {
        //创建字节节点流对象
        FileOutputStream fos = new FileOutputStream("file/gbk2.txt");
        //创建桥转换流，同时设置编码格式GBK
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        //包装过滤流，增强写功能
        PrintWriter pw = new PrintWriter(osw);
        //读
        pw.println("一一一一一一");
        pw.println("二二二二二二");
        pw.println("三三四四");
        //关闭最外层
        pw.close();
    }
}
