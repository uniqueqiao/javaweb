package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.User;

import java.util.List;

public interface UserService {

    // 1. 注册
    public void regist(User user);
    //2. 登录
    public User Login(User user);
    //3.根据名字查找
    public User queryByName(String name);
}
