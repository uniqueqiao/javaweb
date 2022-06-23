package com.java.yuekao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class W7 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("file/city.txt");
        FileOutputStream fos = new FileOutputStream("file/city_copy.txt");
        //边读边写
        while (true){
            int c=fis.read();
            if (c == -1) {
                break;
            }
            fos.write(c);
        }
        //关闭流
        fis.close();
        fos.close();
    }
}
