package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.Account;


interface BankService {
    //开户
    public void openAccount(Account acc);
    //转账
    public void transform(Integer fromID,Integer toId,double money);
    //查询余额
    public double queryBalance(Integer userId);
    //销户destroyAccount   删除该账户
    public void destroyAccount(Integer userId);
    //贷款
    //修改密码
    //存钱
    public void save(Integer userId,double money);
    //取钱
    public void take(Integer userId,double money);
}
