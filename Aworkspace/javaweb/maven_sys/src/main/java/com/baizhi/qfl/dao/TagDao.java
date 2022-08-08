package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {
    //异步查所有班级tag
    public List<Tag> queryAllClazzTag();
   //异步查所有学生tag
    public List<Tag> queryAllStuTag();
    //插入
    public  void insert(Tag tag);
    //删除
    public void delete(Integer id);
    //查所有
    public List<Tag> selectAll();
    //查一个
    public Tag selectByNameAndType(@Param("name") String name,@Param("type")String type);
}
