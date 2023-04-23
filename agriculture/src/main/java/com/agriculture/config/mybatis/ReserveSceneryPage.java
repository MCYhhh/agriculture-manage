package com.agriculture.config.mybatis;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReserveSceneryPage {
    private int page;//页面参数，当前页面
    private int size;//页面参数，当前大小
    private Integer rid;
    private Integer sid;
    private Integer cid;
    private Integer gid;
    private Integer dnum;
    private BigDecimal dtotal;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private String sname;
    private String saddress;
    private BigDecimal sprice;
    private String sdesp;
    private String surl;
    private Integer sstate;
    private LocalDateTime sdate;
    private Integer uid;
}
