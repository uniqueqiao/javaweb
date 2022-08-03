package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.service.CityService;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.service.ClazzService;
import com.baizhi.qfl.service.ClazzServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestClazzService {
    @Test
    public void insert(){
        ClazzService cs =new ClazzServiceImpl();
        cs.insert(new Clazz(null,"2222","/111",new Tag(13,null,null,null)));
    }
    @Test
    public void queryAll(){
        ClazzService cs =new ClazzServiceImpl();
        List<Clazz> list= cs.getAll();
        for (Clazz c : list) {
            System.out.println(c);
        }
    }
    @Test
    public void delete(){
        ClazzService cs =new ClazzServiceImpl();
        cs.delete(16);

    }
}
