package com.java.list;
import java.util.*;
public class TestArrayList {
    public static void main(String[] args) {
        //创建对象
        ArrayList list =new ArrayList();
        //添加元素
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println("集合个数"+list.size());
        System.out.println("获取下标位置的数据"+list.get(2));
        //遍历
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //下标越界异常
        //System.out.println("获取下标位置的数据"+list.get(3));//
        //删除元素
        list.remove(1);
        System.out.println("集合个数"+list.size());
        System.out.println("获取下标位置的数据"+list.get(1));
    }
}
