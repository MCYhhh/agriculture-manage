package com.agriculture.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 景区预约
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Reserve implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    private Integer sid;

    private Integer gid;

    private Integer uid;

    private Integer dnum;

    private BigDecimal dtotal;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
