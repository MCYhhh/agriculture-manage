package com.agriculture.service.impl;


import com.agriculture.entity.Trolley;
import com.agriculture.mapper.TrolleyMapper;
import com.agriculture.service.ITrolleyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ITrolleyServiceImpl extends ServiceImpl<TrolleyMapper, Trolley> implements ITrolleyService {
    @Resource
    TrolleyMapper trolleyMapper;
    @Override
    public IPage<Trolley> selectPage(Page<Trolley> spage, QueryWrapper<Trolley> queryWrapper) {
        return trolleyMapper.selectPage(spage, queryWrapper);
    }
}
