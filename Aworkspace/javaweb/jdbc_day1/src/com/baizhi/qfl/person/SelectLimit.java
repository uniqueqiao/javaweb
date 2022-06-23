package com.baizhi.qfl.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectLimit {
    public static void main(String[] args)throws Exception {
        //-- 8. 根据价格区间查询商品信息
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接 连接数据库
        String url="jdbc:mysql://localhost:3306/person?characterEncoding=utf-8";;
        Connection conn = DriverManager.getConnection(url,"root","111111");
        System.out.println(conn);//测试连接
        //准备SQL 以及发送SQL工具
        String sql="SELECT * FROM persons ORDER BY score desc LIMIT 4,5";
        PreparedStatement pstm = conn.prepareStatement(sql);
        //发送SQL
        ResultSet rs = pstm.executeQuery();
        //处理结果集
        while(rs.next()){//有数据需要处理
            int id=rs.getInt("id");
            String name = rs.getString("sname");
            double score=rs.getDouble("score");
            String email= rs.getString("email");
            System.out.println(id+","+name+","+email+","+score);
        }
        //释放资源
        if(rs!=null) rs.close();
        if(pstm!=null) pstm.close();
        if(conn!=null) conn.close();

    }
}
