package com.java.hwthree;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class MapW1 {
    public static void main(String[] args) {
        //① 利用Map集合存储以下信息：key-id(Integer)，value-工人对象(Worker)
        // 1  - (张三,27,10000)
        // 2  - (李四,23,7500)
        // 3  - (王五五,25,6000)
        HashMap<Integer,Worker> map=new HashMap<>();
        map.put(1, new Worker("张三",27,10000));
        map.put(2,new Worker("李四",23,7500));
        map.put(3, new Worker("王五五",25,6000));
        //② 遍历输出集合中所有的信息：id-工人信息
        System.out.println("------遍历输出集合中所有的信息：id-工人信息------");
        //获取所有键
        Set<Integer> keys = map.keySet();
        //遍历Set获取键
        for (Integer key : keys) {
            //key获取value
            Worker value=map.get(key);
            System.out.println(key+"-"+value);
        }
        //③ 输入一个id，查询是否存在，存在则输出该工人的信息，否则打印输出"查无此人!"
        /*System.out.println("------输入一个id，查询是否存在------");
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个id：");
        Integer id=sc.nextInt();
        if(map.containsKey(id)){
            //key获取value
            Worker value=map.get(id);
            System.out.println("存在此人："+id+"-"+value);
        }else {
            System.out.println("查无此人!");
        }*/
        //④ 统计工人的平均工资。
        System.out.println("------统计工人的平均工资。------");
        //遍历Set获取键
        Double sum=0.0;
        for (Integer key : keys) {
            //key获取value
            Worker value=map.get(key);
            sum+= value.getSalary();
        }
        System.out.println("平均工资："+sum/ map.size());
        //⑤ 输出id为偶数的员工信息。
        System.out.println("------输出id为偶数的员工信息。------");
        //遍历Set获取键
        for (Integer key : keys) {
            //key是偶数获取value
            if (key%2==0) {
                Worker value=map.get(key);
                System.out.println(key+"-"+value);
            }
        }
        //⑥ 输出工人工资大于7000的id号。
        System.out.println("------输出工人工资大于7000的id号。------");
        //遍历Set获取键
        for (Integer key : keys) {
            //key获取value
            Worker value=map.get(key);
            if (value.getSalary()>7000) {
                System.out.println(key+"-"+value);
            }
        }
        //⑦ 打印输出名字长度大于2的员工信息
        System.out.println("------打印输出名字长度大于2的员工信息------");
        //遍历Set获取键
        for (Integer key : keys) {
            //key获取value
            Worker value=map.get(key);
            if (value.getName().length()>2) {
                System.out.println(key+"-"+value);
            }
        }
    }
}
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