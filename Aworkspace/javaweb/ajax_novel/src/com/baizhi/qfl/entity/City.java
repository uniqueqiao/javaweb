package com.baizhi.qfl.entity;

import java.io.Serializable;

public class City implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private Province prov;//关系属性

    public City() {
    }

    public City(Integer id, String code, String name, Province prov) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.prov = prov;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", prov=" + prov +
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

    public Province getProv() {
        return prov;
    }

    public void setProv(Province prov) {
        this.prov = prov;
    }
}
