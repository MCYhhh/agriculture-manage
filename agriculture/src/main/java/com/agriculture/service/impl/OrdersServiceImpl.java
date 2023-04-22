package com.agriculture.service.impl;

import com.agriculture.entity.Orders;
import com.agriculture.mapper.OrdersMapper;
import com.agriculture.service.IOrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Resource
    private  OrdersMapper mapper;
    @Override
    public List<Orders> findstate(Integer ostate)
    {
        return mapper.findstate(ostate);
    }
    @Override
    public List<Orders> blurcname(String cname){
        return mapper.blurcname(cname);
    }
    @Override
    public List<Orders> bluruname(String uname){
        return mapper.bluruname(uname);
    }
    @Override
    public List<Orders> findcid(Integer cid) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", cid);
        List<Orders> orders = mapper.selectList(wrapper);
        return orders;
    }
    @Override
    public List<Orders> finduid(Integer uid) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", uid);
        List<Orders> orders = mapper.selectList(wrapper);
        return orders;
    }
    @Override
    public List<Orders>findototal(BigDecimal ototal){
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.ge("ototal", ototal);
        List<Orders> orders = mapper.selectList(wrapper);
        return orders;
    }

    @Override
    public IPage<Orders> selectPage(Page<Orders> page, QueryWrapper<Orders> queryWrapper) {
        return mapper.selectPage(page,queryWrapper);
    }

}
