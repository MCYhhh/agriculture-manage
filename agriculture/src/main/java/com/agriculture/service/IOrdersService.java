package com.agriculture.service;

import com.agriculture.entity.Orders;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
public interface IOrdersService extends IService<Orders> {
    List<Orders> findstate(Integer ostate);
    List<Orders> blurcname(String cname);

    List<Orders> bluruname(String uname);

    List<Orders> findcid(Integer cid);
    List<Orders> finduid(Integer uid) ;

    List<Orders>findototal(BigDecimal ototal);

    IPage<Orders> selectPage(Page<Orders> spage, QueryWrapper<Orders> queryWrapper);
}
