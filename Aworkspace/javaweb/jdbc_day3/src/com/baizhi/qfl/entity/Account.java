package com.baizhi.qfl.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer accId;
    private String accName;
    private String password;
    private Double balance;

    public Account() {
    }

    public Account(Integer accId, String accName, String password, Double balance) {
        this.accId = accId;
        this.accName = accName;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", accName='" + accName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
