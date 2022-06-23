package com.java.hw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class W2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos= new FileOutputStream("file/aa.txt");//相对路径
        for(int i =65; i <91;i++){
            fos.write(i);
        }
        fos.close();
        FileInputStream fis= new FileInputStream("file/aa.txt");//相对路径
        //读操作
        StringBuilder sb=new StringBuilder();//拼接效率高
        while(true){
            int c=fis.read();
            if (c == -1) {
                break;
            }
            char a = (char) c;//int--》char
            sb.append(a);//拼接
            //System.out.print((char)c);
        }
        System.out.println(sb);
        //关闭
        fis.close();
    }
}
