package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Group;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupDao {
    //查所有
    public List<Group> selectAll();
    //插入
    public  void insert(Group group);
    //删除
    public void delete(Integer id);
    //根据班级和姓名查
    public Group selectByNameAndCName(@Param("name") String name,@Param("cname")String cname);
}
