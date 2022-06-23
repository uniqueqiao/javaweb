package com.baizhi.qfl.test;
import com.baizhi.qfl.dao.AccountDaoImpl;
import com.baizhi.qfl.entity.Account;
import com.baizhi.qfl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) {
        // 模拟客户端往accouts insert一条
        Scanner sc=new Scanner(System.in);
        System.out.println("输入用户名：");
        String name= sc.next();
        System.out.println("输入密码：");
        String psw= sc.next();
        System.out.println("输入余额：");
        double balance= sc.nextDouble();
        AccountDaoImpl ad=new AccountDaoImpl();
        Account acc=new Account(null,name,psw,balance);
        ad.insert(acc);
        System.out.println("插入成功");
        List<Account> list=ad.selectAll();
        for (Account a:list) {
            System.out.println(a);
        }
    }
}
