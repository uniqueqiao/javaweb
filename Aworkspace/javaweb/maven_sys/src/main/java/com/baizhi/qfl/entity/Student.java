package com.baizhi.qfl.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {
    private Integer id;//主属性
    private String name;//业务属性
    private Integer age;
    private String qq;
    private String phone;
    private Date bir;
    private String starts;
    private String attr;
    private String mark;
    private Clazz clazz;//关系属性
    private Group group;
    private City city;
    private List<Tag> tags=new ArrayList<>();

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String qq, String phone, Date bir, String starts, String attr, String mark, Clazz clazz, Group group, City city, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.qq = qq;
        this.phone = phone;
        this.bir = bir;
        this.starts = starts;
        this.attr = attr;
        this.mark = mark;
        this.clazz = clazz;
        this.group = group;
        this.city = city;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", bir=" + bir +
                ", starts='" + starts + '\'' +
                ", attr='" + attr + '\'' +
                ", mark='" + mark + '\'' +
                ", clazz=" + clazz +
                ", group=" + group +
                ", city=" + city +
                ", tags=" + tags +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public String getBirthday() {
        //Date转为String yyyy-MM-dd
        //String与java.util.Date 转换 使用工具类 SimpleDateFormat---sdf
        //Date --> String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s=sdf.format(bir);
        return s;
        //String --> Date Date d=sdf.parse(String)
    }
}
