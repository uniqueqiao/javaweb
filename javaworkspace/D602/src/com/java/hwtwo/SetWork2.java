package com.java.hwtwo;

import java.util.HashSet;
import java.util.Random;

public class SetWork2 {
    public static void main(String[] args) {
        //3.(Set)编程：随机产生10个 0~50之间的整数，存储在集合中，要求集合中的数据不能重复.
        HashSet<Integer> set=new HashSet<>();
        Random rd= new Random(); //Random位于 java.util包中
        while (set.size()<10){
            set.add(rd.nextInt(51));//0~50之间的整数
        }
        for (Integer i:set) {
            System.out.println(i);
        }
    }
}
