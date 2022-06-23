package com.baizhi.qfl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil_1 {
    //获取连接（加载驱动类，获取连接）
    public static Connection getConnection() {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            String url="jdbc:mysql://localhost:3306/bank?characterEncoding=utf-8";
            Connection conn= DriverManager.getConnection(url,"root","111111");
            System.out.println(conn);//测试连接
            return conn;
        }catch (Exception e) {
            e.printStackTrace();
            //将处理的异常转化为运行时异常通知调用者（非运行时异常--->运行时异常）
            throw new RuntimeException();
        }
    }
    //释放资源
    public static void close(ResultSet rs, PreparedStatement pstm,Connection conn){
        try {
            if(rs!=null) rs.close();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("结果集释放失败...");
        }
        try {
            if(pstm!=null) pstm.close();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发送SQL的工具释放失败...");
        }
        try {
            if(conn!=null) conn.close();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("连接资源释放失败...");
        }
    }

}
