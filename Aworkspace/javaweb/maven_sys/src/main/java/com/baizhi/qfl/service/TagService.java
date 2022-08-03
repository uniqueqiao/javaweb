package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Tag;

import java.util.List;

public interface TagService {
    //异步查所有班级tag
    public List<Tag> queryAllClazzTag();
    // 1. 查所有
    public List<Tag> getAll();
    // 2.删除
    public void delete(Integer id);
    // 3. 添加
    public void insert(Tag tag);
}
