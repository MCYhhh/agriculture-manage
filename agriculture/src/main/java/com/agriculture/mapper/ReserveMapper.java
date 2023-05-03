package com.agriculture.mapper;

import com.agriculture.entity.Reserve;
import com.agriculture.entity.vo.ReserveSceneryVo;
import com.agriculture.entity.vo.ReserveUserSceneryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 景区预约 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Mapper
public interface ReserveMapper extends BaseMapper<Reserve> {

    @Select("select a.rid,a.sid,a.uid cid,a.gid,a.dnum,a.dtotal,a.create_time,a.update_time,b.sname,b.saddress,b.sprice,b.sdesp,b.surl,b.sstate,b.sdate,b.uid from reserve a left join scenery b on a.sid=b.sid")
    IPage<ReserveSceneryVo> getReserveSceneryPageVo(Page<ReserveSceneryVo> iPage);

    @Select("select a.rid,a.sid,a.uid cid,a.gid,a.dnum,a.dtotal,a.create_time,a.update_time,b.sname,b.saddress,b.sprice,b.sdesp,b.surl,b.sstate,b.sdate,b.uid from reserve a left join scenery b on a.sid=b.sid where a.uid=#{id}")
    IPage<ReserveSceneryVo> getReserveSceneryPageVoByCid(Page<ReserveSceneryVo> iPage, Integer id);

    @Select("select a.rid,a.sid,a.uid cid,a.gid,a.dnum,a.dtotal,a.create_time,a.update_time,b.sname,b.saddress,b.sprice,b.sdesp,b.surl,b.sstate,b.sdate,b.uid from reserve a left join scenery b on a.sid=b.sid where b.uid=#{id}")
    IPage<ReserveSceneryVo> getReserveSceneryPageVoByUid(Page<ReserveSceneryVo> iPage, Integer id);

    @Select("SELECT rid, reserve.sid,reserve.gid,reserve.uid,dnum,dtotal,reserve.create_time,reserve.update_time,uaccount,uname,upwd, utype,usex,uemail,utel, uaddress,uimg,udesp,state,sname,saddress,sprice,sdesp, surl,sstate,sdate from reserve join scenery on reserve.sid=scenery.sid join user on user.uid=reserve.uid")
    IPage<ReserveUserSceneryVo> getRUSVo(Page<ReserveUserSceneryVo> iPage);
    @Select("SELECT rid, reserve.sid,reserve.gid,reserve.uid,dnum,dtotal,reserve.create_Time,reserve.update_Time,uaccount,uname,upwd, utype,usex,uemail,utel, uaddress,uimg,udesp,state,sname,saddress,sprice,sdesp, surl,sstate,sdate from reserve join scenery on reserve.sid=scenery.sid join user on user.uid=reserve.uid where sname like '%${sname}%'")
    IPage<ReserveUserSceneryVo> getRUSVoBySname(Page<ReserveUserSceneryVo> iPage, String sname);
    @Select("SELECT rid, reserve.sid,reserve.gid,reserve.uid,dnum,dtotal,reserve.create_Time,reserve.update_Time,uaccount,uname,upwd, utype,usex,uemail,utel, uaddress,uimg,udesp,state,sname,saddress,sprice,sdesp, surl,sstate,sdate from reserve join scenery on reserve.sid=scenery.sid join user on user.uid=reserve.uid where uname like '%${uname}%'")
    IPage<ReserveUserSceneryVo> getRUSVoByUname(Page<ReserveUserSceneryVo> iPage, String uname);
}

