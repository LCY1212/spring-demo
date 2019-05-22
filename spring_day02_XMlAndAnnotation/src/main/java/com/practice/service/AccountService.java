package com.practice.service;

import com.practice.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    int saveAccount(Account account);

    int deleteAccount(int id);

    int updateAccount(Account account);
}
