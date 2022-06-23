package com.java.hw;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class W1 {
    public static void main(String[] args) {
        /*(1)用FileOutputStream往当前目录下“test.txt”文件中写入“Hello World”；
        (2)利用FileInputStream读入test.txt文件，并在控制台上打印出test.txt中的内容。
        (3)要求用try-catch-finally处理异常，并且关闭流应放在finally块中。*/
        FileOutputStream fos=null;
        FileInputStream fis=null;
        try {
             fos= new FileOutputStream("file/text.txt");//相对路径
            String s="helloworld";
            for (int i=0;i<s.length();i++){
                char c=s.charAt(i);
                fos.write((int)c);
            }
            fis= new FileInputStream("file/text.txt");//相对路径
            //读操作
            while(true){
                int c=fis.read();
                if (c == -1) {
                    break;
                }
                System.out.println((char)c);

            }
        }catch (IOException e) {
            System.out.println("IO异常");
        }finally {
            try {
                if (fos != null) {//预防空指针异常
                    fos.close(); //关闭
                }
                if (fis != null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
