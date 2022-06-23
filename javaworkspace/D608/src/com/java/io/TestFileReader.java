package com.java.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReader {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("file/n.txt");
        //写
        fw.write('一');
        fw.write('二');
        fw.write('三');
        //关闭
        fw.close();
        //读
        FileReader fr = new FileReader("file/n.txt");
        while(true){
            int n=fr.read();
            if (n == -1) {
                break;
            }
            System.out.println(n+"-"+(char)n);
        }
        //关闭
        fr.close();
    }
}
