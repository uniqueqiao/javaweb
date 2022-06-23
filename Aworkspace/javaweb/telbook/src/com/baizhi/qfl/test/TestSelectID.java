package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestSelectID {
    public static void main(String[] args)throws Exception {
        // 模拟客户端往accouts select查一条
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要查询的id：");
        int myid= sc.nextInt();
        //1. 2. 通过工具类获取连接
        Connection conn = JDBCUtil.getConnection();
        // 准备SQL以及发送SQL的工具
        String sql="select * from person where id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 绑定参数，发送SQL
        pstm.setInt(1, myid);
        ResultSet rs=pstm.executeQuery();//select
        // 处理结果集   select才需要
        while (rs.next()){//有数据需要处理
            int id=rs.getInt(1);
            String name = rs.getString(2);
            String sex = rs.getString(3);
            String tel = rs.getString(4);
            String email = rs.getString(5);
            String city = rs.getString(6);
            System.out.println(id+","+name+","+sex+","+tel+","+email+","+city);
        }
        // 释放资源 先开的后释放 先conn开所以后conn关
        JDBCUtil.close(rs,pstm, conn);
    }
}
