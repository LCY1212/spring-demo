package com.practice.service.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import com.practice.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        //查询用户  转账用户
        Account sourceAccount = accountDao.findAccount(sourceName);
        //查询用户  目标用户
        Account targetAccount = accountDao.findAccount(targetName);
        //修改金额
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        targetAccount.setMoney(targetAccount.getMoney()+money);
        //更改数据库 -money
        accountDao.updateAccount(sourceAccount);

        //错误发生
//        System.out.println(1/0);

        //更改数据库 +money
        accountDao.updateAccount(targetAccount);
    }
}
