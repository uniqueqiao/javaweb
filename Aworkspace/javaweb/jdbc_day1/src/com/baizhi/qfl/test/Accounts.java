package com.baizhi.qfl.test;

import java.util.Objects;

public class Accounts {
    private Integer accId;
    private String accName;
    private Double balance;

    public Accounts() {
    }

    public Accounts(Integer accId, String accName, Double balance) {
        this.accId = accId;
        this.accName = accName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accId=" + accId +
                ", accName='" + accName + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(getAccId(), accounts.getAccId()) && Objects.equals(getAccName(), accounts.getAccName()) && Objects.equals(getBalance(), accounts.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccId(), getAccName(), getBalance());
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
