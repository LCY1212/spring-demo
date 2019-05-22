package com.practice.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("tranMan")
public class TranMan {
    @Autowired
    private DataSource dataSource;

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
        System.out.println("");
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
}
