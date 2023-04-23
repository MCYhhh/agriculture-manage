package com.agriculture.mapper;


import com.agriculture.entity.vo.ChargeGoodsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChargeGoodsVOMapper extends BaseMapper<ChargeGoodsVO> {
    @Select("SELECT cid,uid,chargegoods.gid,cnum,cdate,chargegoods.state,chargegoods.update_time,gname,gprice,gsate,gimg,gdesp from platform.chargegoods join platform.goods on chargegoods.gid=goods.gid where uid=#{uid}")
    Page<ChargeGoodsVO> getChargeGoodsVoPage(Page<ChargeGoodsVO> iPage, Integer uid);

    @Select("SELECT cid,uid,chargegoods.gid,cnum,cdate,chargegoods.state,chargegoods.update_time,gname,gprice,gsate,gimg,gdesp from platform.chargegoods join platform.goods on chargegoods.gid=goods.gid where chargegoods.gid=#{gid}")
    Page<ChargeGoodsVO> findGid(Page<ChargeGoodsVO> iPage, Integer gid);

    @Select("SELECT cid,uid,chargegoods.gid,cnum,cdate,chargegoods.state,chargegoods.update_time,gname,gprice,gsate,gimg,gdesp from platform.chargegoods join platform.goods on chargegoods.gid=goods.gid where gname like '%${gname}%'")
    Page<ChargeGoodsVO> findgname(Page<ChargeGoodsVO> iPage, String gname);



}

