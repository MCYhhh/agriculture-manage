package com.agriculture.service;

import com.agriculture.controller.dao.UserDao;
import com.agriculture.entity.LoginUser;
import com.agriculture.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
public interface IUserService extends IService<User> {


    void logout();

    UserDao login(UserDao userDao);
}
