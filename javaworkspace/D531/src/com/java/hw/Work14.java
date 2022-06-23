package com.java.hw;

public class Work14 {
    public static void main(String[] args) {
        String s="1239586838923173478943890234092";
        int [] a = {0,0,0,0,0,0,0,0,0,0};

        for(int i=0;i<s.length();i++){
            a[Integer.parseInt(String.valueOf(s.charAt(i)))]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i+"有"+a[i]+"个");
        }

        /*for(char i='0';i<='9';i++){
            int count=0;
            for(int j=0;j<s.length();j++){
                if(i==s.charAt(j))count++;
            }
            System.out.println("数字"+i+"有"+count+"个");
        }*/
       /* int[] a=new int[s.length()];
        for(int i=0;i<s.length();i++){
            a[i]=Integer.parseInt(s.substring(i,i+1));
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int i=0;i<=9;i++){
            int count=0;
            for(int j=0;j<a.length;j++){
                if(i==a[j])count++;
            }
            System.out.println("数字"+i+"有"+count+"个");
        }*/
        /*char[] c=s.toCharArray();
        for(char i='0';i<='9';i++){
            int count=0;
            for(int j=0;j<c.length;j++){
                if(i==c[j])count++;
            }
            System.out.println("数字"+i+"有"+count+"个");
        }*/

    }
}
