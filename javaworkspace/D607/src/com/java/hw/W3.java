package com.java.hw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class W3 {
    public static void main(String[] args) throws IOException {
        //3.在 E：/test 文件夹下创建 myFile.txt文件，
        // 直接给予一定的内容，利用字节流完成文件拷贝./**/
        FileInputStream fos= new FileInputStream("F:\\test\\myFile.txt");//相对路径
        FileOutputStream copy= new FileOutputStream("file/myFile_copy.txt");//相对路径
        while(true){
            int c=fos.read();
            if (c == -1) break;
            copy.write(c);
        }
        //关闭
        fos.close();
        copy.close();
    }
}
