package com.agriculture.service.impl;

import com.agriculture.controller.dao.UserDao;
import com.agriculture.entity.User;
import com.agriculture.mapper.UserMapper;
import com.agriculture.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;



/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDao login(UserDao userDao) {
       return null;
    }
}
