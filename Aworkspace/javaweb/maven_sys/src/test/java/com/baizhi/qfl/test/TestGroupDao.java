package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.ClazzDao;
import com.baizhi.qfl.dao.GroupDao;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestGroupDao {
    @Test
    public void queryAll(){
        GroupDao dao = (GroupDao) DBUtil.getDao(GroupDao.class);
        List<Group> list=dao.selectAll();
        for (Group c : list) {
            System.out.println(c);
        }
        DBUtil.commit();
    }
    @Test
    public void queryByNameAndCname(){
        GroupDao dao = (GroupDao) DBUtil.getDao(GroupDao.class);
        Group g= dao.selectByNameAndCName("1组", "2011班");
        System.out.println(g);
        DBUtil.commit();
    }
    @Test
    public void insert(){
        GroupDao dao = (GroupDao) DBUtil.getDao(GroupDao.class);
        Group g=new Group(null,"222",new Date(),new Clazz(13,"2013班",null,null));
        dao.insert(g);
        DBUtil.commit();
    }
    @Test
    public void delete(){
        GroupDao dao = (GroupDao) DBUtil.getDao(GroupDao.class);
        dao.delete(11);
        DBUtil.commit();
    }
}
