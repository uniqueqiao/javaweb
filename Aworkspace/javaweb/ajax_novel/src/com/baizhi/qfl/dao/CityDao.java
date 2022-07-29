package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Province;

import java.util.List;

public interface CityDao {
    //根据省编码查city
    public List<City> queryCityByProvinceCode(String pcode);
}
