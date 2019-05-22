package com.practice.service.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(String sourceName, String targetName, float money) {
        //查询转出用户
        Account sourceAccount = accountDao.findAccount(sourceName);
        //查询转入用户
        Account targetAccount = accountDao.findAccount(targetName);
        //金额转换
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);

        //-100
        accountDao.updateAccount(sourceAccount);

        //错误点
//        System.out.println(1 / 0);

        //+100
        accountDao.updateAccount(targetAccount);
    }
}
