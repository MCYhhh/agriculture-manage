package com.agriculture.entity.vo;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChargeGoodsVO {
    private Integer cid;

    private Integer uid;

    private Integer gid;

    private Integer cnum;

    private LocalDateTime cdate;

    private Integer state;

    private LocalDateTime updateTime;

    private String gname;

    private BigDecimal gprice;

    private Integer gsate;

    private String gimg;

    private String gdesp;

}
