package com.baizhi.qfl.action;


import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.entity.Student;
import com.baizhi.qfl.service.GroupService;
import com.baizhi.qfl.service.GroupServiceImpl;
import com.baizhi.qfl.service.StudentService;
import com.baizhi.qfl.service.StudentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

public class StudentAction extends ActionSupport {
    private Student stu;
    private List<Student> students;
    private Integer id;
    private List<Integer> tids;
    private String colName;
    private String colValue;
    //修改
    public String update(){
        try {
            ///2调用Service层/业务层
            StudentService ss =new StudentServiceImpl();
            ss.updateStudentById(stu,tids);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return "error";
        }
    }
    //异步根据id获取
    public String queryById(){
        try {
            ///2调用Service层/业务层
            StudentService ss =new StudentServiceImpl();
            stu=ss.getStudentById(id);
            System.out.println(stu);
            ServletActionContext.getRequest().getSession().setAttribute("Astudent", stu);
            //通过输出流输出list的json串形式
            String str = JSON.toJSONStringWithDateFormat(stu,"yyyy-MM-dd");
            System.out.println(str);
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
    public String queryLike(){
        try {
            /*String num= ServletActionContext.getRequest().getParameter("pn");
            if (num == null) {
                num="1";
            }
            int pn=Integer.parseInt(num);*/
            ///2调用Service层/业务层
            StudentService ss =new StudentServiceImpl();
            students=ss.getStudentLike(colName, colValue);
            //int totalPage=ss.getTotalPage();
            //利用session设置命名属性(不可重复)
            HttpSession session= ServletActionContext.getRequest().getSession(true);
            session.setAttribute("list",students);
            /*session.setAttribute("totalPage", totalPage);
            session.setAttribute("pn", pn);*/
            return "ok";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    public String add(){
        try {
            ///2调用Service层/业务层
            StudentService ss =new StudentServiceImpl();
            ss.insert(stu,tids);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return "error";
        }
    }
   public String showAll() {
       try {
           String num= ServletActionContext.getRequest().getParameter("pn");
           if (num == null) {
               num="1";
           }
           int pn=Integer.parseInt(num);
           ///2调用Service层/业务层
           StudentService ss =new StudentServiceImpl();
           students=ss.getStudent(pn);
           int totalPage=ss.getTotalPage();
           //利用session设置命名属性(不可重复)
           HttpSession session= ServletActionContext.getRequest().getSession(true);
           session.setAttribute("list",students);
           session.setAttribute("totalPage", totalPage);
           session.setAttribute("pn", pn);
           return "ok";
       }catch (Exception e) {
           e.printStackTrace();
           return "error";
       }
    }
    public String delete() {
        try {
            ///2调用Service层/业务层
            StudentService ss =new StudentServiceImpl();
            ss.deleteById(id);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return "error";
        }
    }
    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getTids() {
        return tids;
    }

    public void setTids(List<Integer> tids) {
        this.tids = tids;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColValue() {
        return colValue;
    }

    public void setColValue(String colValue) {
        this.colValue = colValue;
    }
}
