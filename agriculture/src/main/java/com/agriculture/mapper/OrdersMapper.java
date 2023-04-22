package com.agriculture.mapper;

import com.agriculture.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    List<Orders> findstate(Integer ostate);
    List<Orders> blurcname(String cname);
    List<Orders> bluruname(String uname);
}
