package com.baizhi.qfl.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.service.CityService;
import com.baizhi.qfl.service.CityServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.List;

public class CityAction extends ActionSupport {
    //收参pcode
    private String pcode;
    //根据省份pcode 差对应城市
    public String showCityByProvinceCode() throws Exception {
        //业务层
        CityService cs=new CityServiceImpl();
        try {
            List<City> list = cs.getCityByProvinceCode(pcode);
            //通过输出流输出list的json串形式
            String str = JSON.toJSONString(list);
            ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
            PrintWriter out = ServletActionContext.getResponse().getWriter();
            out.println(str);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
}
