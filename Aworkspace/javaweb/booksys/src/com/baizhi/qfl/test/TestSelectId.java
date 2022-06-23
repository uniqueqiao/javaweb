package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;

import java.util.Scanner;

public class TestSelectId {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的图书id：");
        int id=sc.nextInt();
        BookDaoImpl bd=new BookDaoImpl();
        Book book=bd.selectById(id);
        if (book == null) {
            System.out.println("没有这本书");
        }else System.out.println(book);
    }
}
