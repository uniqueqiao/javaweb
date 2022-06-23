package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.AccountDaoImpl;
import com.baizhi.qfl.entity.Account;
import java.util.Scanner;

public class TestUpdateId {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要修改的id：");
        int myid= sc.nextInt();
        AccountDaoImpl ad=new AccountDaoImpl();
        Account acc=ad.selectById(myid);
        if (acc!=null) {
            System.out.println("输入修改的用户名：");
            String name= sc.next();
            System.out.println("输入修改的密码：");
            String psw= sc.next();
            System.out.println("输入修改的余额：");
            double balance=sc.nextDouble();
            acc.setAccName(name);
            acc.setPassword(psw);
            acc.setBalance(balance);
            ad.update(acc);//同步到数据库
            System.out.println("修改成功");
            System.out.println(acc);
        }else {
            System.out.println("查无此人");
        }
    }
}
