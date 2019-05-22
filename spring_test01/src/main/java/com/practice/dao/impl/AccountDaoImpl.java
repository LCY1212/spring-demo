package com.practice.dao.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import com.practice.util.DruidPoolUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate template = new JdbcTemplate(DruidPoolUtil.getDs());
    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        List<Account> list = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        return list;
    }
}
