package com.java.baozhuanglei;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("Hello");
        StringBuilder sb2=sb;
        sb.append("world");
        System.out.println(sb);
        System.out.println(sb2);
        String str="";
        long start=System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            str=str+i;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        StringBuilder str1=new StringBuilder("Hello");
        long start1=System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            str1.append(i);
        }
        long end1=System.currentTimeMillis();
        System.out.println(end1-start1);
    }
}
