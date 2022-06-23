package com.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis= new FileInputStream("file/a.txt");//相对路径
       //读操作
        while(true){
            int c=fis.read();
            if (c == -1) {
                break;
            }
            System.out.println((char)c);

        }
        //关闭
        fis.close();
    }
}
