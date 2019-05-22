package com.practice.web;

import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
