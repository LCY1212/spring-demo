package com.practice.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.practice")
public class SpringConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate(@Qualifier("ds1") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


    @Bean("ds1")
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql:///day05");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean("ds2")
    public DataSource getDataSource1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql:///db4");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

}
