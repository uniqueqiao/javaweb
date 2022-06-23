package com.java.map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class TestStudent {
    public static void main(String[] args) {
        //key 学号 Value Student
        HashMap<String,Student> map=new HashMap<>();
        //添加元素
        map.put("wq101", new Student("张三",28,99.0));
        map.put("wq102", new Student("李四",25,93.0));
        map.put("wq103", new Student("乔一",38,96.0));
        System.out.println("键遍历");
        //获取所有键
        Set<String> keys = map.keySet();
        //遍历Set获取键
        System.out.println("----- 打印输出所有的学生信息----");
        for (String key : keys) {
            //key获取value
            Student value=map.get(key);
            System.out.println(key+"-"+value);
        }
        //(1) 打印输出平均成绩
        System.out.println("-----打印输出平均成绩----");
        double sum=0;
        for (String key : keys) {
            //key获取value
            Double value=map.get(key).getScore();
            sum+=value;
        }
        System.out.println("平均成绩："+sum/ map.size());
        //（2）输入学号，查询是否存在，是-输出信息，否-查无此人
        System.out.println("-----输入学号，查询是否存在，是-输出信息，否-查无此人----");
        Scanner sc=new Scanner(System.in);
        System.out.println("输入学号：");
        String sno=sc.next();
        //for (String key : keys) {
            //key获取value
        if(map.get(sno)!=null){//if(map.containsKey(sno)){
            Student value=map.get(sno);
            System.out.println(sno+"-"+value);

        }else {
            System.out.println("查无此人");
        }
        //}
        /*if (flag == 0) {
            System.out.println("查无此人");
        }*/
        //（3）输入一个成绩，输出成绩>该数的学生信息
        System.out.println("-----输入一个成绩，输出成绩>该数的学生信息----");
        System.out.println("输入成绩：");
        Double s=sc.nextDouble();
        for (String key : keys) {
            //key获取value
            Student value=map.get(key);
            if(value.getScore()>s){
                System.out.println(key+"-"+value);
            }
        }

    }
}
