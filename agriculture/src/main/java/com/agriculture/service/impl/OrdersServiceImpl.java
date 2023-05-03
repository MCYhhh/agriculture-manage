package com.agriculture.service.impl;

import com.agriculture.entity.Orders;
import com.agriculture.entity.vo.OrderUserVO;
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

    @Override
    public IPage<OrderUserVO> orderUserLePage(Page<OrderUserVO> spage, BigDecimal ototal) {
        return mapper.orderUserLePage(spage, ototal);
    }

    @Override
    public IPage<OrderUserVO> orderUserGePage(Page<OrderUserVO> spage, BigDecimal ototal) {
        return mapper.orderUserGePage(spage, ototal);
    }

    @Override
    public IPage<OrderUserVO> orderUserUamePage(Page<OrderUserVO> spage, String uname) {
        return mapper.orderUserUamePage(spage, uname);
    }

    @Override
    public IPage<OrderUserVO> orderUserOsatePage(Page<OrderUserVO> spage, Integer osate) {
        return mapper.orderUserOsatePage(spage, osate);
    }

    @Override
    public IPage<OrderUserVO> orderUserOidPage(Page<OrderUserVO> spage, Integer oid) {
        return mapper.orderUserOidPage(spage, oid);
    }

    @Override
    public IPage<OrderUserVO> orderUserShopOid(Page<OrderUserVO> iPage, Integer uid, Integer oid) {
        return mapper.orderUserShopOid(iPage,uid,oid);
    }

    @Override
    public IPage<OrderUserVO> orderUserShopLe(Page<OrderUserVO> iPage, Integer uid, BigDecimal ototal) {
        return mapper.orderUserShopLe(iPage, uid,ototal);
    }

    @Override
    public IPage<OrderUserVO> orderUserShopGe(Page<OrderUserVO> iPage, Integer uid, BigDecimal ototal) {
        return mapper.orderUserShopGe(iPage,uid,ototal);
    }

    @Override
    public IPage<OrderUserVO> orderUserShopOstate(Page<OrderUserVO> iPage, Integer uid, Integer osate) {
        return mapper.orderUserShopOstate(iPage,uid,osate);
    }

}
