package com.baizhi.qfl.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User1 implements Serializable {
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")private Date bir;

    public User1() {
    }

    public User1(String username, Date bir) {
        this.username = username;
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", bir=" + bir +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
