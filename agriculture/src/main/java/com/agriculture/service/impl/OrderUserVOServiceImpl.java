package com.agriculture.service.impl;


import com.agriculture.entity.vo.OrderUserVO;
import com.agriculture.mapper.OrderUserVOMapper;
import com.agriculture.service.IOrderUserVOService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderUserVOServiceImpl extends ServiceImpl<OrderUserVOMapper, OrderUserVO> implements IOrderUserVOService {

    @Resource
    OrderUserVOMapper Mapper;

    @Override
    public Page<OrderUserVO> myorders(Page<OrderUserVO> iPage, Integer cid) {
        return Mapper. myorders(iPage,cid);
    }

    @Override
    public Page<OrderUserVO> bmyorders(Page<OrderUserVO> iPage, Integer uid) {
        return Mapper. bmyorders(iPage,uid);
    }

    @Override
    public Page<OrderUserVO> allorders(Page<OrderUserVO> iPage) {
        return Mapper. allorders(iPage);
    }

    @Override
    public Page<OrderUserVO> ciduidorders(Page<OrderUserVO> iPage, Integer uid, Integer cid) {
        return Mapper. ciduidorders(iPage,uid,cid);
    }


}
