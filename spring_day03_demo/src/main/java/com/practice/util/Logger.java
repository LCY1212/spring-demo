package com.practice.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    @Pointcut(value = "execution(* com.practice.service.impl.*.*())")
    public void tr1(){}

    @Before("tr1()")
    public void printLog(){
        System.out.println("Logger中的方法执行了");
    }
}
