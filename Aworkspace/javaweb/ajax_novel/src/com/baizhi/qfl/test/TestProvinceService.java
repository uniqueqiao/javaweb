package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.ProvinceDao;
import com.baizhi.qfl.entity.Province;
import com.baizhi.qfl.service.ProvinceServiceImpl;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.List;

public class TestProvinceService {
    @Test
    public void testQueryAll(){
        ProvinceServiceImpl ps =new ProvinceServiceImpl();
        List<Province> list = ps.getAll();
        for (Province province : list) {
            System.out.println(province);
        }
    }
}
