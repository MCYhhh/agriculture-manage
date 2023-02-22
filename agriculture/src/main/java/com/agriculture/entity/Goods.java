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
 * 商品表
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gid", type = IdType.AUTO)
    private Integer gid;

    private String gname;

    private BigDecimal gprice;

    private Integer gsate;

    private String gimg;

    private String gdesp;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
