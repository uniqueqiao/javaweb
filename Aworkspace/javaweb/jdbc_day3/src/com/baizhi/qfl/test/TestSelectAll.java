package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.AccountDaoImpl;
import com.baizhi.qfl.entity.Account;

import java.util.List;
import java.util.Scanner;

public class TestSelectAll {
    public static void main(String[] args) {
        AccountDaoImpl ad=new AccountDaoImpl();
        List<Account> list=ad.selectAll();
        for (Account a:list) {
            System.out.println(a);
        }
    }
}
