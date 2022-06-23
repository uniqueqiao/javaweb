package com.java.hw;

import java.util.HashSet;
import java.util.Scanner;

public class SetWork2 {
    public static void main(String[] args) {
        //(Set)编程：键盘输入一个字符串，利用集合去除其重复字符，打印输出最终不同的字符.
        //String s="aaabbbccddd";
        Scanner sc  = new Scanner(System.in);
        System.out.println("输入字符串：");
        String s=sc.next();
        HashSet<Character> set = new HashSet<>();
        //字符串转为char数组
        char[] c =  s.toCharArray();
        //循环赋值
        for (int  i = 0; i < c.length; i++) {
            set.add(c[i]);
        }
        //遍历
        for (Character ch:set) {
            System.out.print(ch);
        }

    }
}
