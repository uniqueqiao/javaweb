package com.baizhi.qfl.test;

import com.baizhi.qfl.service.BankServiceImpl;

import java.sql.SQLException;

public class TestQueryMoney {
    public static void main(String[] args) throws SQLException {
        BankServiceImpl bs=new BankServiceImpl();
        double cm=bs.queryBalance(1);
        System.out.println("当前余额："+cm);
    }
}
