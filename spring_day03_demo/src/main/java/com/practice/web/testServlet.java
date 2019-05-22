package com.practice.web;

import com.practice.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testServlet {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
        UserService service = ac.getBean("userService", UserService.class);
        service.saveUser();
    }
}
