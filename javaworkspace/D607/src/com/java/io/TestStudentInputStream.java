package com.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestStudentInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建字节节点流对象
        FileInputStream fis= new FileInputStream("file/stu.txt");//相对路径
       //创建过滤流包装过滤流
        ObjectInputStream ois = new ObjectInputStream(fis);
        //读操作
        Object obj = ois.readObject();
        System.out.println(obj);
        //关闭
        ois.close();
    }
}
