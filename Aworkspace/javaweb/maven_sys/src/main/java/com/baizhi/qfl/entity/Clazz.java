package com.baizhi.qfl.entity;

import java.io.Serializable;

public class Clazz implements Serializable {
    private Integer id;//主属性
    private String name;//业务属性
    private String path;
    private Tag tag;//关系属性

    public Clazz() {
    }

    public Clazz(Integer id, String name, String path, Tag tag) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tag=" + tag +
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
