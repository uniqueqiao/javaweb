package com.java.file;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("file/a.txt");
        System.out.println(file.exists());//文件是否存在TURE
        System.out.println(file.getName());//获取名字+后缀
        System.out.println(file.getAbsolutePath());//获取绝对路径
    }
}
