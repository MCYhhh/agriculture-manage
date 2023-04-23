package com.agriculture.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ReserveSceneryVo {
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
