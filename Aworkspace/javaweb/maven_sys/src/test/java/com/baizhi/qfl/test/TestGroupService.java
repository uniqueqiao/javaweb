package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.GroupDao;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.service.ClazzService;
import com.baizhi.qfl.service.ClazzServiceImpl;
import com.baizhi.qfl.service.GroupService;
import com.baizhi.qfl.service.GroupServiceImpl;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestGroupService {
    @Test
    public void insert(){
        GroupService cs =new GroupServiceImpl();
        GroupDao dao = (GroupDao) DBUtil.getDao(GroupDao.class);
        Group group = new Group(null,"222",new Date(),new Clazz(13,"2013班",null,null));
        cs.insert(group);
        /*Group g=dao.selectByNameAndCName(group.getName(), group.getClazz().getName());
        System.out.println(group.getName());
        System.out.println(group.getClazz().getName());
        System.out.println(g);*/
    }
    @Test
    public void queryAll(){
        GroupService cs =new GroupServiceImpl();
        List<Group> list= cs.getAll();
        for (Group c : list) {
            System.out.println(c);
        }
    }
    @Test
    public void delete(){
        GroupService cs =new GroupServiceImpl();
        cs.delete(12);

    }
}
