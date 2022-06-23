package com.java.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class W2 {
    public static void main(String[] args) {
        /*利用Random自动生成 0~5之间的数据，利用循环随机生成10个数据，利用
        利用Map存储生成的数据和出现的次数，遍历输出结果.*/
        Map<Integer,Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i<10;i++) {
            int s= random.nextInt(6);
            System.out.print(s+" ");

            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else {
                map.put(s,1);
            }
        }System.out.println();
        //set
        Set<Integer> keys = map.keySet();
        //遍历
        for (Integer key:keys) {
            int value = map.get(key);
            System.out.println(key+"出现"+value+"次");
        }
    }
}
