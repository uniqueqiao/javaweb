package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.Book;
import com.baizhi.qfl.service.LibraryServiceImpl;

import java.util.Scanner;

public class TestAddBook {
    public static void main(String[] args) {
        LibraryServiceImpl ls=new LibraryServiceImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入书名");
        String name=sc.next();
        System.out.println("请输入价格");
        double price =sc.nextDouble();
        System.out.println("请输入类型");
        String category=sc.next();
        System.out.println("请输入细节内容");
        String detail=sc.next();
        Book book = new Book(null,name,price,category,detail);
        ls.addBook(book);
        System.out.println("添加成功");

    }
}
