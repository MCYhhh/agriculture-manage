package com.agriculture.service.impl;

import com.agriculture.entity.Reserve;
import com.agriculture.mapper.ReserveMapper;
import com.agriculture.service.IReserveService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 景区预约 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Service
public class ReserveServiceImpl extends ServiceImpl<ReserveMapper, Reserve> implements IReserveService {
    @Resource
    ReserveMapper mapper;
    @Override
    public IPage<Reserve> selectPage(Page<Reserve> page, QueryWrapper<Reserve> queryWrapper) {
        return mapper.selectPage(page,queryWrapper);
    }
}
