package com.java.hw;
import java.util.*;
public class Work1 {
    public static void main(String[] args) {
        // (2) 创建多个Worker类，存储在List集合中。
        List<Worker> w=new ArrayList<>();
        w.add(new Worker("胡一", 30, 5000.0));
        w.add(new Worker("胡二", 30, 7000.0));
        w.add(new Worker("胡三", 30, 9000.0));
        w.add(new Worker("胡四", 30, 10000.0));
        w.add(new Worker("胡五", 30, 2000.0));
        w.add(new Worker("胡刘", 30, 3000.0));
        w.add(new Worker("张三", 30, 5000.0));
        w.add(new Worker("李四", 30, 8000.0));
        w.add(new Worker("王五", 30, 5000.0));
        w.add(new Worker("赵千", 30, 1000.0));
        w.add(new Worker("刘白胡", 30, 500.0));
        //(3) 打印输出所有的工人信息。
        System.out.println("----- 打印输出所有的工人信息----");
        for (Worker worker:w) {
            System.out.println(worker);
        }
        //(4) 计算所有工人的平均工资。
        System.out.println("----- 计算所有工人的平均工资----");
        int sum=0;
        for (Worker worker:w) {
            sum+=worker.getSalary();
        }
        System.out.println("平均工资"+sum/ w.size());
        //(5) 打印输出姓名中包含 "胡" 的所有工人信息。
        System.out.println("-----打印输出姓名中包含 '胡' 的所有工人信息----");
        for (Worker worker:w) {
            if(worker.getName().contains("胡"))
            System.out.println(worker);
        }
        //(6) 键盘输入一个姓名，查找是否存在此员工，存在，则打印输出员工的信息，
        System.out.println("-----键盘输入一个姓名，查找是否存在此员工，存在，则打印输出----");
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int flag=0;
        for (Worker worker:w) {
            if(worker.getName().equals(str)){
                System.out.println(worker);
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("查无此人");
        }
        //(7) 输入一个工资，查询工资 大于 输入工资的员工信息。
        System.out.println("----输入一个工资，查询工资 大于 输入工资的员工信息----");
        int  n=sc.nextInt();
        for (Worker worker:w) {
            if(worker.getSalary()>n)
                System.out.println(worker);
        }
    }
}
/*1.编程：创建一个工人类，属性：姓名、年龄、工资，要求如下：
	(1) 为Worker提供无、有参数的构造方法，属性私有，并提供公开的get/set*/
class Worker{
    private String name;
    private Integer age;
    private Double salary;

    public Worker() {
    }

    public Worker(String name, Integer age, Double salary) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}