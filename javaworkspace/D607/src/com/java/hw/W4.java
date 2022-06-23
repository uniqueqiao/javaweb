package com.java.hw;

import java.util.ArrayList;
import java.util.Arrays;

public class W4 {
    public static void main(String[] args) {
        //4.(复习和io无关：)定义一个字符串“myworld”，遍历打印次数每个字符。
        String s="myworld";
        for (int i = 0; i < s.length();i++) {
            System.out.println(s.charAt(i));
        }
        //5.(复习和io无关：)定义多个字符串，存储在List集合中，遍历输出。
        ArrayList<String> list=new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (String str:list) {
            System.out.println(str);
        }
    }
}
