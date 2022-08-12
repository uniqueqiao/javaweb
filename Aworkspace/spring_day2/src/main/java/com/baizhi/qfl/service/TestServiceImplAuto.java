package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.UserDao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TestServiceImplAuto {
    private String name;
    private UserDao ud;

    public void setName(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println(name);
        System.out.println(ud);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
