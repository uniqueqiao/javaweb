package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.User;

import java.util.List;

public interface UserDao {
    //1：增加
     void insert(User user);
    //2.查所有
    List<User> queryAll();
}
