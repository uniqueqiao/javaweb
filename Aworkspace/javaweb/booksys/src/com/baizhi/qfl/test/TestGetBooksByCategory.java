package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.service.LibraryServiceImpl;

import java.util.List;

public class TestGetBooksByCategory {
    public static void main(String[] args) {
        LibraryServiceImpl lib=new LibraryServiceImpl();
        List<Book> list= lib.getBooksByCategory("计算机");
        for (Book book : list) {
            System.out.println(book);
        }
    }
}
