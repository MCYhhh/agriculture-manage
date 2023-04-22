package com.agriculture.config.mybatis;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReservePage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer rid;
    private Integer sid;
    private Integer gid;
    private Integer uid;
    private Integer dnum;
    private BigDecimal dtotal;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
