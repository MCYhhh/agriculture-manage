package com.agriculture.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailVO {
    private Integer did;

    private Integer oid;

    private Integer gid;

    private Integer dnum;

    private BigDecimal dtotal;



    private String gname;

    private BigDecimal gprice;

    private String gimg;

    private String gdesp;

}
