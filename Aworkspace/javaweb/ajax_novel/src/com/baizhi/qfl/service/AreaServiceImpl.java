package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.AreaDao;
import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.entity.Area;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.util.DBUtil;

import java.util.List;

public class AreaServiceImpl implements AreaService{
    @Override
    public List<Area> getAreaByCityCode(String ccode) {
        try {
            AreaDao dao=(AreaDao) DBUtil.getDao(AreaDao.class);
            List<Area> list = dao.queryAreaByCtiyCode(ccode);
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            DBUtil.close();
        }
    }
}
