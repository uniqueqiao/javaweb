package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.ClazzDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestClazzDao {
    @Test
    public void queryAll(){
        ClazzDao dao = (ClazzDao) DBUtil.getDao(ClazzDao.class);
        List<Clazz> list=dao.selectAll();
        for (Clazz c : list) {
            System.out.println(c);
        }
        DBUtil.commit();
    }
    @Test
    public void queryByName(){
        ClazzDao dao = (ClazzDao) DBUtil.getDao(ClazzDao.class);
        Clazz c=dao.selectByName("2010班");
        System.out.println(c);
        DBUtil.commit();
    }
    @Test
    public void insert(){
        ClazzDao dao = (ClazzDao) DBUtil.getDao(ClazzDao.class);
        dao.insert(new Clazz(null,"2208","/a.jpg",new Tag(5,"探知源码",null,null)));
        List<Clazz> list=dao.selectAll();
        for (Clazz c : list) {
            System.out.println(c);
        }
        DBUtil.commit();
    }
    @Test
    public void delete(){
        ClazzDao dao = (ClazzDao) DBUtil.getDao(ClazzDao.class);
        dao.delete(14);
        List<Clazz> list=dao.selectAll();
        for (Clazz c : list) {
            System.out.println(c);
        }
        DBUtil.commit();
    }
}
