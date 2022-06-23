package com.baizhi.qfl.test;
import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;

import java.util.List;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入书名：");
        String name= sc.next();
        System.out.println("输入价格：");
        double price= sc.nextDouble();
        System.out.println("输入类型：");
        String category= sc.next();
        System.out.println("输入细节描述：");
        String detail= sc.next();
        BookDaoImpl bd=new BookDaoImpl();
        Book book=new Book(null,name,price,category,detail);
        bd.insert(book);
        System.out.println("插入成功");
        List<Book> list=bd.queryAll();
        for (Book b:list) {
            System.out.println(b);
        }
    }
}
