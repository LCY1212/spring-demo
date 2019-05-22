package com.practice.dao.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Account findAccount(String name) {
        String sql = "select * from account where name = ? ";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), name);
    }

    @Override
    public int updateAccount(Account account) {
        String sql = "update account set money = ? where name = ? ";
        return template.update(sql, account.getMoney(), account.getName());
    }
}
