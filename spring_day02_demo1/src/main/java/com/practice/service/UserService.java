package com.practice.service;

import com.practice.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    int saveUser(User user);
}
