package com.agriculture.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ReserveUserSceneryVo {
    private Integer rid;
    private Integer sid;
    private Integer gid;
    private Integer uid;
    private Integer dnum;
    private BigDecimal dtotal;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


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

    private String sname;
    private String saddress;
    private BigDecimal sprice;
    private String sdesp;
    private String surl;
    private Integer sstate;
    private LocalDateTime sdate;
}
