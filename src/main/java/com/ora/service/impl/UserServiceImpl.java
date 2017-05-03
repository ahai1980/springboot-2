package com.ora.service.impl;

import java.util.List;

import com.ora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ora.model.User;
import com.ora.mapper.UserMapper;

/**
 * 用户相关数据库操作实现类
 *
 */
@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    public boolean add(User user) {
        return mapper.insert(user) > 0;
    }

    public User findByUserId(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<User> findAll() {
        return mapper.selectAll();
    }

    ;

}
