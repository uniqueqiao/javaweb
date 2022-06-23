package com.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopy3 {
    public static void main(String[] args) throws IOException {
        //复制视频
        FileInputStream fis= new FileInputStream("F:\\BaiduNetdiskDownload\\E01.mkv");//相对路径
        FileOutputStream copy= new FileOutputStream("file/Work15_copy.jpg");//相对路径
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
