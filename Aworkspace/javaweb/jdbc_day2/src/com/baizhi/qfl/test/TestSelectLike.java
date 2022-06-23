package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestSelectLike {
    public static void main(String[] args)throws Exception {
        // 模拟客户端往accouts select查一条
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要查询的关键字：");
        String myquery= sc.next();
        String name = "%" + myquery + "%";

        //1. 2. 通过工具类获取连接
        Connection conn = JDBCUtil.getConnection();
        // 准备SQL以及发送SQL的工具
        String sql="select * from accounts where accName like ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 绑定参数，发送SQL
        pstm.setString(1, name);
        ResultSet rs=pstm.executeQuery();//select
        // 处理结果集   select才需要
        if(rs.next()){//有数据需要处理
            int id=rs.getInt("accID");
            String accname = rs.getString(2);
            String password = rs.getString("password");
            double balance=rs.getDouble(4);
            System.out.println(id+","+accname+","+password+","+balance);
        }
        // 释放资源 先开的后释放 先conn开所以后conn关
        JDBCUtil.close(rs,pstm, conn);
    }
}
