package com.agriculture.config.mybatis;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data

public class OrderDetailVOPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer oid;//订单号
    private Integer cid;//顾客号
    private BigDecimal ototal;//总金额
    private LocalDateTime odate;//下单时间
    private Integer uid;//商家id
    private Integer osate;//订单状态
    private LocalDateTime createTime;
    private Integer did;
    private Integer gid;
    private Integer dnum;
    private BigDecimal dtotal;
}
