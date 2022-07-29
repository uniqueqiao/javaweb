package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.ProvinceDao;
import com.baizhi.qfl.entity.Province;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestProvinceDao {
    @Test
    public void testQueryAll(){
        ProvinceDao dao =(ProvinceDao) DBUtil.getDao(ProvinceDao.class);
        List<Province> list = dao.queryAll();
        for (Province province : list) {
            System.out.println(province);
        }
        DBUtil.close();
    }
}
