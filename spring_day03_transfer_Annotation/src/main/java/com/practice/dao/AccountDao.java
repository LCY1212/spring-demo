package com.practice.dao;

import com.practice.domain.Account;

public interface AccountDao {

    Account findAccount(String name);

    int updateAccount(Account account);
}
