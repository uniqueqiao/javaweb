package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.City;

import java.util.List;

public interface CityService {
    // 1. 查所有
    public List<City> getAll();

    // 2.删除
    public void delete(Integer id);
    // 3. 添加
    public void insert(City city);
}
