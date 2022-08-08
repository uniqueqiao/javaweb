package com.baizhi.qfl.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.service.TagServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

public class TagAction extends ActionSupport {
    private Tag tag;
    private List<Tag> tags;
    private Integer id;
    public String showAllStuTag() {
        try {
            ///2调用Service层/业务层
            TagServiceImpl ts = new TagServiceImpl();
            tags = ts.queryAllStuTag();
            System.out.println(tags);
            //通过输出流输出list的json串形式
            String str = JSON.toJSONString(tags);
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
    public String showAllClazzTag() {
        try {
            ///2调用Service层/业务层
            TagServiceImpl ts = new TagServiceImpl();
            tags = ts.queryAllClazzTag();
            System.out.println(tags);
            //通过输出流输出list的json串形式
            String str = JSON.toJSONString(tags);
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
            ///2调用Service层/业务层
            TagServiceImpl ts = new TagServiceImpl();
            tags = ts.getAll();
            //利用session设置命名属性(不可重复)
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("list", tags);
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
            ///2调用Service层/业务层
            TagServiceImpl ts = new TagServiceImpl();
            ts.delete(id);
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
            TagServiceImpl ts = new TagServiceImpl();
            ts.insert(tag);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            ServletActionContext.getRequest().getSession().setAttribute("mess", e.getMessage());
            return "error";
        }
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
