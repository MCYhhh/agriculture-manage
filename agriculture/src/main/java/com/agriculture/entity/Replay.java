package com.agriculture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 回复表
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Replay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    private Integer cid;

    private Integer rpid;

    private Integer rtype;

    private Integer fuid;

    private Integer tuid;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
