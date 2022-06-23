package com.java.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream2 {
    public static void main(String[] args) throws IOException {
        //FileOutputStream fos= new FileOutputStream("F:/text/a.txt");//绝对路径
        FileOutputStream fos= new FileOutputStream("file/b.txt");//相对路径
        String s="helloworld";
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            fos.write((int)c);
        }
        fos.close();
    }
}
