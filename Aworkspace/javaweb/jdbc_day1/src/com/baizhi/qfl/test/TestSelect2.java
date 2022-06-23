package com.baizhi.qfl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSelect2 {
    public static void main(String[] args) throws Exception {
        // 模拟客户端往accouts select查一条
        // 1.加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/bank?characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url,"root","111111");
        System.out.println(conn);//测试连接
        // 准备SQL以及发送SQL的工具
        String sql="select * from accounts";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 发送SQL
        ResultSet rs=pstm.executeQuery();//select

        // 处理结果集   select才需要
        while(rs.next()){//有数据需要处理
            int id=rs.getInt("accID");
            String name = rs.getString("accName");
            String password = rs.getString("password");
            double balance=rs.getDouble("balance");
            System.out.println(id+","+name+","+password+","+balance);
        }
        // 释放资源 先开的后释放 先conn开所以后conn关
        if(rs!=null) rs.close();
        if(pstm!=null) pstm.close();
        if(conn!=null) conn.close();
    }
}
