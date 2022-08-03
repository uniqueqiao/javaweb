package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestCityDao {
    @Test
    public void insert(){
        CityDao dao = (CityDao) DBUtil.getDao(CityDao.class);
        dao.insert(new City(null,"太原"));
        DBUtil.commit();
    }
    @Test
    public void queryAll(){
        CityDao dao = (CityDao) DBUtil.getDao(CityDao.class);
        List<City> list=dao.selectAll();
        for (City city : list) {
            System.out.println(city);
        }
        DBUtil.commit();
    }
    @Test
    public void delete(){
        CityDao dao = (CityDao) DBUtil.getDao(CityDao.class);
        dao.delete(25);
        DBUtil.commit();
    }
    @Test
    public void queryByName(){
        CityDao dao = (CityDao) DBUtil.getDao(CityDao.class);
        City city=dao.selectByName("太原");
        System.out.println(city);

        DBUtil.commit();
    }
}
