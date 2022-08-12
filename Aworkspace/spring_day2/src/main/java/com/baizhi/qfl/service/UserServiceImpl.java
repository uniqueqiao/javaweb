package com.baizhi.qfl.service;


import com.baizhi.qfl.dao.UserDaoHW;

public class UserServiceImpl implements UserService{
    private String name;
    private UserDaoHW udh;
    @Override
    public void print() {
        udh.print(name);
    }

    public void setUdh(UserDaoHW udh) {
        this.udh = udh;
    }

    public void setName(String name) {
        this.name = name;
    }
}
