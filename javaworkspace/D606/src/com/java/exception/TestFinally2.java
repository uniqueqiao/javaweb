package com.java.exception;

public class TestFinally2 {
    public static void main(String[] args) {
        int r=test(3,1);
        System.out.println("r="+r);
        System.out.println("----------");
        int r1=test(2,0);
        System.out.println("r1="+r1);
    }

    public static int  test(int n,int m) {
        try {
            System.out.println("try");
            return n/m;
        }catch (Exception e) {
            System.out.println("分母不能为零！");
            return -1;
        }finally {
            System.out.println("finally");
            //return -9;会导致最终返回值恒为-9
        }
    }
}
