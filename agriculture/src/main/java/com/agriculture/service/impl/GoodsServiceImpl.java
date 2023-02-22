package com.agriculture.service.impl;

import com.agriculture.entity.Goods;
import com.agriculture.mapper.GoodsMapper;
import com.agriculture.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
