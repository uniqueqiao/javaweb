package com.baizhi.qfl.test;

import com.baizhi.qfl.service.BankServiceImpl;

public class TestDestroyAccount {
    public static void main(String[] args) {
        BankServiceImpl bs=new BankServiceImpl();
        bs.destroyAccount(13);
    }
}
