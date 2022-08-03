package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;

import java.util.List;

public interface ClazzService {
    // 1. 查所有
    public List<Clazz> getAll();
    // 2.删除
    public void delete(Integer id);
    // 3. 添加
    public void insert(Clazz clazz);
    //4.异步查所有
    public List<Clazz> getAllClazz();
    //5.根据name查
    public Clazz selectByName(String name);
    //5.根据id查
    public Clazz selectById(Integer id);
}
