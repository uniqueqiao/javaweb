package com.baizhi.qfl.test;
import com.baizhi.qfl.dao.AccountDaoImpl;
import com.baizhi.qfl.entity.Account;

import java.util.Scanner;

public class TestSelectOne {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要查询的id：");
        int myid= sc.nextInt();
        AccountDaoImpl ad=new AccountDaoImpl();
        Account acc=ad.selectById(myid);
        if (acc!=null) {
            System.out.println(acc);
        }else {
            System.out.println("查无此人");
        }
    }
}
