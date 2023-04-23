package com.agriculture.service;

import com.agriculture.entity.vo.ChargeGoodsVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface IChargeGoodsVOService {
    Page<ChargeGoodsVO> getChargeGoodsVOPage(Page<ChargeGoodsVO> iPage,Integer uid);

    Page<ChargeGoodsVO> findGid(Page<ChargeGoodsVO> iPage, Integer gid);

    Page<ChargeGoodsVO> findgname(Page<ChargeGoodsVO> iPage, String gname);
}
