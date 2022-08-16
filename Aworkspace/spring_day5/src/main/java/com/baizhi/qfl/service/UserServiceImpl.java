package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
  /*  public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
*/
    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAll() {
        List<User> list=userDao.queryAll();
       return list;
    }
}
