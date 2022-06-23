package com.baizhi.qfl.test;

import com.baizhi.qfl.service.BankServiceImpl;

public class TestSave {
    public static void main(String[] args) {
        BankServiceImpl bs=new BankServiceImpl();
        bs.save(1, 20);
        double cm=bs.queryBalance(1);
        System.out.println("当前余额："+cm);
    }
}
