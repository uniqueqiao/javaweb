package com.java.object;

import java.util.Objects;

public class Work1 {
    public static void main(String[] args) {
        User u1=new User("u1","U111","13623659855");
        User u2=new User("u1","U111","13623659855");
        User u3=new User("u3","U333","13815698754");
        System.out.println(u1.equals(u2));
        System.out.println(u1.equals(u3));
    }
}
/*1.(Object类)编程：定义一个用户类(User类)，属性有用户名、用户密码password、电话(tel)，
要求如下：
(1)对类进行封装，提供get/set方法；同时提供无参数、有参数的构造方法
(2)覆盖toString方法，要求格式为：
username：一如既往，password：123456，tel：13051800688
(3)覆盖 equals方法
(4)写一个测试类，利用键盘分别输入两个用户信息并存储Use对象中，判断两个对象是否相同。*/
class User {
    private String name;
    private String password;
    private String tel;

    @Override
    public String toString() {
        return "name:" + name + ", password:" + password+ ", tel:" + tel ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(tel, user.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, tel);
    }

    public User() {
    }

    public User(String name, String password, String tel) {
        this.name = name;
        this.password = password;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}