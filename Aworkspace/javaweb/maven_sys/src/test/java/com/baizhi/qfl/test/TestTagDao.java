package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.TagDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestTagDao {
    @Test
    public void insert(){
        TagDao dao = (TagDao) DBUtil.getDao(TagDao.class);
        dao.insert(new Tag(null,"111","学生",new Date()));
        DBUtil.commit();
    }
    @Test
    public void queryAll(){
        TagDao dao = (TagDao) DBUtil.getDao(TagDao.class);
        List<Tag> list=dao.selectAll();
        for (Tag t : list) {
            System.out.println(t);
        }
        DBUtil.commit();
    }
    @Test
    public void queryAllClazz(){
        TagDao dao = (TagDao) DBUtil.getDao(TagDao.class);
        List<Tag> list=dao.queryAllClazzTag();
        for (Tag t : list) {
            System.out.println(t);
        }
        DBUtil.commit();
    }
    @Test
    public void delete(){
        TagDao dao = (TagDao) DBUtil.getDao(TagDao.class);
        dao.delete(20);
        DBUtil.commit();
    }
}
