package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
//2.根据用户输入的信息 向联系人表里插入1条数据（使用自增）。
public class TestInsert {
    public static void main(String[] args)throws Exception {
        // 模拟客户端往accouts insert一条
        Scanner sc=new Scanner(System.in);
        System.out.println("输入用户名：");
        String name= sc.next();
        System.out.println("输入性别：");
        String sex= sc.next();
        System.out.println("输入电话：");
        String tel= sc.next();
        System.out.println("输入邮箱：");
        String email= sc.next();
        System.out.println("输入城市：");
        String city= sc.next();
        //1. 2. 通过工具类获取连接
        Connection conn = JDBCUtil.getConnection();
        // 准备SQL以及发送SQL的工具
        String sql="INSERT INTO person(name,sex,mobile,email,city) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 绑定参数，发送SQL
        pstm.setString(1, name);
        pstm.setString(2, sex);
        pstm.setString(3, tel);
        pstm.setString(4, email);
        pstm.setString(5, city);
        int n=pstm.executeUpdate();
        System.out.println("受影响行数"+n);
        // 释放资源 先开的后释放 先conn开所以后conn关
        JDBCUtil.close(null,pstm, conn);
    }
}
