package com.java.flect;

public class TestSingle {
    public static void main(String[] args) {
        //饿汉式
        ClassA ca1=ClassA.getClassA();//ClassA ca1=new ClassA();
        ClassA ca2=ClassA.getClassA();
        System.out.println(ca1==ca2);//True
        //懒汉式
        ClassB cb1=ClassB.getClassB();
        ClassB cb2=ClassB.getClassB();
        System.out.println(cb1==cb2);//True
    }
}
//单例模式---饿汉式
class ClassA{
    private static final ClassA ca=new ClassA();
    private ClassA(){ }//构造方法私有化
    public static ClassA getClassA() {
        return ca;
    }
}
//单例模式---懒汉式
class ClassB{
    private static ClassB cb;
    private ClassB(){ }//构造方法私有化
    //同步方法，多线程下单例
    public synchronized static ClassB getClassB() {
        if(cb==null)
        cb= new ClassB();
        return cb;
    }
}