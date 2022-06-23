package com.java.io;
import java.io.*;

public class TestObjectOutput  {
    public static void main(String[] args) throws IOException {
        //Product product = new Product("aaa",10.0,100,"sss");
        Student s=new Student("aaa",25,90.0);
        //创建节点流作为基础流
        OutputStream fos = new FileOutputStream("file/stu.txt");
        //创建过滤流对象，将基础流作为参数传递
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        //写操作
        oos.writeObject(s);
        //关闭
        oos.close();
    }
}
