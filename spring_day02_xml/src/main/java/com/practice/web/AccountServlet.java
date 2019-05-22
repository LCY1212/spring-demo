package com.practice.web;

import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServlet {

    @Test
    public void findAllTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AccountService service = ac.getBean("accountService", AccountService.class);
        List<Account> list = service.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void saveAccount() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AccountService service = ac.getBean("accountService", AccountService.class);
        Account account = ac.getBean("account", Account.class);
        int i = service.saveAccount(account);
        System.out.println(i);
    }

    @Test
    public void deleteAccount() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AccountService service = ac.getBean("accountService", AccountService.class);
        int i = service.deleteAccount(4);
        System.out.println(i);
    }

    @Test
    public void updateAccount() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AccountService service = ac.getBean("accountService", AccountService.class);
        Account account1 = ac.getBean("account1", Account.class);
        int i = service.updateAccount(account1);
        System.out.println(i);
    }
}
