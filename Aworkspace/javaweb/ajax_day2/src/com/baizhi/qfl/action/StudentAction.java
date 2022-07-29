package com.baizhi.qfl.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentAction extends ActionSupport {
    public String showAll() throws Exception {
        Student s=new Student(1,"张三",18,new Date());
        Student s1=new Student(2,"李四",18,new Date());
        Student s2=new Student(3,"王五",18,new Date());
        List<Student> list=new ArrayList<Student>();
        //list->String
        list.add(s);
        list.add(s1);
        list.add(s2);
        String jsOBJ = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");//月的MM必须大写
        //使用输出流 输出异步请求的结果数据
        //防止中文乱码
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        out.println(jsOBJ);
        return null;
    }
    public String showOne() throws Exception {
        Student s=new Student(1,"zs",18,new Date());
        String jsOBJ = JSON.toJSONStringWithDateFormat(s,"yyyy-MM-dd");//月的MM必须大写
        //使用输出流 输出异步请求的结果数据
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        out.println(jsOBJ);
        return null;
    }
}
