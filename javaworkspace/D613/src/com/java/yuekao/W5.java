package com.java.yuekao;

public class W5 {
    public static void main(String[] args) {
        IAImpl i= new IAImpl();
        System.out.println(i.isAccord("HelloWorlD"));
        System.out.println(i.isAccord("hello"));
        System.out.println(i.selectMax(10));
    }
}
interface IA{
    int selectMax(int a);//返回值1-a之间所有偶数的和
    boolean isAccord(String str); //判断str中是否有大写字母
}
class IAImpl implements IA {
    public int selectMax(int a){
        int sum=0;
        for (int i = 1; i <=a; i++) {
            if (i%2==0) {
                sum +=i;
            }
        }
        return sum;
    }
    public boolean isAccord(String str){ //判断str中是否有大写字母
        int flag=0;
        for (int i =0; i<str.length(); i++) {
            if(str.charAt(i) >= 'A'&&str.charAt(i) <= 'Z'){
                flag++;
                return true;
            }
        }
        if (flag == 0) {
            return false;
        }
        return false;
    }
}