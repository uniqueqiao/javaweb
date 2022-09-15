package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.vo.CommonVO;

import java.util.List;

public interface UserService {
    //查一个
    User queryByName(String username);
    //查所有
    List<User> queryAll();
    //登录
    String login(User user);
    //注册
    String regist(User user);
    //ajax注册验证
    CommonVO registCheck(String username);
    //删除
    String deleteById(Integer id);
}
