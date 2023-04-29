package com.agriculture.mapper;


import com.agriculture.entity.Trolley;
import com.agriculture.entity.vo.TrolleyGoodsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TrolleyMapper extends BaseMapper<Trolley> {
    @Select("SELECT a.tid,a.gid,a.tnum,a.ttotal,a.cid,a.uid,a.tstate,a.create_Time,a.update_Time,b.gname,b.gprice,b.gsate,b.gimg,b.gdesp,b.state from trolley a LEFT JOIN goods b on a.gid=b.gid")
    Page<TrolleyGoodsVo> getTrolleyGoodsPageVo(Page<TrolleyGoodsVo> iPage);

    @Select("SELECT a.tid,a.gid,a.tnum,a.ttotal,a.cid,a.uid,a.tstate,a.create_Time,a.update_Time,b.gname,b.gprice,b.gsate,b.gimg,b.gdesp,b.state from trolley a LEFT JOIN goods b on a.gid=b.gid where a.uid=#{id}")
    IPage<TrolleyGoodsVo> getTrolleyGoodsPageVoByUid(Page<TrolleyGoodsVo> iPage, Integer id);

    @Select("SELECT a.tid,a.gid,a.tnum,a.ttotal,a.cid,a.uid,a.tstate,a.create_Time,a.update_Time,b.gname,b.gprice,b.gsate,b.gimg,b.gdesp,b.state from trolley a LEFT JOIN goods b on a.gid=b.gid where a.cid=#{id}")
    IPage<TrolleyGoodsVo> getTrolleyGoodsPageVoByCid(Page<TrolleyGoodsVo> iPage,Integer id);
}
