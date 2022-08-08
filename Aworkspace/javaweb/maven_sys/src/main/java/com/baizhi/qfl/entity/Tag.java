package com.baizhi.qfl.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tag implements Serializable {
    private Integer id;//主属性
    private String name;//业务属性
    private String type;
    private Date createDate;

    public Tag() {
    }

    public Tag(Integer id, String name, String type, Date createDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }
    /*public String getCreateTime() {
        //Date转为String yyyy-MM-dd
        //String与java.util.Date 转换 使用工具类 SimpleDateFormat---sdf
        //Date --> String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s=sdf.format(createDate);
        return s;
        //String --> Date Date d=sdf.parse(String)
    }*/
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
