package com.agriculture.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Data
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String uaccount;

    private String uname;

    private String upwd;

    private Integer utype;

    private String usex;

    private String uemail;

    private String utel;

    private String uaddress;

    private String uimg;

    private String udesp;

    private Integer state;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
