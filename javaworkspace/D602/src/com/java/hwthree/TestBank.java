package com.java.hwthree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.login();

    }
}

class Bank {

    Scanner input = new Scanner(System.in);

    List<User> us= new ArrayList<User>();
    int post; // 存储当前操作账户下标

    // 初始化方法
    public void initial() {//6222020200001234567//6222020200001237777
        us.add(new User("622", "123456", "13900000000","11010119910203", 2000.0));
        us.add(new User("623", "123456", "13900000123","11010119914567", 3000.0));
        us.add(new User("6222020200001238888", "123456", "13900055667","11010119914321", 4000.0));
    }
    // 登录(登录成功-进入操作界面；不成功，提示用户名不存在或是密码错误)
    public void login() {
        this.initial();
        System.out.println("-----欢迎使用百知ATM自助终端-----");
        System.out.println("-------根据提示请先登录---------");
        System.out.print("请输入卡号：");
        String acc = input.next();
        System.out.print("请输入密码：");
        String pwd = input.next();
        // 判断：卡号和密码是否正确 -> 注意提示补全
        int flag=0;
        for (User u:us) {
            if(u.getPassword().equals(pwd)&&u.getAccount().equals(acc)){
                flag++;
                for (int i = 0; i < us.size(); i++){
                     post=i;
                    showMenu();
                }
            }
        }
        if (flag == 0) {
            System.out.println("卡号或密码不正确");
        }
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("-----------欢迎使用XXXATM自助终端操作界面--------");
            System.out.println("1.存款 2.取款 3.转账 4.查询余额  5.修改密码 6.退出");
            System.out.println("---------------根据提示进行操作-------------------");

            System.out.print("请输入操作编号：");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    this.save();
                    break;
                case 2:
                    this.take();
                    break;
                case 3:
                    this.transfer();
                    break;
                case 4:
                    System.out.println("查询余额");
                    queryBalance();
                    break;
                case 5:
                    System.out.println("修改密码");
                    updatePassword();
                    break;
                case 6:
                    System.out.println("退出");
                    break;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        } while (choice!=6);// 有误就循环
    }
    // 存款
    public void save() {
        System.out.println("请输入存款金额：");
        double save=input.nextDouble();
        User u=us.get(post);
        u.setBalance(u.getBalance()+save);
        System.out.println("存款成功,当前余额为"+u.getBalance());//实际不显示
    }

    // 取款
    public void take() {
        System.out.println("请输入取款金额：");
        double take=input.nextDouble();
        User u=us.get(post);
        if(u.getBalance()>take){
            u.setBalance(u.getBalance()-take);
            System.out.println("取款成功" );
            System.out.println("当前余额为"+u.getBalance());//实际不显示
        }else {
            System.out.println("当前余额不足");
        }

    }

    //转账
    public void transfer() {
        System.out.println("请输入转账账户：");
        String tranAcc=input.next();
        System.out.println("请输入转账金额：");
        double transfer=input.nextDouble();
        int flag=0;
        for (int i = 0; i <us.size(); i++) {
            if(us.get(i).getAccount().equals(tranAcc)){
                flag=1;
                User u=us.get(post);
                if(u.getBalance()>transfer){
                    u.setBalance(u.getBalance()-transfer);
                    System.out.println("转账成功！" );
                    System.out.println(u.getAccount()+"当前余额为"+u.getBalance());//实际不显示
                    User u2=us.get(i);
                    u2.setBalance(u2.getBalance()+transfer);
                    System.out.println(u2.getAccount()+"当前余额为"+u2.getBalance());//实际不显示
                }else {
                    flag=2;
                    System.out.println("当前余额不足，不能转账");
                    break;
                }
            }
        }
        if (flag==0) {
            System.out.println("输入账户有误！");
        }
    }
    // 查询余额
    public void queryBalance(){
        User u=us.get(post);
        System.out.println(u.getAccount()+"当前余额为："+u.getBalance());
    }

    // 修改密码(重新输入密码进行校验，正确之后再修改，修改时有二次确认)
    public void updatePassword(){
        User u=us.get(post);
        while(true){
            System.out.println("输入旧密码");
            String oldPwd=input.next();
            if (u.getPassword().equals(oldPwd)) {
                while (true) {
                    System.out.println("输入新密码");
                    String newPwd=input.next();
                    System.out.println("再次输入新密码");
                    String newPwd2=input.next();
                    if (newPwd.equals(newPwd2)) {
                        u.setPassword(newPwd);
                        System.out.println("密码修改成功");break;
                        //System.out.println("密码"+u.getPassword());//实际不显示

                    }else {
                        System.out.println("两次密码不一致");
                    }
                }
                break;
            }else {
                System.out.println("原密码输入错误");
            }
        }
    }
}

class User {

    private String account;// 账户
    private String password;// 密码
    private String phone;// 电话
    private String identityCard;// 身份证
    private double balance;// 余额

    public User() {}

    public User(String account, String password, String phone,
                String identityCard, double balance) {
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.identityCard = identityCard;
        this.balance = balance;
    }
    // get/set / toString

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
