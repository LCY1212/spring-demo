package com.practice.service.impl;

import com.practice.dao.UserDao;
import com.practice.domain.User;
import com.practice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
}
