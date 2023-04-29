package com.agriculture.config.mybatis;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class OrdersPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer oid;
    private Integer cid;
    private BigDecimal ototal;
    private LocalDateTime odate;
    private Integer uid;
    private Integer osate;
    private LocalDateTime createTime;
}
