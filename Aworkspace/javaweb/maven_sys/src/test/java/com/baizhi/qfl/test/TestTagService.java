package com.baizhi.qfl.test;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.service.CityService;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.service.TagService;
import com.baizhi.qfl.service.TagServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestTagService {
    @Test
    public void insert(){
        TagService ts =new TagServiceImpl();
        ts.insert(new Tag(null,"太原","学生",new Date()));
    }
    @Test
    public void queryAll(){
        TagService ts =new TagServiceImpl();
        List<Tag> list= ts.getAll();
        for (Tag tag : list) {
            System.out.println(tag);
        }
    }
    @Test
    public void queryAllCTag(){
        TagService ts =new TagServiceImpl();
        List<Tag> list= ts.queryAllClazzTag();
        for (Tag tag : list) {
            System.out.println(tag);
        }
    }
    @Test
    public void delete(){
        TagService ts =new TagServiceImpl();
        ts.delete(21);

    }
}
