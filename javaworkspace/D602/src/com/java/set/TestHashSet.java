package com.java.set;
import java.util.*;
public class TestHashSet {
    public static void main(String[] args) {
        //创建集合
        HashSet<String> set=new HashSet<>();
        String s1="aaa";
        String s2="bbb";
        String s3=new String("ccc");
        String s4=new String("ccc");
        System.out.println(s3==s4);//F
        System.out.println(s3.equals(s4));//T
        set.add(s1);set.add(s2);
        set.add(s3);
        set.add(s4);//内容不能重复
        //遍历
        for (String s:set) {
            System.out.println(s);//无序输出
        }
    }
}
