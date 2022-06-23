package com.java.yuekao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class W4 {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User u1 = new User("张三","123456","男");
        User u2 = new User("李四","123456","女");
        User u3 = new User("王五","123456","女");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        //遍历
        System.out.println("-----遍历-----");
        for (User u : list) {
            System.out.println(u);
        }
        //根据用户名查询
        System.out.println("-----根据用户名查询-----");
        System.out.println("输入要查询的用户名：");
        Scanner sc=new Scanner(System.in);
        String name = sc.next();
        int flag=0;
        for (User u : list) {
            if (u.getUserName().equals(name)) {
                System.out.println(u);
                flag=1;
            }
        }
        if (flag == 0) {
            System.out.println("查无此人");
        }
        //统计女用户数量，打印输出
        System.out.println("----统计女用户数量，打印输出---");
        int count=0;
        for (User u : list) {
            if (u.getSex().equals("女")) {
                count++;
            }
        }
        System.out.println("女性用户数："+count);
    }
}
