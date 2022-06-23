package com.baizhi.qfl.test;

import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TestDeleteId {
    public static void main(String[] args)throws Exception {
        // 模拟客户端往accouts insert一条
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要删除的id：");
        int myid= sc.nextInt();
        //1. 2. 通过工具类获取连接
        Connection conn = JDBCUtil.getConnection();
        // 准备SQL以及发送SQL的工具
        String sql="DELETE FROM person WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 绑定参数，发送SQL
        pstm.setInt(1,myid);
        int n=pstm.executeUpdate();
        System.out.println("受影响行数"+n);
        // 释放资源 先开的后释放 先conn开所以后conn关
        JDBCUtil.close(null,pstm, conn);
    }
}
