package com.agriculture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品管理表
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Chargegoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    private Integer uid;

    private Integer gid;

    private Integer cnum;

    private LocalDateTime cdate;

    private LocalDateTime updateTime;


}
