package com.java.object;

import java.sql.SQLOutput;
import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    public Student(String name,int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    /*public String toString() {
        return "name="+name+" age="+age+" score="+score;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Student student = (Student)obj;
        if( this.score==student.score&&this.age==student.age&&this.name.equals(student.name)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void finalize()  {
        System.out.println("垃圾回收");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
