package com.java.flect;
interface IA{}
interface IB{}
public class Student implements IA ,IB {
    private String name;
    private Integer age;
    private Double score;
    private void method1(){}
    private void method2(){}
    public Student() {
        System.out.println("无参构造");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("带参构造");
    }

    public Student(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
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
