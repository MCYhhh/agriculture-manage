package com.agriculture.service;


import com.agriculture.entity.Trolley;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ITrolleyService extends IService<Trolley> {
    IPage<Trolley> selectPage(Page<Trolley> spage, QueryWrapper<Trolley> queryWrapper);
}
