package com.java.baozhuanglei;

import java.util.*;

public class TestStringMethod {
    public static void main(String[] args) {
        String str="HelloWorld";
        System.out.println(str.length());
        char c=str.charAt(1);
        System.out.println(c);
        //遍历字符串
        for(int i=str.length()-1;i>=0;i--){
            char s=str.charAt(i);
            System.out.print(s+" ");
        }
/*
        //输出小写字母
        for(int i=0;i<str.length();i++){
            char s=str.charAt(i);
            if(s>='a'&&s<='z'){
                System.out.print(s+" ");
            }
        }*/
        /*String s1=new String("hello");
        String s2=new String("hello");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        String s3="java";
        String s4="Java";
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
        System.out.println(s3.equalsIgnoreCase(s4));
        String code="qWEr";
        System.out.println("验证码："+code);
        Scanner sc=new Scanner(System.in);
        System.out.println("输入验证码：");
        String newCode=sc.next();
        if(code.equalsIgnoreCase(newCode)){
            System.out.println("验证成功");
        }else{
            System.out.println("验证成功");
        }*/
       /* String str="hello";
        System.out.println(str.toUpperCase());
        String str1="HELLO";
        System.out.println(str1.toLowerCase());
        System.out.println(str.indexOf("el"));
        System.out.println(str.indexOf("lle"));//-1
        String str3="test.java";
        System.out.println(str3.endsWith(".java"));
        System.out.println(str3.endsWith(".javas"));
        System.out.println(str3.startsWith("t"));
        System.out.println(str3.startsWith("s"));
        String str4="Helloworld";
        System.out.println(str4.substring(1,4));//1-3不包含右边界
        String str5=" He ll o wor ld ";
        System.out.println(str5.trim());
        String age="18 ";
        int a=Integer.parseInt(age.trim());
        System.out.println(a);
        String str6="hello-java-world";
        String[] s=str6.split("-");
        for (int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }*/
        //判断字符串是否以张开头
       /* String name="张三";
        System.out.println(name.startsWith("张"));//1
        System.out.println(name.charAt(0)=='张');//2
        char[] c=name.toCharArray();//3
        System.out.println(c[0]=='张');
        System.out.println(name.indexOf("张")==0);//4
        String firstName=name.substring(0,1);//5
        System.out.println(firstName.equals("张"));*/
        /*String s1="hello";
        String s2=s1;
        s1=s1+"world";
        System.out.println(s1);//helloworld
        System.out.println(s2);//hello*/
        String a="Abc",b="abc";
        System.out.println(a.equals(b));
        System.out.println(a.charAt(1));
        String s="abcdefg";
        for(int i=1;i<s.length();i+=2){
            System.out.println(s.charAt(i));
        }
    }
}
