package com.baizhi.qfl.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateId {
    public static void main(String[] args) throws Exception{
        //-- 5. 根据id修改商品信息
        // 加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        // 建立连接
        String url="jdbc:mysql://localhost:3306/w2?characterEncoding=utf-8";
        Connection conn= DriverManager.getConnection(url,"root","111111");
        System.out.println(conn);
        //准备sql
        String sql="UPDATE t_product SET count=1234 where id=4;";
        PreparedStatement pstm=conn.prepareStatement(sql);
        //发送sql
        int n=pstm.executeUpdate();//insert,delete,update
        System.out.println("影响行数"+n);
        // 释放资源 先开的后释放 先conn开所以后conn关
        if(pstm!=null) pstm.close();
        if(conn!=null) conn.close();
    }
}
