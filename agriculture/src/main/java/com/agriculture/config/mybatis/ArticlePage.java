package com.agriculture.config.mybatis;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data

public class ArticlePage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
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
}


