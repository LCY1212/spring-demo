package com.practice.dao;

import com.practice.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> finAll();

    int saveAccount(Account account);

    int deleteAccount(int id);

    int updateAccount(Account account);
}
