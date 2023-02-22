package com.agriculture.service;

import com.agriculture.controller.dao.UserDao;
import com.agriculture.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
public interface IUserService extends IService<User> {

    UserDao login(UserDao userDao);
}
