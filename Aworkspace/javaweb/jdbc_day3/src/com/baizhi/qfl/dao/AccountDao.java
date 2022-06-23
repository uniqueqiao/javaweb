package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Account;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

interface AccountDao {
    //删除
    public void deleteById(int id);
    //查询一个
    public Account selectById(int id);
    //增加
    public void insert(Account acc);

    //修改
    public void update(Account acc);
    //查所有
    public List<Account> selectAll();
    //模糊查询
    public List<Account> selectLike(String text);
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