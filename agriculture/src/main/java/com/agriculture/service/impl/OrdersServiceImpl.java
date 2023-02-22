package com.agriculture.service.impl;

import com.agriculture.entity.Orders;
import com.agriculture.mapper.OrdersMapper;
import com.agriculture.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
