package com.agriculture.service;

import com.agriculture.entity.Reserve;
import com.agriculture.entity.vo.ReserveSceneryVo;
import com.agriculture.entity.vo.ReserveUserSceneryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 景区预约 服务类
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
public interface IReserveService extends IService<Reserve> {

    IPage<Reserve> selectPage(Page<Reserve> spage, QueryWrapper<Reserve> queryWrapper);

    IPage<ReserveSceneryVo> getReserveSceneryPageVo(Page<ReserveSceneryVo> iPage);

    IPage<ReserveSceneryVo> getReserveSceneryPageVoByCid(Page<ReserveSceneryVo> iPage, Integer id);

    IPage<ReserveSceneryVo> getReserveSceneryPageVoByUid(Page<ReserveSceneryVo> iPage, Integer id);

    IPage<ReserveUserSceneryVo> getRUSVo(Page<ReserveUserSceneryVo> iPage);

    IPage<ReserveUserSceneryVo> getRUSVoByUname(Page<ReserveUserSceneryVo> iPage, String Uname);

    IPage<ReserveUserSceneryVo> getRUSVoBySname(Page<ReserveUserSceneryVo> iPage,String Sname);
}
