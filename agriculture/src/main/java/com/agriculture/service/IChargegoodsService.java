package com.agriculture.service;

import com.agriculture.entity.Chargegoods;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品管理表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
public interface IChargegoodsService extends IService<Chargegoods> {
    Page<Chargegoods> selectPage(Page<Chargegoods> spage, QueryWrapper<Chargegoods> queryWrapper);
}
