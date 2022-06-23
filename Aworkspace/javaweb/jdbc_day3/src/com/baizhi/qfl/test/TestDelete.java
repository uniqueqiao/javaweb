package com.baizhi.qfl.test;


import com.baizhi.qfl.dao.AccountDaoImpl;

import java.util.Scanner;

public class TestDelete {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入要删除的id：");
        int myid= sc.nextInt();
        AccountDaoImpl ad=new AccountDaoImpl();
        ad.deleteById(myid);
        System.out.println("删除成功");

    }

}
