package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.ProvinceDao;
import com.baizhi.qfl.entity.Province;
import com.baizhi.qfl.util.DBUtil;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService{
    @Override
    public List<Province> getAll() {
        try {
            ProvinceDao dao=(ProvinceDao) DBUtil.getDao(ProvinceDao.class);
            List<Province> list = dao.queryAll();
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            DBUtil.close();
        }
    }
}
