package com.baizhi.qfl.test;

import com.baizhi.qfl.service.LibraryServiceImpl;

import java.util.Scanner;

public class TestRemoveBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryServiceImpl lib=new LibraryServiceImpl();
        System.out.println("请输入要删除的图书id");
        int id=sc.nextInt();
        lib.removeBook(id);
        System.out.printf("删除成功");
    }
}
