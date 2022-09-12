package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest extends BasicTest{
    @Autowired
    private UserDao userDao;
    @Test
    void queryAll() {
    }

    @Test
    void insert() {
    }

    @Test
    void queryByName() {
    }

    @Test
    void queryById() {
    }

    @Test
    void deleteById() {
        userDao.deleteById(121);
    }

    @Test
    void updateById() {
        User u=userDao.queryById(1);
        System.out.println(u);
        u.setName("aaanew");
        userDao.updateById(u);
        System.out.println(userDao.queryById(1));
    }
}