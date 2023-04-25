package com.agriculture.config.mybatis;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReserveUserSceneryVoPage {
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
