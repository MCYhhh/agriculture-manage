package com.agriculture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class Trolley implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    private Integer gid;

    private Integer tnum;

    private BigDecimal ttotal;

    private Integer cid;

    private Integer uid;


    private Integer tstate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
