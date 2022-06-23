package com.java.hw;

import java.io.File;

public class W19 {
    public static void main(String[] args) {
        File file = new File("file/hello.txt");
        System.out.println("文件是否存在："+file.exists());//文件是否存在TURE
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());//获取绝对路径
        }else {
            System.out.println("文件不存在");
        }
        File file2= new File("file/hello2.txt");
        System.out.println("文件是否存在："+file2.exists());//文件是否存在TURE
        if (file2.exists()) {
            System.out.println(file2.getAbsolutePath());//获取绝对路径
        }else {
            System.out.println("文件不存在");
        }
    }
}
