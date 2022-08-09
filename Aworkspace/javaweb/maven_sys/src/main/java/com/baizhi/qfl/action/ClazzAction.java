package com.baizhi.qfl.action;


import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.service.ClazzService;
import com.baizhi.qfl.service.ClazzServiceImpl;
import com.baizhi.qfl.service.GroupService;
import com.baizhi.qfl.service.GroupServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class ClazzAction extends ActionSupport {
    private File upload;
    private String uploadFileName;
    private Clazz c;
    //添加班级获取。xml保存的路径directory
    private String directory;
    private List<Clazz> list;
    private Integer id;
    public String add() {
        ClazzService cs =new ClazzServiceImpl();
        try {
            //1.处理上传图片,保存本地，本地路径F:\Aworkspace\javaweb\maven_sys\src\main\webapp\logo
            //getRealPath 动态获取当前应用的绝对路径
            String path=ServletActionContext.getServletContext().getRealPath(directory);
            File dest=new File(path,uploadFileName);
            FileUtils.copyFile(upload, dest);
            //2.调用业务层方法入库
            //接收参数是，clazz没有path，就是uploadFileName
            c.setPath("/"+uploadFileName);
            cs.insert(c);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            ServletActionContext.getRequest().getSession().setAttribute("mess", e.getMessage());
            return "error";
        }
    }
    public String showAllClazz(){
        ClazzService cs =new ClazzServiceImpl();
        try{
            List<Clazz> clazzs=cs.getAllClazz();
            System.out.println(clazzs);
            //通过输出流输出list的json串形式
            String str = JSON.toJSONString(clazzs);
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
            ClazzService cs =new ClazzServiceImpl();
            list= cs.getAll();
            //利用session设置命名属性(不可重复)
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("list", list);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误");
            return "error";
        }
    }
    public String delete() {
        ClazzService cs =new ClazzServiceImpl();
        try {
            //1.删除图片
            Clazz cl=cs.selectById(id);
            String path=ServletActionContext.getServletContext().getRealPath(directory);
            File dest=new File(path,cl.getPath());
            dest.delete();
            ///2调用Service层/业务层 实现登录
            cs.delete(id);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            session.setAttribute("mess", "操作错误，"+e.getMessage());
            return "error";
        }
    }


    public Clazz getC() {
        return c;
    }

    public void setC(Clazz c) {
        this.c = c;
    }

    public List<Clazz> getList() {
        return list;
    }

    public void setList(List<Clazz> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
