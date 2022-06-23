package com.java.hw;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class W4 {
    //4.将 电脑上的一个文件 拷贝到 当前项目根目录下 test 文件夹中
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("file/stu.txt");
        FileOutputStream fos = new FileOutputStream("file/stu_copy.txt");
        //边读边写
        while(true){
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
