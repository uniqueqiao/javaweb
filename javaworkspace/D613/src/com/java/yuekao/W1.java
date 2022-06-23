package com.java.yuekao;

public class W1 {
    public static void main(String[] args) {
        int[] a={3,5,9,1,9,2};
        int max=a[0];
        int min=a[0];
        for (int i = 0; i < a.length;i++) {
            if (a[i] >max )max=a[i];
            if (a[i] <min )min=a[i];
        } //System.out.println("max:"+max+",min"+min);
        int sum=0;
        for (int i = 0; i < a.length;i++) {
            sum+=a[i];
        }
        //去max，min
        int result=sum-max-min;
        int length=a.length-2;
        double aver=(double) result/length;
        System.out.println("平均值："+aver);
    }
}
