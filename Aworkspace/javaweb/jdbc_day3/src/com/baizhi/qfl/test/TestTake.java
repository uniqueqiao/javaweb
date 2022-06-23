package com.baizhi.qfl.test;

import com.baizhi.qfl.service.BankServiceImpl;

public class TestTake {
    public static void main(String[] args) {
        BankServiceImpl bs=new BankServiceImpl();
        bs.take(1, 33);
        System.out.println("当前余额："+bs.queryBalance(1));
    }
}
