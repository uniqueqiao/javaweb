package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestSelectSex {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要查询的性别：");
        String sex= sc.next();
        //1. 2. 通过工具类获取连接
       Connection conn = JDBCUtil.getConnection();
       //3.准备SQL,以及发送工具
        String sql="SELECT * from person where sex=?";
        PreparedStatement pstm=conn.prepareStatement(sql);
        //绑定参数，发送SQL
        pstm.setString(1, sex);
        ResultSet rs=pstm.executeQuery();
        //处理结果集
        while (rs.next()) {
            int id=rs.getInt(1);
            String name = rs.getString(2);
            String sex1 = rs.getString(3);
            String tel = rs.getString(4);
            String email = rs.getString(5);
            String city = rs.getString(6);
            System.out.println(id+","+name+","+sex1+","+tel+","+email+","+city);
        }
        //释放资源
        JDBCUtil.close(rs,pstm, conn);
    }
}
