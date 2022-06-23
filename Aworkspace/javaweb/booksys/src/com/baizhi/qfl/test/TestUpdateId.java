package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;


import java.util.Scanner;

public class TestUpdateId {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要修改的id：");
        int myid= sc.nextInt();
        BookDaoImpl bd=new BookDaoImpl();
        Book book=bd.selectById(myid);
        if (book!=null) {
            System.out.println("输入修改的书名：");
            String name= sc.next();
            System.out.println("输入修改的价格：");
            double price=sc.nextDouble();
            System.out.println("输入修改的类型：");
            String category= sc.next();
            System.out.println("输入修改的细节内容：");
            String detail= sc.next();
            book.setBookName(name);
            book.setPrice(price);
            book.setCategory(category);
            book.setDetial(detail);
            bd.updateById(book);//同步到数据库
            System.out.println("修改成功");
            System.out.println(book);

        }else {
            System.out.println("查无此人");
        }
    }
}
