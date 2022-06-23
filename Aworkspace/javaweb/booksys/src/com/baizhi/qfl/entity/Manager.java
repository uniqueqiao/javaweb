package com.baizhi.qfl.entity;

import java.io.Serializable;

public class Manager implements Serializable {
    private String userName;
    private String password;

    public Manager() {
    }

    public Manager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
