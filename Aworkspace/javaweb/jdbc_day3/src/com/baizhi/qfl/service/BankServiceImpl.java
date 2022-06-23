package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.AccountDaoImpl;
import com.baizhi.qfl.entity.Account;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class BankServiceImpl {
    //开户
    public void openAccount(Account acc){
        Connection conn=null;
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            AccountDaoImpl dao=new AccountDaoImpl();
            dao.insert(acc);
            //同步数据库
            //dao.update(acc);
            //4. 提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            JDBCUtil.close(null,null,conn);
        }
    }

    //转账
    public void transform(Integer fromID,Integer toId,double money){
        Connection conn=null;
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            AccountDaoImpl dao=new AccountDaoImpl();
            //根据id查询转出账户
            Account fromAccount=dao.selectById(fromID);
            //获取转出账号余额
            double oldBalance=fromAccount.getBalance();
            //转出账户 余额-money
            double newBalance=oldBalance-money;
            fromAccount.setBalance(newBalance);
            //同步数据库
            dao.update(fromAccount);
            //根据id查询转出账户
            Account toAccount= dao.selectById(toId);
            //转入账户 余额+money
            toAccount.setBalance(toAccount.getBalance()+money);
            //同步数据库
            dao.update(toAccount);
            //4. 提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            JDBCUtil.close(null,null,conn);
        }
    }
    //查询余额
    public double queryBalance(Integer userId){
        Connection conn=null;
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            AccountDaoImpl dao=new AccountDaoImpl();
            //根据id查询转出账户
            Account fromAccount=dao.selectById(userId);
            //获取转出账号余额
            double currentBalance=fromAccount.getBalance();
            //4. 提交事务
            conn.commit();
            return currentBalance;
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            JDBCUtil.close(null,null,conn);
        }

    }
    //销户destroyAccount   删除该账户
    public void destroyAccount(Integer userId){
        Connection conn=null;
        try {
            //1.JDBCUtil 获取连接
            conn=JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            AccountDaoImpl dao=new AccountDaoImpl();
            //根据id查询账户
            Account fromAccount=dao.selectById(userId);
            //删除id
            if (fromAccount == null) {
                System.out.println("此用户不存在");
            }else {
                dao.deleteById(userId);
                System.out.println("删除成功");
            }
            //提交
            conn.commit();
        }catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            JDBCUtil.close(null,null,conn);
        }
    }
    //贷款
    //修改密码
    //存钱
    public void save(Integer userId,double money){
        Connection conn=null;
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            AccountDaoImpl dao=new AccountDaoImpl();
            //根据id查询账户
            Account fromAccount=dao.selectById(userId);
            //获取账号余额
            double oldBalance=fromAccount.getBalance();
            // 存款=余额+money
            double newBalance=oldBalance+money;
            fromAccount.setBalance(newBalance);
            //同步数据库
            dao.update(fromAccount);
            //4. 提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            JDBCUtil.close(null,null,conn);
        }
    }
    //取钱
    public void take(Integer userId,double money){
        Connection conn=null;
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            AccountDaoImpl dao=new AccountDaoImpl();
            //根据id查询取钱账户
            Account fromAccount=dao.selectById(userId);
            //获取该账号余额
            double oldBalance=fromAccount.getBalance();
            // 取钱：余额-money
            double newBalance=oldBalance-money;
            if(newBalance>0){
                fromAccount.setBalance(newBalance);
            }else {
                System.out.println("余额不足");
            }
            //同步数据库
            dao.update(fromAccount);
            //4. 提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException();
            }
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            JDBCUtil.close(null,null,conn);
        }
    }
}
