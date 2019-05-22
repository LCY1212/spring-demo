package com.practice.service.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

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

    @Override
    public Account find() {
        Account aaa = accountDao.findAccount("aaa");
        System.out.println(aaa);
        return aaa;
    }
}
