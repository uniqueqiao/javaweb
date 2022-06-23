package com.baizhi.qfl.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectId {
    public static void main(String[] args) throws Exception{
        // -- 2. 利用JDBC技术查询 id 对应的联系人信息
        // 1.加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/person?characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url,"root","111111");
        System.out.println(conn);//测试连接
        // 准备SQL以及发送SQL的工具
        String sql="SELECT * FROM persons where id=1";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 发送SQL
        ResultSet rs=pstm.executeQuery();//select
        // 处理结果集   select才需要
        if(rs.next()){//有数据需要处理
            int id=rs.getInt("id");
            String name = rs.getString("sname");
            double score=rs.getDouble("score");
            String email= rs.getString("email");
            System.out.println(id+","+name+","+email+","+score);
        }
        // 释放资源 先开的后释放 先conn开所以后conn关
        if(rs!=null) rs.close();
        if(pstm!=null) pstm.close();
        if(conn!=null) conn.close();
    }
}
