package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.ProvinceDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Province;
import com.baizhi.qfl.util.DBUtil;

import java.util.List;

public class CityServiceImpl implements CityService{
    @Override
    public List<City> getCityByProvinceCode(String pcode) {
        try {
            CityDao dao=(CityDao) DBUtil.getDao(CityDao.class);
           List<City> list = dao.queryCityByProvinceCode(pcode);
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            DBUtil.close();
        }
    }
}
