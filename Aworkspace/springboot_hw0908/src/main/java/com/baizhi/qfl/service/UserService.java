package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.vo.CommonVO;

import java.util.List;

public interface UserService {
    //1：增加
    void add(User user);
    //2.ajax查所有
    List<User> queryAll();
    //查一个
    User queryByName(String username);
    CommonVO  queryById(Integer id);
    //1：commonVO增加   表单校验最好零散收参
    CommonVO add1(User user);
    //2.commonVO ajax查所有
    CommonVO queryAll1();
    //3.commonVO 删除
    CommonVO deleteById(Integer id);
    //4.commonVO 更新
    CommonVO updateById(User user);
}
