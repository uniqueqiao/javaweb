package com.baizhi.qfl.action;

import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{
    private User u;
    private List<User> list;
    @Autowired
    private UserService userService;

    public String showAll(){
        try {
            ///2调用Service层/业务层
            list = userService.queryAll();
            //利用session设置命名属性(不可重复)
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("list", list);
            return ActionSupport.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return ActionSupport.ERROR;
        }
    }
    public String add() {
        try {
            ///2调用Service层/业务层
            userService.add(u);
            return ActionSupport.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return ActionSupport.ERROR;
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
