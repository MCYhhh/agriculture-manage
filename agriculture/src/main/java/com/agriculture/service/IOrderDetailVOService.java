package com.agriculture.service;

import com.agriculture.entity.vo.OrderDetailVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IOrderDetailVOService extends IService<OrderDetailVO> {
    List<OrderDetailVO> myorder(Integer id);
}
