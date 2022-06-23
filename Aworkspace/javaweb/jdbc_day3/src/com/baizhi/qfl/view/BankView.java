package com.baizhi.qfl.view;

import com.baizhi.qfl.entity.Account;
import com.baizhi.qfl.service.BankServiceImpl;

import java.util.Scanner;

public class BankView {
    private Scanner input= new Scanner(System.in);
    private BankServiceImpl bs = new BankServiceImpl();
    public void showMenu() {
        int choice;
        do {
            System.out.println("-----------欢迎使用XXXATM自助终端操作界面--------");
            System.out.println("1.开户   2.存款 3.取款  4.转账  5.查看用户信息  6.销户   7.退出");
            System.out.println("---------------根据提示进行操作-------------------");

            System.out.print("请输入操作编号：");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    openAccountView(); break;
                case 2:
                    saveMoneyView();break;
                case 3:
                    takeMoneyView();break;
                case 4:
                    transMoneyView(); break;
                case 5:
                    queryOneView();break;
                case 6:
                    cancelAccountView();break;
                case 7:System.out.println("欢迎再次使用~~~~");break;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        } while (choice!=7);// 有误就循环
    }
    // 开户
    public void openAccountView(){
        System.out.printf("输入用户名：");
        String name=input.next();
        System.out.printf("输入密码：");
        String psw=input.next();
        System.out.printf("输入余额：");
        double balance=input.nextDouble();
        Account acc=new Account();
        acc.setAccName(name);
        acc.setPassword(psw);
        acc.setBalance(balance);
        bs.openAccount(acc);
    }
    // 存钱
    public void saveMoneyView(){
        System.out.println("请输入存款账户id");
        int id=input.nextInt();
        System.out.println("请输入存款金额：");
        double m=input.nextDouble();
        bs.save(id, m);
        System.out.println("当前余额："+bs.queryBalance(1));
    }

    // 取款
    public void takeMoneyView() {
        System.out.println("请输入取款账户id");
        int id=input.nextInt();
        System.out.println("请输入取款金额：");
        double m=input.nextDouble();
        bs.take(id, m);
        System.out.println("当前余额："+bs.queryBalance(id));
    }

    //转账
    public void transMoneyView() {
        try{
            System.out.println("请输入转出账户：");
            int fromid = input.nextInt();
            System.out.println("请输入转入账户：");
            int toid = input.nextInt();
            System.out.println("转账金额：");
            double money = input.nextDouble();
            bs.transform(fromid, toid, money);
            System.out.println("转账成功....");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void queryOneView(){
        System.out.println("请输入查询账户id：");
        int id = input.nextInt();
    }

    public void cancelAccountView(){}

}

