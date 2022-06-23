package com.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopy {
    public static void main(String[] args) throws IOException {
        //a.txt复制到c.txt
        FileInputStream fis= new FileInputStream("file/a.txt");//相对路径
        FileOutputStream copy= new FileOutputStream("file/c.txt");//相对路径
        while(true){
            int c=fis.read();
            if (c == -1) break;
            copy.write(c);
        }
        //关闭
        fis.close();
        copy.close();
    }
}
