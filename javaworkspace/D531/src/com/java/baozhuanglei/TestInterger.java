package com.java.baozhuanglei;
public class TestInterger {
    public static void main(String[] args) {
        int a=18,b=20;
        Integer i=new Integer(a);//Int->Integer
        Integer i1=Integer.valueOf(b);
        System.out.println(i);
        System.out.println(i.toString());
        System.out.println(i instanceof Integer) ;
        System.out.println(i1);
        //Interger->int
        int ii=i1.intValue();
        System.out.println(ii);
        //String ->int
        String str="235";
        int value=Integer.parseInt(str);
        System.out.println(value);
        //自动装箱和拆箱
        Integer in=55;
        int n=in;
        System.out.println(in);
        System.out.println(n);
    }
}
