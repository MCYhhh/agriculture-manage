package com.agriculture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 景区表
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Scenery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private String sname;

    private String saddress;

    private BigDecimal sprice;

    private String sdesp;

    private String surl;

    private Integer sstate;

    private LocalDateTime sdate;

    private Integer uid;


}
