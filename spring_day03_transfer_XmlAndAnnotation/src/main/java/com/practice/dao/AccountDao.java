package com.practice.dao;

import com.practice.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    Account findAccount(String name);

    int updateAccount(Account account);
}
