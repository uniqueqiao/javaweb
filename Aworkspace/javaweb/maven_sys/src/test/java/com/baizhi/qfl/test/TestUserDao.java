package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestUserDao {
    @Test
    public void insert(){
        UserDao dao = (UserDao) DBUtil.getDao(UserDao.class);
        dao.insert(new User(null,"aaa","111",new Date(),"student","abcdef"));
        DBUtil.commit();
    }
    @Test
    public void queryByName(){
        UserDao dao = (UserDao) DBUtil.getDao(UserDao.class);
        User u=dao.selectByUserName("xiao");
        System.out.println(u);
        DBUtil.commit();
    }
}
