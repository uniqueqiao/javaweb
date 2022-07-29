package com.baizhi.qfl.service;


import com.baizhi.qfl.entity.Area;

import java.util.List;

public interface AreaService {
    public List<Area> getAreaByCityCode(String ccode);
}
