package com.java.io;

import java.io.*;

public class TestInputStreamReader {
    public static void main(String[] args) throws IOException {
        //利用桥转换流在utf-8环境下操作GBK的文件，
        //创建字节节点流对象
        FileInputStream fis = new FileInputStream("file/gbk.txt");
        //创建桥转换流，同时设置编码格式GBK
        InputStreamReader isr = new InputStreamReader(fis,"gbk");
        //包装过滤流，增强读功能
        BufferedReader br = new BufferedReader(isr);
        //读
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        //关闭最外层
        br.close();
    }
}
