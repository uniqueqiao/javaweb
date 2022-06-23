package com.java.hw;
import java.util.Scanner;
public class WT16 {
    public static void main(String[] args) {
        /*16.编程：假设一个银行的ATM机，它允许用户存款也可以取款。
        现在一个账户(Account)上存款为200元，用户A和用户B都拥有这个账户存款和取款的权利。
        用户A存入100元，而用户B将取出50元，则最终账户的存款应为250元。为了模拟以上过程，描述如下：*/
        // (3)main函数中负责开启两个线程，并将存取操作结束之后的账户余额进行打印输出
       /* Account account = new Account();
        ThreadA ta=new ThreadA();
        //创建线程对象
        Thread t=new Thread(ta);
        //开启线程
        t.start();
        ThreadB tb=new ThreadB();
        //创建线程对象
        Thread t2=new Thread(tb);
        //开启线程
        t2.start();
        char c=12;
        //float f=9.8;
        double d=3;
        String s="t";
        int BYTE=1;
        int _bane=1;*/
        System.out.println(2+3+"12");

    }
}
//(2)线程ThreadA负责存钱操作；线程ThreadB负责取钱操作；
class ThreadA extends Account implements Runnable {
    @Override
    public void run() {
        super.save();
    }
}
class ThreadB extends Account implements Runnable {
    @Override
    public void run() {
        super.take();
    }

}

// (1)定义一个Account类，属性为账户名(userName)和余额(balance)，类进行封装
class Account{
    private String username;
    private Double balance=200.0;
    public Account() {
    }
    public Account(String username, Double balance) {
        this.username = username;
        this.balance = balance;
    }
    public synchronized void save(){
        System.out.println("输入存款金额");
        Scanner sc=new Scanner(System.in);
        Double save=sc.nextDouble();
        balance += save;

    }
    public synchronized void take(){
        System.out.println("输入取款金额");
        Scanner sc=new Scanner(System.in);
        Double take=sc.nextDouble();
        balance -= take;
    }
    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}