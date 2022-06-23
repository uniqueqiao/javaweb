package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Book;
import java.util.List;

public interface BookDao {
    //(1) 往 books表中插入一条数据(使用序列维护主键)
    public void insert(Book book);

    //(2) 根据 book_id 删除对应的书籍
    public void deleteById(int id) ;
    //(3) 根据 book_id 修改对应的书籍信息
    public void updateById(Book book);
    //(4) 根据 book_id 查询对应书籍信息
    public Book selectById(int id);
    //(5) 查询所有的书籍信息
    public List<Book> queryAll();
    //------------------以下选做------------------
    //(6) 根据书名模糊查询相关书籍
    public List<Book> queryLike(String text);
    //(7) 查询书籍大于 50的信息
    public List<Book> queryByPrice(double prices);
    //(8) 根据图书类别查询相关书籍信息，例如：'计算机'
    public List<Book> queryByCategory(String cate);
}
