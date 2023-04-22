package com.agriculture.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

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
