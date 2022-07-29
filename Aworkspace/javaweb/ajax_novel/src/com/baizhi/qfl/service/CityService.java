package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.City;

import java.util.List;

public interface CityService {
    public List<City> getCityByProvinceCode(String pcode);
}
