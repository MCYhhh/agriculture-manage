package com.agriculture.config.mybatis;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ArticleUserVoPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer id;

    private String title;

    private Integer type;

    private String summary;

    private String content;

    private BigDecimal score;

    private Integer uid;

    private LocalDateTime create_time;

    private LocalDateTime update_time;

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
