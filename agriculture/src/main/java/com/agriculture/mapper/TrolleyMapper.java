package com.agriculture.mapper;


import com.agriculture.entity.Trolley;
import com.agriculture.entity.vo.TrolleyGoodsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TrolleyMapper extends BaseMapper<Trolley> {
    @Select("SELECT a.tid tid,a.gid gid,a.tnum tnum,a.ttotal ttotal,a.cid cid,a.uid uid,a.tstate tstate,a.create_Time create_Time,a.update_Time update_Time,b.gname gname,b.gprice gprice,b.gsate gsate,b.gimg gimg,b.gdesp gdesp,b.state state from trolley a LEFT JOIN goods b on a.gid=b.gid")
    Page<TrolleyGoodsVo> getTrolleyGoodsPageVo(Page<TrolleyGoodsVo> iPage);
}
