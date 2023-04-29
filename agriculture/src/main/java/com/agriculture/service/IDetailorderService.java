package com.agriculture.service;

import com.agriculture.entity.Detailorder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单商品表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
public interface IDetailorderService extends IService<Detailorder> {

    IPage<Detailorder> selectPage(Page<Detailorder> spage, QueryWrapper<Detailorder> queryWrapper);
}
