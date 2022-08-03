package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.City;

import java.util.List;

public interface CityDao {
    //插入
    public  void insert(City city);
    //删除
    public void delete(Integer id);
    //查所有
    public List<City> selectAll();
    //查一个 byname
    public City selectByName(String name);
}
