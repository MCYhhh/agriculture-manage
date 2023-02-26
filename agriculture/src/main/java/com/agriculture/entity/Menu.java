package com.agriculture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    private String mtitle;

    private String mdesp;

    private String mpath;

    private String mrouter;

    private Integer mvisible;

    private Integer state;

    private Integer updateBy;

    private Integer createBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer del;

    private Integer mpid;

    private String micon;

    @TableField(exist = false)
    private List<Menu> children;


}
