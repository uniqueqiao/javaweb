package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.service.LibraryServiceImpl;

import java.util.List;

public class TestQueryAllBooks {
    public static void main(String[] args) {
        LibraryServiceImpl lib=new LibraryServiceImpl();
        List<Book> books=lib.queryAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }


}
