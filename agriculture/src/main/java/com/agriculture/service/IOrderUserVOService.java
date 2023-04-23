package com.agriculture.service;

import com.agriculture.entity.vo.OrderUserVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface IOrderUserVOService {
    Page<OrderUserVO> myorders(Page<OrderUserVO> iPage, Integer cid);

    Page<OrderUserVO> bmyorders(Page<OrderUserVO> iPage, Integer uid);

    Page<OrderUserVO> allorders(Page<OrderUserVO> iPage);

    Page<OrderUserVO> ciduidorders(Page<OrderUserVO> iPage, Integer uid, Integer cid);
}
