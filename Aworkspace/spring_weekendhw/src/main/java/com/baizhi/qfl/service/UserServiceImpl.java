package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.User;
import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    @Override
    public List<User> queryAll() {
        List<User> list=userDao.queryAll();
       return list;
    }
}
