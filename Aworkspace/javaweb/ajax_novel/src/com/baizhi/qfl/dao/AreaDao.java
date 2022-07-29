package com.baizhi.qfl.dao;


import com.baizhi.qfl.entity.Area;

import java.util.List;

public interface AreaDao {
    public List<Area> queryAreaByCtiyCode(String ccode);
}
