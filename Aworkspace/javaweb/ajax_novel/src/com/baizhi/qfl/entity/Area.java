package com.baizhi.qfl.entity;

import java.io.Serializable;

public class Area implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private City city;

    public Area() {
    }

    public Area(Integer id, String code, String name, City city) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
