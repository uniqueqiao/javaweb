package com.baizhi.qfl.action;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.service.CityServiceImpl;
import com.baizhi.qfl.service.UserServiceImpl;
import com.baizhi.qfl.util.CreateValidateCode;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.util.List;

public class UserAction extends ActionSupport {
    private String ucode;
    private User u;
    public String createImage()throws Exception{
        CreateValidateCode vc = new CreateValidateCode(100, 30, 5, 10);
        //1. 生成随机数，并存储到session作用域
        String code = vc.getCode();
        System.out.println(code);
        ServletActionContext.getRequest().getSession().setAttribute("code",code );
        //2. 获取server到client的字节输出流 ， 向client输出画好的图片
        OutputStream os = ServletActionContext.getResponse().getOutputStream();
        vc.write(os);
        return null;
    }
    //登录action
    public String login() throws Exception {
        try {
            //验证验证码
            // 1. 验证验证码
            String code = (String) ServletActionContext.getRequest().getSession().getAttribute("code");
            System.out.println(ucode+"------------");
            if( code.equals( ucode ) == false ) {
                System.out.println(  "error"       );
                return "error";
            }else{
                //2调用Service层/业务层 实现登录
                UserServiceImpl us=new UserServiceImpl();
                User user=us.Login(u);
                HttpSession session=ServletActionContext.getRequest().getSession(true);
                session.setAttribute("us",user);
                return "ok";

            }
        }catch (Exception e) {
            e.printStackTrace();
            ServletActionContext.getRequest().getSession().setAttribute("mess", e.getMessage());
            return "error";
        }

    }
    public String logout(){
        //清除当前用户信息
        HttpSession session= ServletActionContext.getRequest().getSession(true);
        //session.removeAttribute("user");// 只是将session中命名属性清掉
        session.invalidate();//销毁session
        //重定向到登录界面
        return "ok";
    }
    public String regist(){
        String code = (String) ServletActionContext.getRequest().getSession().getAttribute("code");
        System.out.println(ucode+"------------");
        if( code.equals( ucode ) == false ) {
            System.out.println(  "error" );
            return "error";
        }else {
            UserServiceImpl us=new UserServiceImpl();
           /* User user= us.SByName(u.getUsername());
            if(us == null){
                us.regist(user);
                return "ok";
            }else {
                ServletActionContext.getRequest().getSession().setAttribute("mess", "用户已存在");
                return "error";
            }*/

        }
    }
}
