package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Group;

import java.util.List;

public interface GroupService {
    // 1. 查所有
    public List<Group> getAll();
    // 1. 异步查所有组+班
    public List<Group> getAllGroupAndCLazz();
    // 2.删除
    public void delete(Integer id);
    // 3. 添加
    public void insert(Group group);
}
