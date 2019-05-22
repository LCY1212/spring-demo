package com.practice.aspect;

import com.practice.domain.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

@Component("tranMan")
@Aspect
public class TranMan {
    @Autowired
    private DataSource dataSource;

    @Pointcut("execution(* com.practice.service.impl.*.*(..))")
    public void pt(){}

    public void startTanMan() {
//        开启事务
        TransactionSynchronizationManager.initSynchronization();
//        获取相同连接
        Connection conn = DataSourceUtils.getConnection(dataSource);
//        开启手动事务
        try {
            conn.setAutoCommit(false);
            System.out.println(111);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        System.out.println("后置");
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        System.out.println("回滚");
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        TransactionSynchronizationManager.clearSynchronization();
        Connection conn = DataSourceUtils.getConnection(dataSource);
        System.out.println("after");
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt()")
    public Object aroundTest(ProceedingJoinPoint pjp){
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));
        Object obj = null;
        try {
            startTanMan();

            obj = pjp.proceed(args);

            System.out.println(obj);

            commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            rollback();
        }finally {
            close();
        }
        return obj;
    }
}
