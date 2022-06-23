package com.java.hwtwo;
import java.util.*;
public class MapTWork11 {
    public static void main(String[] args) {
        //11.(Map) 给定一个字符串,请输出该字符串由哪些字符组成,每个字符出现几次?
        Scanner input = new Scanner(System.in);
        System.out.print("输入字符串：");
        String s = input.next();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
               //c已存在，个数加一
                Integer counter = map.get(c);
                map.put(c, counter+=1);
            } else {
                //新加一个字符,记为1
                map.put(c, 1);
            }
        }
        //System.out.println(map);
        //获取所有键
        Set<Character> keys = map.keySet();
        System.out.print("有字符：");
        for (Character key : keys) {
            System.out.print(key+" ");
        }
        //遍历Set获取键
        System.out.println();
        System.out.println("-----遍历----");
        for (Character key : keys) {
            //key获取value
            Integer value=map.get(key);
            System.out.println(key+"-"+value+"个");
        }
    }

}
