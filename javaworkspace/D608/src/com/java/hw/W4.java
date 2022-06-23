package com.java.hw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class W4 {
    public static void main(String[] args) throws Exception{
        //创建字节节点流对象
        FileInputStream fis = new FileInputStream("file/test.txt");
        //创建桥转换流，同时设置编码格式GBK
        InputStreamReader isr = new InputStreamReader(fis,"gbk");
        //包装过滤流，增强读功能
        BufferedReader br = new BufferedReader(isr);
        //创建字节节点流对象
        FileOutputStream fos = new FileOutputStream("file/test2.txt");
        //创建桥转换流，同时设置编码格式GBK
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
        //包装过滤流，增强写功能
        PrintWriter pw = new PrintWriter(osw);
        //test写到test2
        List<String> list=new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            pw.println(line);
            list.add(line);
        }
        //关闭最外层
        br.close();
        pw.close();
        //倒着读
        for (int i=list.size()-1;i>=0;i--) {
            System.out.println(list.get(i));
        }
    }
}
