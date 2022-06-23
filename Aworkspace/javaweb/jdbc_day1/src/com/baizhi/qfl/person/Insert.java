package com.baizhi.qfl.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {
    public static void main(String[] args) throws Exception{
       //-- 1. 利用JDBC技术往 persons表中插入一条数据
        // 1.加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/person?characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url,"root","111111");
        System.out.println(conn);//测试连接

        // 准备SQL
        String sql="INSERT INTO persons(sname,email,score) values('张张','zzzzzz',60)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 发送SQL
        int n=pstm.executeUpdate();//insert,delete,update
        System.out.println("影响行数"+n);
        // 处理结果集   select才需要
        // 释放资源 先开的后释放 先conn开所以后conn关
        if(pstm!=null) pstm.close();
        if(conn!=null) conn.close();
    }
}
