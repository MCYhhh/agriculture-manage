package com.agriculture.service.impl;

import com.agriculture.entity.Detailorder;
import com.agriculture.mapper.DetailorderMapper;
import com.agriculture.service.IDetailorderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 订单商品表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Service
public class DetailorderServiceImpl extends ServiceImpl<DetailorderMapper, Detailorder> implements IDetailorderService {
    @Resource
    DetailorderMapper mapper;
    @Override
    public IPage<Detailorder> selectPage(Page<Detailorder> page, QueryWrapper<Detailorder> queryWrapper) {
        return mapper.selectPage(page,queryWrapper);
    }
}
