package com.agriculture.config.mybatis;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetailorderPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer did;
    private Integer oid;
    private Integer gid;
    private Integer dnum;
    private BigDecimal dtotal;
}
