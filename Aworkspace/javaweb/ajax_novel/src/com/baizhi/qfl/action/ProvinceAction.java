package com.baizhi.qfl.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.Province;
import com.baizhi.qfl.service.ProvinceServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.List;

public class ProvinceAction extends ActionSupport {
    //查看所有省份----异步请求
    public String showAllProvince() throws Exception {
        ProvinceServiceImpl ps=new ProvinceServiceImpl();
        try{
            List<Province> list =ps.getAll();
            //通过输出流输出list的json串形式
            String str = JSON.toJSONString(list);
            ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
            PrintWriter out = ServletActionContext.getResponse().getWriter();
            out.println(str);
            return null;
        }catch (Exception e) {
            e.printStackTrace();//上线需要删掉
            //底层运行出错返回的结果（跳转）
            return null;
        }
    }
}
