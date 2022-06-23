package com.baizhi.qfl.test;


import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;

import java.util.List;

public class TestSelectAll {
    public static void main(String[] args) {
        BookDaoImpl bd=new BookDaoImpl();
        List<Book> list=bd.queryAll();
        for (Book book : list) {
            System.out.println(book);
        }

    }
}
