package com.java.hw;

import java.util.*;

public class Work2 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串");
        String s=sc.next();
        char[]  c=s.toCharArray();
        int count=0;
        for(int i=0;i<c.length;i++){
            if((c[i]>='a'&&c[i]<='z')||(c[i]>='A'&&c[i]<='Z')){
                count++;
            }
        }
        System.out.println("字符串中字母的数量："+count );
    }
}
