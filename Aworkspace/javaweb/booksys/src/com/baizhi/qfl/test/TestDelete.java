package com.baizhi.qfl.test;
import com.baizhi.qfl.dao.BookDaoImpl;
import com.baizhi.qfl.entity.Book;

import java.util.*;
public class TestDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的图书id：");
        int id=sc.nextInt();
        BookDaoImpl bd=new BookDaoImpl();
        Book book=bd.selectById(id);
        if(book != null)bd.deleteById(id);
        else System.out.println("查无此书");

    }
}
