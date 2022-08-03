package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.User;

public interface UserDao {
    //根据姓名查信息
    public User selectByUserName(String name);
    //添加用户
    public void insert(User user);
}
