package com.baizhi.qfl.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String username;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")private Date bir;

    public User() {
    }

    public User(String username, Integer age, Date bir) {
        this.username = username;
        this.age = age;
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
