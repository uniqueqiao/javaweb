package com.baizhi.qfl.test;

import com.baizhi.qfl.service.ManagerServiceImpl;

public class TestLogin {
    public static void main(String[] args) {
        ManagerServiceImpl ms=new ManagerServiceImpl();
        ms.login("u1", "123456");
        ms.login("u2", "123456");
        ms.login("u1", "111111");
    }
}
