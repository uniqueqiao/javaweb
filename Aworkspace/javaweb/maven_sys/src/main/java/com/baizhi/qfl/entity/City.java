package com.baizhi.qfl.entity;

import java.io.Serializable;

public class City implements Serializable {
    private Integer id;//主属性
    private String name;//业务属性

    public City() {
    }

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
