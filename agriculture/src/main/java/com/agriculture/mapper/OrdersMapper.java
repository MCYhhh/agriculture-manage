package com.agriculture.mapper;

import com.agriculture.entity.Orders;
import com.agriculture.entity.vo.OrderUserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    List<Orders> findstate(Integer ostate);
    List<Orders> blurcname(String cname);
    List<Orders> bluruname(String uname);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where osate=#{temp}")
    IPage<OrderUserVO> orderUserOsatePage(Page<OrderUserVO> spage, Integer temp);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where ototal<=#{temp}")
    IPage<OrderUserVO> orderUserLePage(Page<OrderUserVO> spage, BigDecimal temp);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where ototal>=#{temp}")
    IPage<OrderUserVO> orderUserGePage(Page<OrderUserVO> spage, BigDecimal temp);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where uname like '%${temp}%'")
    IPage<OrderUserVO> orderUserUamePage(Page<OrderUserVO> spage, String temp);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where oid like '%${temp}%'")
    IPage<OrderUserVO> orderUserOidPage(Page<OrderUserVO> spage, Integer temp);

    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where oid like '%${oid}%' and b.uid = #{uid}")
    IPage<OrderUserVO> orderUserShopOid(Page<OrderUserVO> iPage, Integer uid, Integer oid);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where ototal <= #{ototal} and b.uid = #{uid}")
    IPage<OrderUserVO> orderUserShopLe(Page<OrderUserVO> iPage, Integer uid, BigDecimal ototal);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where ototal >= #{ototal} and b.uid = #{uid}")
    IPage<OrderUserVO> orderUserShopGe(Page<OrderUserVO> iPage, Integer uid, BigDecimal ototal);
    @Select("select oid,cid,ototal,odate,a.uid,osate,a.create_Time,b.uid userid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from user b join orders a on a.cid=b.uid where osate like '%${osate}%' and a.uid = #{uid}")
    IPage<OrderUserVO> orderUserShopOstate(Page<OrderUserVO> iPage, Integer uid, Integer osate);
}
