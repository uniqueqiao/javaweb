package com.java.hwtwo;
import com.java.map.Student;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class MapWork3 {
    public static void main(String[] args) {
        //(1)利用HashMap存储用户信息：id作为键，用户作为值，创建多个用户对象进行存储
        BankUser bu1=new BankUser("001","bu1",210000.0);
        BankUser bu2=new BankUser("002","bu2",300000.0);
        BankUser bu3=new BankUser("003","bu3",500000.0);
        BankUser bu4=new BankUser("004","bu4",100000.0);
        HashMap<String,BankUser> map=new HashMap<>();
        //id作为键，用户作为值
        map.put(bu1.getId(), bu1);
        map.put(bu2.getId(), bu2);
        map.put(bu3.getId(), bu3);
        map.put(bu4.getId(), bu4);
        //(2)遍历打印输出所有银行的用户名和对应的余额
        //获取所有键
        Set<String> keys = map.keySet();
        //遍历Set获取键
        System.out.println("-----遍历打印输出所有银行的用户名和对应的余额----");
        for (String key : keys) {
            //key获取value
            BankUser value=map.get(key);
            System.out.println(value.getUserName()+"-"+value.getBalance());
        }
        // (3)打印输出余额大于200000的用户信息
        System.out.println("-----打印输出余额大于200000的用户信息----");
        for (String key : keys) {
            //key获取value
            BankUser value=map.get(key);
            if(value.getBalance()>200000)
            System.out.println(value);
        }
    }
}

//3.(Map)编程：定义一个银行用户BankUser类，
// 用户信息为用户id、用户名userName、余额balance;
class BankUser{
    private String id;
    private String userName;
    private Double balance;

    public BankUser() {
    }

    public BankUser(String id, String userName, Double balance) {
        this.id = id;
        this.userName = userName;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankUser bankUser = (BankUser) o;
        return Objects.equals(id, bankUser.id) && Objects.equals(userName, bankUser.userName) && Objects.equals(balance, bankUser.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, balance);
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}