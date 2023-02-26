package com.agriculture.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户菜单表
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Administrate implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer rid;

    private Integer mid;


}
