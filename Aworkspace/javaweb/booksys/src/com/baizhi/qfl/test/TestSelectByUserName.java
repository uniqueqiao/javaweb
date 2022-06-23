package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.ManagerDaoImpl;
import com.baizhi.qfl.entity.Manager;

public class TestSelectByUserName {
    public static void main(String[] args) {
        ManagerDaoImpl md=new ManagerDaoImpl();
        Manager m=md.selectByUserName("u1");
        System.out.println(m.getUserName()+","+m.getPassword());
    }

}
