package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService{
    @Override
    public void addBook(Book book) {
        Connection conn=null;
        try {
            //JDBCUtil
            conn=JDBCUtil.getConnection();
            //设置手动
            conn.setAutoCommit(false);
            //利用dao完成
            BookDaoImpl bd=new BookDaoImpl();
            bd.insert(book);
            //提交
            conn.commit();
        }catch (Exception e) {
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

    }

    @Override
    public void removeBook(Integer bookId) {
        Connection conn=null;
        try {
            //JDBCUtil
            conn=JDBCUtil.getConnection();
            //设置手动
            conn.setAutoCommit(false);
            //利用dao完成
            BookDaoImpl bd=new BookDaoImpl();
            Book b= bd.selectById(bookId);
            if(b == null){
                System.out.println("不存在此书");
            }else {
                System.out.println(b);
                bd.deleteById(bookId);
            }
            //提交
            conn.commit();
        }catch (Exception e) {
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

    }

    @Override
    public void updateBook(Book book) {
        Connection conn=null;
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            BookDaoImpl bd=new BookDaoImpl();
            //根据id查询书
            Book b= bd.selectById(book.getBookId());
            if(b == null){
                System.out.println("不存在此书");
            }else {
                System.out.println(b);
            }
            //同步数据库
            bd.updateById(book);
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

    @Override
    public List<Book> queryAllBooks() {
        Connection conn=null;
        List<Book> list = new ArrayList<Book>();
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            BookDaoImpl bd=new BookDaoImpl();
            for (Book book:bd.queryAll() ){
                list.add(book);
            }
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
        return list;
    }

    @Override
    public List<Book> getBooksByPriceRange(double minPrice, double maxPrice) {
        Connection conn=null;
        List<Book> list = new ArrayList<Book>();
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            BookDaoImpl bd=new BookDaoImpl();
            for (Book book:bd.queryByPriceBA(minPrice,maxPrice) ){
                list.add(book);
            }
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
        return list;
    }

    @Override
    public List<Book> getBooksByCategory(String category) {
        Connection conn=null;
        List<Book> list = new ArrayList<Book>();
        try {
            //1. JDBCUtil 获取连接
            conn= JDBCUtil.getConnection();
            //2.设置事务手动提交
            conn.setAutoCommit(false);
            //3. 利用dao完成业务
            BookDaoImpl bd=new BookDaoImpl();
            for (Book book:bd.queryByCategory(category) ){
                list.add(book);
            }
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
        return list;
    }
}
