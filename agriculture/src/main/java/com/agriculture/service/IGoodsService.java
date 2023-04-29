package com.agriculture.service;

import com.agriculture.entity.Goods;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
public interface IGoodsService extends IService<Goods> {

    Page<Goods> selectPage(Page<Goods> spage, QueryWrapper<Goods> queryWrapper);
}
