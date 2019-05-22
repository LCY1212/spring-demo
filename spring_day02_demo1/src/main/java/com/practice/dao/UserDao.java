package com.practice.dao;

import com.practice.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    int saveUser(User user);
}
