package com.java.hw;

import java.util.ArrayList;
import java.util.Objects;

public class W1 {
    public static void main(String[] args) {
        //（2）创建多个 对象，存储在List集合中
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("张三",29,10000.0));
        list.add(new Employee("李四",25,20000.0));
        list.add(new Employee("王五",21,30000.0));
        list.add(new Employee("赵六",20,40550.0));
        //（3）打印输出平均工资
        Double sum=0.0;
        for (Employee e : list) {
            sum+= e.getSalary();
        }
        double aver=sum/list.size();
        System.out.println("平均工资："+aver);
        /*（4）打印输出年龄 在 21~30之间的员工信息*/
        for (Employee e : list) {
            if(e.getAge()>21&&e.getAge()<30)
                System.out.println(e);
        }
    }

}
/*1.定义一个 Employee 类，属性姓名、年龄、工资，（1）类封装*/
class Employee{
    private String name;
    private Integer age;
    private Double salary;

    public Employee() {
    }

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getAge(), employee.getAge()) && Objects.equals(getSalary(), employee.getSalary());
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