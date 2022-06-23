package com.java.hwtwo;

import com.java.map.Student;

import java.util.HashMap;
import java.util.Scanner;

public class MapWork4 {
    public static void main(String[] args) {
        //(1)利用Map：Key存储年份，value存储冠军国家
        HashMap<String,String> map=new HashMap<>();
        //id作为键，用户作为值
        map.put("2006","意大利");
        map.put("2002","巴西");
        map.put("1998","法国");
        map.put("1994","巴西");
        map.put("1990","德国");
        map.put("1986","阿根廷");
        map.put("1982","意大利");
        map.put("1978","阿根廷");
        map.put("1974","德国");
        map.put("1970","巴西");
        map.put("1966","英格兰");
        map.put("1962","巴西");
        map.put("1958","巴西");
        map.put("1954","德国");
        map.put("1950","乌拉圭");
        map.put("1938","意大利");
        map.put("1934","意大利");
        map.put("1930","乌拉圭");
        //(2)从命令行读入一个字符串，表示一个年份，输出该年的世界杯冠军是哪支球队。如果该年没有举办
        //世界杯，则输出：没有举办世界杯。
        System.out.println("输入一个年份：");
        Scanner sc=new Scanner(System.in);
        String year=sc.next();
        //输出该年的世界杯冠军是哪支球队
        if(map.containsKey(year)){//if(map.containsKey(sno)){
            String value=map.get(year);
            System.out.println(year+"年冠军是："+value);

        }else {//如果该年没有举办世界杯，则输出：没有举办世界杯。
            System.out.println("没有举办世界杯。");
        }
    }

}
