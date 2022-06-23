package com.baizhi.qfl.test;
import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;

import java.util.List;
import java.util.Scanner;

public class TestSelectLike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要搜索的关键字：");
        String text =sc.next();
        BookDaoImpl bd=new BookDaoImpl();
        List<Book> list=bd.queryLike(text);
        for (Book b:list){
            System.out.println(b);
        }

    }
}
