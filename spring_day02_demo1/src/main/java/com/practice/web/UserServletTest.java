package com.practice.web;

import com.practice.conf.SpringConfig;
import com.practice.domain.User;
import com.practice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServletTest {
    @Resource
    private User user;

    @Resource
    private UserService service;



    @Test
    public void test() {
        List<User> list = service.findAll();
        for (User user1 : list) {
            System.out.println(user1);
        }
    }

    @Test
    public void test1() {
        System.out.println(user);
        int i = service.saveUser(user);
        if (i>0){
            System.out.println("成功保存");
        }else {
            System.out.println(i);

        }
    }
}
