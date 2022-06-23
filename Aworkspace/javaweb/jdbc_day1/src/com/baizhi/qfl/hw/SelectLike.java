package com.baizhi.qfl.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectLike {
    public static void main(String[] args) throws Exception{
        //-- 7. 根据商品名模糊查询商品信息
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库
        String url="jdbc:mysql://localhost:3306/w2?characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url,"root","111111");
        System.out.println(conn);//测试连接
        // 准备SQL以及发送SQL的工具
        String sql = "select * FROM t_product where name like '%子%'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        //发送SQL
        ResultSet rs=pstm.executeQuery();//select
        //处理结果集
        while (rs.next()) {
            int id=rs.getInt("id");
            String name = rs.getString("Name");
            double price=rs.getDouble("price");
            int count=rs.getInt("count");
            int status=rs.getInt("status");
            String description= rs.getString("description");
            System.out.println(id+","+name+","+price+","+count+","+status+","+description);
        }
        //释放资源
        if(rs!=null) rs.close();
        if(pstm!=null)pstm.close();
        if(conn!=null) conn.close();
    }

}
