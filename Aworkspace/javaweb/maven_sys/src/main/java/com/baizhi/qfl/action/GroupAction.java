package com.baizhi.qfl.action;


import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.service.GroupService;
import com.baizhi.qfl.service.GroupServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

public class GroupAction extends ActionSupport {
    private Group g;
    private List<Group> groups;
    private Integer id;
   public String showAll() {
        try {
            ///2调用Service层/业务层 实现登录
            GroupService gs =new GroupServiceImpl();
            groups= gs.getAll();
            //利用session设置命名属性(不可重复)
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("list", groups);
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
            GroupService gs =new GroupServiceImpl();
            gs.delete(id);
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
            GroupService gs =new GroupServiceImpl();
            gs.insert(g);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            ServletActionContext.getRequest().getSession().setAttribute("mess", e.getMessage());
            return "error";
        }
    }

    public Group getG() {
        return g;
    }

    public void setG(Group g) {
        this.g = g;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
