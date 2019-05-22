package com.practice.web;

import com.practice.conf.SpringConfig;
import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestServlet {

    @Resource
    private AccountService service;

    @Test
    public void transfer() {
        service.transfer("aaa", "bbb", 100);
        Account account = service.find();
        Float money = account.getMoney();
        System.out.println(money);
        System.out.println(account);
    }
}
