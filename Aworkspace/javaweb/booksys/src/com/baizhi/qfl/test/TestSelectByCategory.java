package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;

import java.util.List;
import java.util.Scanner;

public class TestSelectByCategory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个类型关键字：");
        String cate=sc.next();
        BookDaoImpl bd = new BookDaoImpl();
        List<Book> list = bd.queryByCategory(cate);
        for (Book b : list) {
            System.out.println(b);
        }
    }
}
