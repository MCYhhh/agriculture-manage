package com.agriculture.mapper;

import com.agriculture.entity.vo.OrderDetailVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailVOMapper extends BaseMapper<OrderDetailVO> {
    List<OrderDetailVO> myorder(Integer id);
}
