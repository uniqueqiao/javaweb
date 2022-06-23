package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.service.LibraryServiceImpl;

public class TestUpdateBook {
    public static void main(String[] args) {
        LibraryServiceImpl lib=new LibraryServiceImpl();
        Book book=new Book(11,"jsp",123.0,"计算机","20220622");
        lib.updateBook(book);
        System.out.println("修改成功");
    }
}
