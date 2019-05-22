package com.practice.dao.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Account> finAll() {
        String sql = "select * from account ";
        return template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public int saveAccount(Account account) {
        String sql = "insert into account values(?,?,?) ";
        int update = template.update(sql, account.getId(), account.getName(), account.getMoney());
        return update;
    }

    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ? ";
        int update = template.update(sql, id);
        return update;
    }

    @Override
    public int updateAccount(Account account) {
        String sql = "update account set name = ? where id = ?";
        int update = template.update(sql, account.getName(), account.getId());
        return update;
    }
}
