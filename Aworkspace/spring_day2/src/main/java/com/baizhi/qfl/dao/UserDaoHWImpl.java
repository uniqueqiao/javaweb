package com.baizhi.qfl.dao;

public class UserDaoHWImpl implements UserDaoHW{
    @Override
    public void print(String name) {
        System.out.println("姓名：" + name);
    }
}
