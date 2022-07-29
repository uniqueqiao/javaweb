package com.baizhi.qfl.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.Area;
import com.baizhi.qfl.service.AreaService;
import com.baizhi.qfl.service.AreaServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.List;

public class AreaAction extends ActionSupport {
    //收参pcode
    private String ccode;
    //根据省份pcode 差对应城市
    public String showAreaByCityCode() throws Exception {
        //业务层
        AreaService as =new AreaServiceImpl();
        try {
            List<Area> list = as.getAreaByCityCode(ccode);
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

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

}
