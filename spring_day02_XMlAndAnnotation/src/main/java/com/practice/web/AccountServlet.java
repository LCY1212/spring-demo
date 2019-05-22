package com.practice.web;

import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConfig.xml")
public class AccountServlet {
    @Resource
    private ApplicationContext ac;
    @Resource
    private AccountService service;

    @Test
    public void findAllTest() {
        List<Account> list = service.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

    }

    @Test
    public void saveAccount() {
        Account account = ac.getBean("account", Account.class);
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
        Account account1 = ac.getBean("account1", Account.class);
        int i = service.updateAccount(account1);
        System.out.println(i);
    }
}
