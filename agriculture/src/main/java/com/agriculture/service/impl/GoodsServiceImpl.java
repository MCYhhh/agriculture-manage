package com.agriculture.service.impl;

import com.agriculture.entity.Goods;
import com.agriculture.mapper.GoodsMapper;
import com.agriculture.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public Page<Goods> selectPage(Page<Goods> page, QueryWrapper<Goods> queryWrapper) {
        return goodsMapper.selectPage(page,queryWrapper);
    }
}
