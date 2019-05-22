package com.practice.dao.impl;

import com.practice.dao.UserDao;
import com.practice.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate template;

    @Override
    public List<User> findAll() {
        String sql = "select * from user1";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user1 values(?,?,?)";
        return template.update(sql,user.getId(),user.getUsername(),user.getPassword());
    }
}
