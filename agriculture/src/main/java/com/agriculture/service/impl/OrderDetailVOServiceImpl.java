package com.agriculture.service.impl;

import com.agriculture.entity.vo.OrderDetailVO;
import com.agriculture.mapper.OrderDetailVOMapper;
import com.agriculture.service.IOrderDetailVOService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderDetailVOServiceImpl extends ServiceImpl<OrderDetailVOMapper, OrderDetailVO> implements IOrderDetailVOService {
    @Resource
    OrderDetailVOMapper Mapper;

    @Override
    public List<OrderDetailVO> myorder(Integer id) {
        return Mapper.myorder(id);
    }
}
