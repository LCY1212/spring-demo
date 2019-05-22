package com.practice.aspect;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TranMan {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void startTanMan(){
//        开启事务
        TransactionSynchronizationManager.initSynchronization();
//        获取相同连接
        Connection conn = DataSourceUtils.getConnection(dataSource);
//        开启手动事务
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        Connection conn = DataSourceUtils.getConnection(dataSource);
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        Connection conn = DataSourceUtils.getConnection(dataSource);
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        TransactionSynchronizationManager.clearSynchronization();
        Connection conn = DataSourceUtils.getConnection(dataSource);
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
