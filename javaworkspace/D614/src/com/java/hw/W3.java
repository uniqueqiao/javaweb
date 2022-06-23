package com.java.hw;

public class W3 {
    public static void main(String[] args) {
        int n=10,m=2;
        // 实现类一：方法实现逻辑：返回1~n之间偶数的和
        MyInter mi=(int a)->{
            int sum=0;
            for (int i =1; i <= a;i++ ) {
                if(i%2==0) sum+=i;
            }
            return sum;
        };
        int n1=mi.accept(n);
        System.out.println(n1);
// 实现类二：方法实现逻辑：如果n是大于3并且为奇数则，返回n，否则返回0
        MyInter mi2=(int a)->{
            if(a>3)return a;
            return 0;
        };
        int n2=mi2.accept(n);
        int n3=mi2.accept(m);
        System.out.println(n2);
        System.out.println(n3);
    }
}
//3.写出以下接口的实现类：
interface MyInter{
    int accept(int n);
}
// 实现类一：方法实现逻辑：返回1~n之间偶数的和
// 实现类二：方法实现逻辑：如果n是大于3并且为奇数则，返回n，否则返回0