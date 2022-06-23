package com.baizhi.qfl.test;
import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;

import java.util.List;
import java.util.Scanner;

public class TestSelectByPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个价格：");
        Double price = sc.nextDouble();
        BookDaoImpl bd = new BookDaoImpl();
        List<Book> list = bd.queryByPrice(price);
        for (Book b : list) {
            System.out.println(b);
        }
    }
}
