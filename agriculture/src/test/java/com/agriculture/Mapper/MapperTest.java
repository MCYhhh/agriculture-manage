package com.agriculture.Mapper;

import com.agriculture.entity.User;
import com.agriculture.mapper.MenuMapper;
import com.agriculture.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MapperTest {
    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Test
    public void TestBCryptPasswordEncoder(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encode= passwordEncoder.encode("123");
       System.out.println(passwordEncoder.matches("123","$2a$10$h.YIjvPZUOdMKZMHmuq8J.VXShs9TODvu/EbELwDYpSqGRjImUFnK"));
//        String encode1=passwordEncoder.encode("123");
//        System.out.println(encode);
//        System.out.println(encode1);
    }

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
