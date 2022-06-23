package com.java.hwtwo;

import java.util.HashMap;
import java.util.Set;

public class MapWork5 {
    public static void main(String[] args) {
        //(1)使用Map，以老师的名字作为键，教授的课程名作为值，表示上述课程安排
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("Tom", "Corejava");
        map.put("John", "Oracle");
        map.put("Susan", "Oracle");
        map.put("Jerry", "JDBC");
        map.put("Jim", "Unix");
        map.put("Kevin", "JSP");
        map.put("Lucy", "JSP");
        //(2)增加了一位新老师Allen 教JDBC
        map.put("Allen", "JDBC");
        //(3)Lucy 改为教CoreJava
        map.put("Lucy", "CoreJava");
        //(4) 遍历Map，输出所有的老师及老师教授的课程
        //获取所有键
        Set<String> keys = map.keySet();
        //遍历Set获取键
        System.out.println("-----遍历输出所有的老师及老师教授的课程----");
        for (String key : keys) {
            //key获取value
            String value=map.get(key);
            System.out.println(key+"-"+value);
        }
        //System.out.println(map);
    }
}
