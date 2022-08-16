package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.User;

import java.util.List;

public interface UserService {
    //1：增加
    public void add(User user);
    //2.查所有
    public List<User> queryAll();
}
