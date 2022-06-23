package com.java.object;

public class TestGetClass {
    public static void main(String[] args) {
        Animal animal=new Animal();
        Animal dog=new Dog();
        Animal cat=new Cat();
        Animal cat1=new Cat();
        System.out.println(dog.getClass()==animal.getClass());
        System.out.println(dog instanceof Animal);
        /*System.out.println(dog.getClass());
        System.out.println(cat.getClass());
        System.out.println(dog.getClass()==cat.getClass());
        System.out.println(cat.getClass()==cat1.getClass());*/

    }
}
class Animal{
}
class Dog extends Animal{
}
class Cat extends Animal{
}