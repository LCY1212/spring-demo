package com.practice.web;

import com.practice.conf.SpringConfig;
import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.AnnotatedArrayType;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServlet {
    @Resource
    private AccountService service;

    @Test
    public void findAllTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        List<Account> list = service.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("哈哈哈");
        account.setMoney((float) 120.0);
        int i = service.saveAccount(account);
        System.out.println(i);
    }

    @Test
    public void deleteAccount() {
        int i = service.deleteAccount(4);
        System.out.println(i);
    }

    @Test
    public void updateAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("你妹");
        int i = service.updateAccount(account);
        System.out.println(i);
    }
}
