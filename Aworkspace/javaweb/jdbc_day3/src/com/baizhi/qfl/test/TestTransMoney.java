package com.baizhi.qfl.test;
import com.baizhi.qfl.service.BankServiceImpl;

import java.sql.SQLException;

public class TestTransMoney {
    public static void main(String[] args) throws SQLException {
        BankServiceImpl bs=new BankServiceImpl();
        bs.transform(1,2,3);
    }
}
