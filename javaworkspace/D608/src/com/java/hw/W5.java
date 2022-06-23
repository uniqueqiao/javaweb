package com.java.hw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class W5 {
    public static void main(String[] args) throws Exception{
        /*该文件采用“年份/世界杯冠军”的方式保存每一年世界杯冠军的信息。
        要求：读入该文件的基础上，让用户输入一个年份，输出该年的世界杯冠军。
        如果该年没有举办世界杯， 则输出“没有举办世界杯*/
        //创建字节节点流对象
        FileInputStream fis = new FileInputStream("file/worldcup.txt");
        //创建桥转换流，同时设置编码格式GBK
        InputStreamReader isr = new InputStreamReader(fis,"gbk");
        //包装过滤流，增强读功能
        BufferedReader br = new BufferedReader(isr);
        //读
        Map<String,String> map = new HashMap<String, String>();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] s=line.split("/");
            map.put(s[0],s[1]);
        }
        //关闭最外层
        br.close();
        //不用遍历!!!直接用containsKey
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个年份");
        String year= sc.next();
        if(map.containsKey(year)){
            String value=map.get(year);
            System.out.println("该年的世界杯冠军:"+value);
        }else{
            System.out.println("没有举办世界杯");
        }
        //键遍历,搞复杂了！！！
        int f=0;
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if(year.equals(key)){
                String value=map.get(year);
                System.out.println("该年的世界杯冠军:"+value);
                f=1;
            }
        }
        if(f==0)System.out.println("没有举办世界杯");
    }
}
