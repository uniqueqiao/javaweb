package com.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
    public static void main(String[] args) throws IOException {
        //FileOutputStream fos= new FileOutputStream("F:/text/a.txt");//绝对路径
        FileOutputStream fos= new FileOutputStream("file/a.txt");//相对路径
        for(int i =65; i <91;i++){
            fos.write(i);
        }
        fos.close();
    }
}
