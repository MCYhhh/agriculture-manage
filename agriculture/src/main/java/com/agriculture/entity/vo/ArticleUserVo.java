package com.agriculture.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ArticleUserVo {
    private Integer id;

    private String title;

    private Integer type;

    private String summary;

    private String content;

    private BigDecimal score;

    private Integer uid;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String img;


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

    private Integer state;
}
