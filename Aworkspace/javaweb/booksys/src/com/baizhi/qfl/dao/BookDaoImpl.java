package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    //(1) 往 books表中插入一条数据(使用序列维护主键)
    @Override
    public void insert(Book book){
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            //1.2.通过工具类获取连接
            conn=JDBCUtil.getConnection();
            //3.准备sql以及发送工具
            String sql="INSERT INTO books(book_name,price,category,detial)VALUES(?,?,?,?)";
            pstm=conn.prepareStatement(sql);
            //4.绑定参数，发送SQL
            pstm.setString(1, book.getBookName());
            pstm.setDouble(2, book.getPrice());
            pstm.setString(3, book.getCategory());
            pstm.setString(4, book.getDetial());
            int n=pstm.executeUpdate();
            System.out.println("影响行数"+n);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(null,pstm,null);
        }
    }

    //(2) 根据 book_id 删除对应的书籍
    @Override
    public void deleteById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //1.2.通过工具类获取连接
            conn = JDBCUtil.getConnection();
            //3.准备sql以及发送工具
            String sql = "DELETE FROM books WHERE book_id=?";
            pstm = conn.prepareStatement(sql);
            //4.绑定参数，发送SQL
            pstm.setInt(1,id);
            int n=pstm.executeUpdate();
            System.out.println("影响行数"+n);
            //5.
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 6.释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(null,pstm,null);
        }
    }
    //(3) 根据 book_id 修改对应的书籍信息
    @Override
    public void updateById(Book book){
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql = "UPDATE books SET book_name=?,price=?,category=?,detial=? where book_id=?";
            pstm = conn.prepareStatement(sql);
            // 绑定参数，发送SQL
            pstm.setString(1, book.getBookName());
            pstm.setDouble(2, book.getPrice());
            pstm.setString(3, book.getCategory());
            pstm.setString(4, book.getDetial());
            pstm.setInt(5, book.getBookId());
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
    //(4) 根据 book_id 查询对应书籍信息
    @Override
    public Book selectById(int id){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs= null;
        try {
            //1. 2. 通过工具类获取连接
            conn = JDBCUtil.getConnection();
            // 准备SQL以及发送SQL的工具
            String sql="SELECT * FROM books where book_id=?";
            pstm = conn.prepareStatement(sql);
            // 绑定参数，发送SQL
            pstm.setInt(1, id);
            rs=pstm.executeQuery();//select
            // 处理结果集   select才需要
            Book book=null;
            while (rs.next()){//有数据需要处理
                id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                String category= rs.getString(4);
                String detail= rs.getString(5);
                book = new Book(id,name,price,category,detail);
                //System.out.println(accId+","+name+","+password+","+balance);
            }
            return book;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(rs,pstm,null);
        }
    }
    //(5) 查询所有的书籍信息
    @Override
    public List<Book> queryAll(){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs = null;
        try {
            //1.2. 利用工具类创建连接
            conn=JDBCUtil.getConnection();
            //3.准备sql及发送工具
            String sql = "SELECT * FROM books";
            pstm=conn.prepareStatement(sql);
            //绑定参数，发送sql
            rs=pstm.executeQuery();
            List<Book> list = new ArrayList<Book>();
            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                String category= rs.getString(4);
                String detail= rs.getString(5);
                Book book = new Book(id,name,price,category,detail);
                list.add(book);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(rs,pstm,null);
        }

    }
    //------------------以下选做------------------
    //(6) 根据书名模糊查询相关书籍
    @Override
    public List<Book> queryLike(String text){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs = null;
        try {
            //1.2. 利用工具类创建连接
            conn=JDBCUtil.getConnection();
            //3.准备sql及发送工具
            String sql = "SELECT * FROM books where book_name like ?";
            pstm=conn.prepareStatement(sql);
            //绑定参数，发送sql
            pstm.setString(1, "%"+text+"%");
            rs=pstm.executeQuery();
            List<Book> list = new ArrayList<Book>();
            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                String category= rs.getString(4);
                String detail= rs.getString(5);
                Book book = new Book(id,name,price,category,detail);
                list.add(book);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            // 释放资源 先开的后释放 先conn开所以后conn关
            JDBCUtil.close(rs,pstm,null);
        }

    }
    //(7) 查询书籍大于 50的信息
    @Override
    public List<Book> queryByPrice(double prices){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs = null;
        try {
            //1.2. 利用工具类创建连接
            conn=JDBCUtil.getConnection();
            //3.准备sql及发送工具
            String sql = "SELECT * FROM books where price>?";
            pstm=conn.prepareStatement(sql);
            //绑定参数，发送sql
            pstm.setDouble(1, prices);
            rs=pstm.executeQuery();
            List<Book> list = new ArrayList<Book>();
            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                String category= rs.getString(4);
                String detail= rs.getString(5);
                Book book = new Book(id,name,price,category,detail);
                list.add(book);
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
    //(8) 根据图书类别查询相关书籍信息，例如：'计算机'
    @Override
    public List<Book> queryByCategory(String cate){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs = null;
        try {
            //1.2. 利用工具类创建连接
            conn=JDBCUtil.getConnection();
            //3.准备sql及发送工具
            String sql = "SELECT * FROM books where category like ?";
            pstm=conn.prepareStatement(sql);
            //绑定参数，发送sql
            pstm.setString(1, "%"+cate+"%");
            rs=pstm.executeQuery();
            List<Book> list = new ArrayList<Book>();
            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                String category= rs.getString(4);
                String detail= rs.getString(5);
                Book book = new Book(id,name,price,category,detail);
                list.add(book);
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
    public List<Book> queryByPriceBA(double minprice,double maxprice){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs = null;
        try {
            //1.2. 利用工具类创建连接
            conn=JDBCUtil.getConnection();
            //3.准备sql及发送工具
            String sql = "SELECT * FROM books where price between ? and ?";
            pstm=conn.prepareStatement(sql);
            //绑定参数，发送sql
            pstm.setDouble(1, minprice);
            pstm.setDouble(2, maxprice);
            rs=pstm.executeQuery();
            List<Book> list = new ArrayList<Book>();
            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);
                String category= rs.getString(4);
                String detail= rs.getString(5);
                Book book = new Book(id,name,price,category,detail);
                list.add(book);
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