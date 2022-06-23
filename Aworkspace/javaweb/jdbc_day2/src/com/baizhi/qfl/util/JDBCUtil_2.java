package com.baizhi.qfl.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil_2 {
    //获取连接（加载驱动类，获取连接）
    public static Connection getConnection() {
        try {
            //降配置文件加载到Java
            Properties pro = new Properties();
            InputStream in= JDBCUtil_2.class.getResourceAsStream("/com/baizhi/qfl/conf/db.properties");
            pro.load(in);
            String driver= pro.getProperty("mydriver");
            String url= pro.getProperty("url");
            String username= pro.getProperty("username");
            String psw= pro.getProperty("password");

            //加载驱动类
            Class.forName(driver);
            //获取连接
            Connection conn= DriverManager.getConnection(url,username,psw);
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
