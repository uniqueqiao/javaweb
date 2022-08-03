package com.baizhi.qfl.dao;
import com.baizhi.qfl.entity.Clazz;

import java.util.List;

public interface ClazzDao {
    //插入
    public  void insert(Clazz clazz);
    //删除
    public void delete(Integer id);
    //查所有
    public List<Clazz> selectAll();
}
