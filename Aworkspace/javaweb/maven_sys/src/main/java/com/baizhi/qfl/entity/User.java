package com.baizhi.qfl.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;//主属性
    private String username;//业务属性
    private String password;
    private Date createDate=new Date();
    private String role;
    private String salt;

    public User(Integer id, String username, String password, Date createDate, String role, String salt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.role = role;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", role='" + role + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public User() {
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date creatDate) {
        this.createDate = createDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
