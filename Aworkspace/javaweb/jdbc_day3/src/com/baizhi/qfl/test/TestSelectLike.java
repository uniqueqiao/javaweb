package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.AccountDaoImpl;
import com.baizhi.qfl.entity.Account;

import java.util.List;
import java.util.Scanner;

public class TestSelectLike {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要搜索的关键字：");
        String text= sc.next();
        AccountDaoImpl ad=new AccountDaoImpl();
        List<Account> list=ad.selectLike(text);
        for (Account a:list) {
            System.out.println(a);
        }
    }
}
