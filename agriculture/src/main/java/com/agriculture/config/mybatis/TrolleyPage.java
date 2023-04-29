package com.agriculture.config.mybatis;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class TrolleyPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer tid;
    private Integer gid;
    private Integer tnum;
    private BigDecimal ttotal;
    private Integer cid;
    private Integer uid;
    private Integer tstate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
