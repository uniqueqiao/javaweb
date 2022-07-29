package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestCityService {
    @Test
    public void testGetCity(){
        CityServiceImpl cs=new CityServiceImpl();
        List<City> list= cs.getCityByProvinceCode("140000");
        for (City city : list) {
            System.out.println(city);
        }
        DBUtil.close();
    }
}
