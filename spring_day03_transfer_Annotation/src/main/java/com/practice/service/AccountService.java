package com.practice.service;

import com.practice.domain.Account;

import java.util.List;

public interface AccountService {
    void transfer(String sourceName, String targetName, float money);

    Account find();
}
