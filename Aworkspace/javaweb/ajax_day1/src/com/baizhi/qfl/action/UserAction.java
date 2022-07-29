package com.baizhi.qfl.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class UserAction extends ActionSupport {
    private String username;
    //提供action功能完成username校验----异步
    public String checkUsername2() throws Exception{
        Thread.sleep(3000);
        // 调用业务层方法校验username
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.println( "username="+username);
        if( "baizhi".equals(username) ){
            // 向client输出结果 --- 需要使用server到client的输出流
            out.println("img/error.jpg");
        }else{
            out.println("img/ok.gif");
        }
        //2. 返回字符串控制跳转 --- 如果有返回值，配置文件中势必做跳转（同步请求跳转方式）
        return null;
    }
    /*public String checkUsername2() throws Exception{
        //调用业务层校验username
        PrintWriter out=ServletActionContext.getResponse().getWriter();
        System.out.println(username);
        if("baizhi".equals(username)==true) {
            //向client 输出结果 ---需要使用server 到client 的输出流
            out.println("is used");
        }else {
            out.println("ok");
        }
        //返回字符串控制跳转  ----如果有返回值 配置文件中势必做跳转---所以 return null
        return null;
    }*/
    //提供action功能完成username校验----同步
    public String checkUsername() throws Exception{
        //业务层完成功能
        HttpSession session= ServletActionContext.getRequest().getSession();
        if("baizhi".equals(username)==true){
            session.setAttribute("mess","用户名被占用");
        }else {
            session.setAttribute("mess","用户名可用");
        }
        //跳转
        return "ok";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
