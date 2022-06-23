package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.ManagerDaoImpl;
import com.baizhi.qfl.entity.Manager;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerServiceImpl implements ManagerService{
    @Override
    public boolean login(String username, String password) {
        Connection conn = null;
        try {
            //1. JDBCUtil 获取连接
            conn = JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            ManagerDaoImpl md = new ManagerDaoImpl();
            Manager m = md.selectByUserName(username);
            if (m != null) {
                if (m.getPassword().equals(password)) {
                    return true;
                }else {
                    return false;
                }
            }
            //4. 提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JDBCUtil.close(null, null, conn);
        }
        return false;
    }
}
