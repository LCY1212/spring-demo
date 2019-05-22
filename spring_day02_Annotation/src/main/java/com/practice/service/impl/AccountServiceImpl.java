package com.practice.service.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.finAll();
    }

    @Override
    public int saveAccount(Account account) {
        return accountDao.saveAccount(account);
    }

    @Override
    public int deleteAccount(int id) {
        return accountDao.deleteAccount(id);
    }

    @Override
    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

}
