package com.baizhi.qfl.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.service.ClazzService;
import com.baizhi.qfl.service.ClazzServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

public class CityAction extends ActionSupport {
    private City city;
    private List<City> cities;
    private Integer id;
    public String showAllCity() {
        try {
            ///2调用Service层/业务层 实现登录
            CityServiceImpl cs = new CityServiceImpl();
            cities = cs.getAllCity();
            String str = JSON.toJSONString(cities);
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
    public String showAll() {
        try {
            ///2调用Service层/业务层 实现登录
            CityServiceImpl cs = new CityServiceImpl();
            cities = cs.getAll();
            //利用session设置命名属性(不可重复)
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("list", cities);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return "error";
        }
    }
    public String delete() {
        try {
            ///2调用Service层/业务层 实现登录
            CityServiceImpl cs = new CityServiceImpl();
            cs.delete(id);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return "error";
        }
    }
    public String add() {
        try {
            ///2调用Service层/业务层
            CityServiceImpl cs = new CityServiceImpl();
            cs.insert(city);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            ServletActionContext.getRequest().getSession().setAttribute("mess", e.getMessage());
            return "error";
        }
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
