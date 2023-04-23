package com.agriculture.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderUserVO {
    private Integer oid;
    private Integer cid;
    private BigDecimal ototal;
    private LocalDateTime odate;
    private Integer uid;
    private Integer osate;
    private LocalDateTime createTime;

    private Integer userid;
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
}
