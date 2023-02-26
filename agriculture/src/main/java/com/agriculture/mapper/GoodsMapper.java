package com.agriculture.mapper;

import com.agriculture.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}
