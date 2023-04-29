package com.agriculture.service.impl;

import com.agriculture.entity.Chargegoods;
import com.agriculture.mapper.ChargegoodsMapper;
import com.agriculture.service.IChargegoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 商品管理表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Service
public class ChargegoodsServiceImpl extends ServiceImpl<ChargegoodsMapper, Chargegoods> implements IChargegoodsService {
    @Resource
    ChargegoodsMapper Mapper;

    @Override
    public Page<Chargegoods> selectPage(Page<Chargegoods> page, QueryWrapper<Chargegoods> queryWrapper) {
        return Mapper.selectPage(page, queryWrapper);
    }
}
