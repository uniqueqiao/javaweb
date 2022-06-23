package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TestUpdateId {
    public static void main(String[] args)throws Exception {
        // 模拟客户端往accouts select查一条
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要修改的id：");
        int myid= sc.nextInt();
        System.out.println("输入修改的用户名：");
        String name= sc.next();
        System.out.println("输入修改的性别：");
        String sex= sc.next();
        System.out.println("输入修改的电话：");
        String tel= sc.next();
        System.out.println("输入修改的邮箱：");
        String email= sc.next();
        System.out.println("输入修改的城市：");
        String city= sc.next();

        //1. 2. 通过工具类获取连接
        Connection conn = JDBCUtil.getConnection();
        // 准备SQL以及发送SQL的工具
        String sql="UPDATE person set name=?,sex=?,mobile=?,email=?,city=?  where id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 绑定参数，发送SQL
        pstm.setString(1, name);
        pstm.setString(2, sex);
        pstm.setString(3, tel);
        pstm.setString(4, email);
        pstm.setString(5,city);
        pstm.setInt(6, myid);
        int n=pstm.executeUpdate();//select
        System.out.println("受影响行数"+n);
        // 释放资源 先开的后释放 先conn开所以后conn关
        JDBCUtil.close(null,pstm, conn);
    }
}
