package com.dalu.ims.service.impl;

import com.dalu.ims.mapper.UserMapper;
import com.dalu.ims.pojo.User;
import com.dalu.ims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean deleteBatch(String[] ids) {
        return userMapper.deleteBatch(ids);
    }
}
