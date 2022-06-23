package com.java.list;

public class Student {
    private String name;
    private Integer age;
    private Double score;
    private String tel;
    public Student() {
    }

    public Student(String name, Integer age, Double score, String tel) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.tel = tel;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
