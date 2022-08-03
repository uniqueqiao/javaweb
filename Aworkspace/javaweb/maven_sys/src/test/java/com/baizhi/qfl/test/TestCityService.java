package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.service.CityService;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestCityService {
    @Test
    public void insert(){
        CityService cs =new CityServiceImpl();
        cs.insert(new City(null,"太原"));
    }
    @Test
    public void queryAll(){
        CityService cs =new CityServiceImpl();
        List<City> list= cs.getAll();
        for (City city : list) {
            System.out.println(city);
        }
    }
    @Test
    public void delete(){
        CityService cs =new CityServiceImpl();
        cs.delete(24);

    }
}
