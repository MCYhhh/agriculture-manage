package com.agriculture.controller.dao;

import com.agriculture.entity.Menu;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDao {

    private Integer uid;

    private String uaccount;

    private String uname;

    private String upwd;

    private Integer utype;

    private String usex;

    private String uemail;

    private String utel;

    private String uaddress;

    private String uimg;

    private String udesp;

    private Integer ustate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String token;

    private List<Menu> menus;
}
