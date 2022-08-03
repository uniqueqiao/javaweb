package com.baizhi.qfl.dao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;

import java.util.List;

public interface ClazzDao {
    //插入
    public  void insert(Clazz clazz);
    //删除
    public void delete(Integer id);
    //查所有
    public List<Clazz> selectAll();
    //查一个 byname
    public Clazz selectByName(String name);
    //查一个 byid
    public Clazz selectById(Integer id);
    //异步查所有
    public List<Clazz> queryAll();
}
