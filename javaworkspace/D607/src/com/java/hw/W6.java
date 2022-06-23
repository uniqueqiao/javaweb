package com.java.hw;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class W6 {
    public static void main(String[] args) {
        //创建多个Worker对象，
       /*存储在Map集合中，键-工号，值-Worker对象，遍历打印输出所有的相关信息。*/
        HashMap<Integer,Worker> map=new HashMap<>();
        map.put(1, new Worker("张三",27,10000));
        map.put(2,new Worker("李四",23,7500));
        map.put(3, new Worker("王五五",25,6000));
        //② 遍历输出集合中所有的信息：
        System.out.println("------遍历输出集合中所有的信息：------");
        //获取所有键
        Set<Integer> keys = map.keySet();
        //遍历Set获取键
        for (Integer key : keys) {
            //key获取value
            Worker value=map.get(key);
            System.out.println(key+"-"+value);
        }
    }
}
/*6.定义一个Worker类，属性(姓名、年龄、工资)，类封装；*/
class Worker{
    private String name;
    private int age;
    private double salary;
    //补全构造方法、get/set方法、toString方法
    public Worker() {
    }

    public Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return getAge() == worker.getAge() && Double.compare(worker.getSalary(), getSalary()) == 0 && Objects.equals(getName(), worker.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSalary());
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}