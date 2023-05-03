package com.agriculture.service.impl;

import com.agriculture.entity.vo.ChargeGoodsVO;
import com.agriculture.mapper.ChargeGoodsVOMapper;
import com.agriculture.service.IChargeGoodsVOService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChargeGoodsVOServiceImpl extends ServiceImpl<ChargeGoodsVOMapper, ChargeGoodsVO> implements IChargeGoodsVOService {
    @Resource
    ChargeGoodsVOMapper Mapper;

    @Override
    public Page<ChargeGoodsVO> getChargeGoodsVOPage(Page<ChargeGoodsVO> iPage,Integer uid) {
        return Mapper.getChargeGoodsVoPage(iPage,uid);
    }

    @Override
    public Page<ChargeGoodsVO> findGid(Page<ChargeGoodsVO> iPage, Integer gid) {
        return Mapper.findGid(iPage,gid);
    }

    @Override
    public Page<ChargeGoodsVO> findgname(Page<ChargeGoodsVO> iPage, String gname) {
        return Mapper.findgname(iPage,gname);
    }

    @Override
    public Page<ChargeGoodsVO> finduidgname(Page<ChargeGoodsVO> iPage, String gname,Integer uid) {
        return Mapper.finduidgname(iPage,gname,uid);
    }

    @Override
    public Page<ChargeGoodsVO> all(Page<ChargeGoodsVO> iPage) {
        return Mapper.all(iPage);
    }


}
