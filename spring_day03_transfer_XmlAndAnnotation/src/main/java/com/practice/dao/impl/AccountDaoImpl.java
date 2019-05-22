package com.practice.dao.impl;

import com.practice.dao.AccountDao;
import com.practice.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource
    private JdbcTemplate template;

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        return template.query(sql,new BeanPropertyRowMapper<Account>(Account.class));
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
