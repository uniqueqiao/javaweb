package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestCityDao {
    @Test
    public void testGetCity(){
        CityDao dao = (CityDao) DBUtil.getDao(CityDao.class);
        List<City> list=dao.queryCityByProvinceCode("140000");
        for (City city : list) {
            System.out.println(city);
        }
        DBUtil.close();
    }
}
