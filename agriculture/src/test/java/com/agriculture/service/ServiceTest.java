package com.agriculture.service;


import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ServiceTest {
    @Resource
    private IUserService userService;

}
