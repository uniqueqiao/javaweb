package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Manager;

public interface ManagerDao {
    public Manager selectByUserName(String name);
}
