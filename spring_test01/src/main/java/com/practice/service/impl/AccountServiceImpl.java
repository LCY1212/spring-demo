package com.practice.service.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import com.practice.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = accountDao.findAll();
        return list;
    }
}
