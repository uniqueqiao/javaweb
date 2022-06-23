package com.baizhi.qfl.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteID {
    public static void main(String[] args) throws Exception{
        // 1.加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/w2?characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url,"root","111111");
        System.out.println(conn);//测试连接
        // 准备SQL
        String sql="DELETE FROM t_product where id=2";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 发送SQL
        int n=pstm.executeUpdate();
        System.out.println("影响行数"+n);
        // 释放资源 先开的后释放 先conn开所以后conn关
        if(pstm!=null) pstm.close();
        if(conn!=null) conn.close();
    }
}
