package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Manager;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDaoImpl implements ManagerDao{
    @Override
    public Manager selectByUserName(String name) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs= null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql="SELECT username,password FROM managers WHERE username=?";
            pstm = conn.prepareStatement(sql);
            // 绑定参数，发送SQL
            pstm.setString(1,name);
            rs=pstm.executeQuery();//select
            // 处理结果集   select才需要
            Manager m=null;
            while (rs.next()){//有数据需要处理
                String username = rs.getString(1);
                String password = rs.getString(2);
                m=new Manager(username,password);
            }
            return m;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(rs,pstm, null);
        }
    }
}
