package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Account;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao{
    //删除
    public void deleteById(int id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql="delete from accounts where accId=?";
            pstm = conn.prepareStatement(sql);
            // 绑定参数，发送SQL
            pstm.setInt(1,id);
            int n=pstm.executeUpdate();
            System.out.println("受影响行数"+n);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(null,pstm, null);
        }
    }
    //查询一个
    public Account selectById(int id){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs= null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql="select * from accounts where accId=?";
            pstm = conn.prepareStatement(sql);
            // 绑定参数，发送SQL
            pstm.setInt(1, id);
            rs=pstm.executeQuery();//select
            // 处理结果集   select才需要
            Account acc=null;
            while (rs.next()){//有数据需要处理
                int accId=rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                double balance=rs.getDouble(4);
                acc=new Account(accId,name,password,balance);
                //System.out.println(accId+","+name+","+password+","+balance);
            }
            return acc;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(rs,pstm, null);
        }
    }
    //增加
    public void insert(Account acc){
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql="INSERT INTO accounts(accName,password,balance) VALUES (?,?,?)";
            pstm = conn.prepareStatement(sql);
            // 绑定参数，发送SQL
            pstm.setString(1, acc.getAccName());
            pstm.setString(2, acc.getPassword());
            pstm.setDouble(3, acc.getBalance());
            int n=pstm.executeUpdate();
            System.out.println("受影响行数"+n);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(null,pstm, null);
        }
    }

    //修改
    public void update(Account acc) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql = "UPDATE accounts set accName=?,password=?,balance=? where accId=?";
            pstm = conn.prepareStatement(sql);
            // 绑定参数，发送SQL
            pstm.setString(1, acc.getAccName());
            pstm.setString(2, acc.getPassword());
            pstm.setDouble(3, acc.getBalance());
            pstm.setInt(4, acc.getAccId());
            int n = pstm.executeUpdate();
            System.out.println("受影响行数" + n);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(null, pstm,null);
        }
    }

    //查所有
    public List<Account> selectAll(){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs= null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql="select * from accounts ";
            pstm = conn.prepareStatement(sql);
            // 发送SQL
            rs=pstm.executeQuery();//select
            // 处理结果集   select才需要
            List<Account> list=new ArrayList<Account>();
            while (rs.next()){//有数据需要处理
                int accId=rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                double balance=rs.getDouble(4);
                Account acc=new Account(accId,name,password,balance);
                list.add(acc);
                //System.out.println(accId+","+name+","+password+","+balance);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(rs,pstm, null);
        }
    }
    //模糊查询
    public List<Account> selectLike(String text){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs= null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql="select * from accounts where accName like ?";
            pstm = conn.prepareStatement(sql);
            // 绑定参数 发送SQL
            pstm.setString(1, "%"+text+"%");
            rs=pstm.executeQuery();//select
            // 处理结果集   select才需要
            List<Account> list=new ArrayList<Account>();
            while (rs.next()){//有数据需要处理
                int accId=rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                double balance=rs.getDouble(4);
                Account acc=new Account(accId,name,password,balance);
                list.add(acc);
                //System.out.println(accId+","+name+","+password+","+balance);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(rs,pstm, null);
        }
    }
}
/*public void (){
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(null,pstm, conn);
        }
}
 */