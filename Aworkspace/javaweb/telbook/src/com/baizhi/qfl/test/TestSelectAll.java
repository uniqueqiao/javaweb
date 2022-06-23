package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSelectAll {
    public static void main(String[] args) throws Exception{
       //1. 2. 通过工具类获取连接
       Connection conn = JDBCUtil.getConnection();
       //3.准备SQL,以及发送工具
        String sql="SELECT * from person";
        PreparedStatement pstm=conn.prepareStatement(sql);
        //绑定参数，发送SQL
        ResultSet rs=pstm.executeQuery();
        //处理结果集
        while (rs.next()) {
            int id=rs.getInt(1);
            String name = rs.getString(2);
            String sex = rs.getString(3);
            String tel = rs.getString(4);
            String email = rs.getString(5);
            String city = rs.getString(6);
            System.out.println(id+","+name+","+sex+","+tel+","+email+","+city);
        }
        //释放资源
        JDBCUtil.close(rs,pstm, conn);
    }
}
