package com.baizhi.qfl.entity;

import java.io.Serializable;
import java.util.Date;

public class Group implements Serializable {
    private Integer id;//主属性
    private String name;//业务属性
    private Date createDate;
    private Clazz clazz;//关系属性

    public Group() {
    }

    public Group(Integer id, String name, Date createDate, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", clazz=" + clazz +
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
