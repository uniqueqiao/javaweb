package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.User;

import java.util.List;

public interface UserDao {
    //查所有
    List<User> queryAll();
    //添加
    void insert(User user);
    //查一个
    User queryByName(String username);
    User queryById(Integer id);
    //删除
    void deleteById(Integer id);
    //更新
    void updateById(User user);
}
