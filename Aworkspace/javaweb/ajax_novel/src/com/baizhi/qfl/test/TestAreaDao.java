package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.AreaDao;
import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.entity.Area;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestAreaDao {
    @Test
    public void testGetCity(){
        AreaDao dao = (AreaDao) DBUtil.getDao(AreaDao.class);
        List<Area> list=dao.queryAreaByCtiyCode("140100");
        for (Area a : list) {
            System.out.println(a);
        }
        DBUtil.close();
    }
}
