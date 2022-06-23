package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args)throws Exception {
        // 模拟客户端往accouts insert一条
        Scanner sc=new Scanner(System.in);
        System.out.println("输入用户名：");
        String name= sc.next();
        System.out.println("输入密码：");
        String psw= sc.next();
        System.out.println("输入余额：");
        double balance= sc.nextDouble();
        //1. 2. 通过工具类获取连接
        Connection conn = JDBCUtil.getConnection();
        // 准备SQL以及发送SQL的工具
        String sql="INSERT INTO accounts(accName,password,balance) VALUES (?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 绑定参数，发送SQL
        pstm.setString(1, name);
        pstm.setString(2, psw);
        pstm.setDouble(3, balance);
        int n=pstm.executeUpdate();
        System.out.println("受影响行数"+n);
        // 释放资源 先开的后释放 先conn开所以后conn关
        JDBCUtil.close(null,pstm, conn);
    }
}
