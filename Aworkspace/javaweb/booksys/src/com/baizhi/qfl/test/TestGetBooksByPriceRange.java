package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.service.LibraryServiceImpl;

import java.util.List;

public class TestGetBooksByPriceRange {
    public static void main(String[] args) {
        LibraryServiceImpl lib=new LibraryServiceImpl();
        List<Book> books=lib.getBooksByPriceRange(50, 100);
        for(Book book : books) {
            System.out.println(book);
        }
    }

}
