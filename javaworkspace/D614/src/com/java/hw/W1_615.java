package com.java.hw;

import java.util.ArrayList;
import java.util.Objects;

public class W1_615 {
    public static void main(String[] args) {
        //创建多个Account对象，存储在List集合中，遍历输出 余额大于1000的用户信息.
        ArrayList<Account> list = new ArrayList<>();
        list.add(new Account("001","张三",2000.0));
        list.add(new Account("002","李四",500.0));
        list.add(new Account("003","王五",10000.0));
        list.add(new Account("004","赵六",999.0));
        //遍历
        for (Account a:list) {
            System.out.println(a);
        }
        //余额>1000
        for (Account a:list) {
            if (a.getBalance()>1000) {
                System.out.println(a);
            }
        }
    }
}

//1.定义一个Account 类，属性卡号(id)、用户名(username)、余额(balance)，类封装,
class Account{
    private String id;
    private String username;
    private Double balance;

    public Account() {
    }

    public Account(String id, String username, Double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) && Objects.equals(getUsername(), account.getUsername()) && Objects.equals(getBalance(), account.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getBalance());
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}