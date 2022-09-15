package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.User;

import java.util.List;

public interface UserDao {
    //查一个
    User queryByName(String username);
    User queryById(Integer id);
    //查所有
    List<User> queryAll();
    //添加
    void add(User user);
    //删除
    void deleteById(Integer id);
}
