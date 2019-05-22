package com.practice.web;

import com.practice.domain.Account;
import com.practice.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestServlet {

    @Resource
    private AccountService service;

    @Test
    public void transfer() {
//        service.transfer("aaa", "bbb", 100);
        List<Account> all = service.findAll();
        System.out.println(all);
    }
}
