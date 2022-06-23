package com.java.hw;

import java.util.ArrayList;
import java.util.List;

public class W2 {
    public static void main(String[] args) {
        /*2.定义Animal类，在定义多个子类Dog、Cat
        创建多个子类对象，存储在List集合中，统计Dog的个数*/
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
        //统计Dog的个数
        int count =0;
        System.out.println("-------统计集合中Dog数量------");
        for (Animal s:list) {
            if (s instanceof Dog)
                count++;
        }
        System.out.println("狗有"+count+"只");
    }
}
class Animal{
}
class Dog extends Animal{

}
class Cat extends Animal{
}