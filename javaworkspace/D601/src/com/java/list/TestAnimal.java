package com.java.list;

import java.util.ArrayList;
import java.util.List;

public class TestAnimal {
    public static void main(String[] args) {
        //集合创建多个子类对象
        List<Animal> list =new ArrayList<>();
        //添加元素
        list.add(new Dog());
        list.add(new Dog());
        list.add(new Dog());
        list.add(new Cat());
        list.add(new Dog());
        list.add(new Cat());
        list.add(new Cat());
        //遍历所有对象的eat()
        System.out.println("-------遍历所有对象的eat()------");
        for (Animal s:list) {
             s.eat();
        }
        //统计集合中Cat数量
        int count =0;
        System.out.println("-------统计集合中Cat数量------");
        for (Animal s:list) {
            if (s instanceof Cat)
            count++;
        }
        System.out.println("猫有"+count+"只");
        //调用集合中Dog 的shout 方法
        System.out.println("------调用集合中Dog 的shout 方法------");
        for (Animal s:list) {
            if (s instanceof Dog){
                Dog d=(Dog) s;
                d.shout();
            }
        }
    }
}
class Animal{
    public void eat(){
        System.out.println("Animal eat（）");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("Dog eat（）");
    }
    public void shout(){
        System.out.println("wangwangwang...");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("Cat eat（）");
    }
}