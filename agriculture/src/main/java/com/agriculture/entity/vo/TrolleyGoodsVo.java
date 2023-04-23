package com.agriculture.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class TrolleyGoodsVo implements Serializable {
    private Integer tid;
    private Integer gid;
    private Integer tnum;
    private BigDecimal ttotal;
    private Integer cid;
    private Integer uid;
    private Integer tstate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private String gname;
    private BigDecimal gprice;
    private Integer gsate;
    private String gimg;
    private String gdesp;
    private Integer state;
}
