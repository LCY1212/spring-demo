package com.practice.web;

import com.practice.conf.SpringConfig;
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
    public void transferTest(){
        service.transfer("aaa","bbb",100);
    }

    @Test
    public void test1(){
        System.out.println(~2);
        System.out.println(2^2);
        System.out.println(2&2);
        System.out.println(2|2);
    }
}
