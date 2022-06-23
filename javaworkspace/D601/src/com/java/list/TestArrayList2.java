package com.java.list;
import java.util.ArrayList;
import java.util.Locale;

public class TestArrayList2 {
    public static void main(String[] args) {
        //创建字符串集合对象
        ArrayList<String> list=new ArrayList<String>();
        //添加元素
        list.add("aaaa");
        list.add("bbbbbb");
        list.add("cccccc");
        //list.add(1);报错
        //list.add(18.8);报错
        //遍历
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("----小写转大写----");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toUpperCase());
        }
        /*for(int i=0;i<list.size();i++){
            Object s=list.get(i);
            String str=(String)s;
            System.out.println(str.toUpperCase());
        }*/
        System.out.println("----输出长度>5----");
        for(int i=0;i<list.size();i++){
            if(list.get(i).length()>5)
            System.out.println(list.get(i));
        }
        System.out.println("---foreach 遍历---");
        for (String s:list) {
            System.out.println(s);
        }
        System.out.println("---foreach 输出长度>5---");
        for (String s:list) {
            if(s.length()>5)
            System.out.println(s);
        }
    }
}
