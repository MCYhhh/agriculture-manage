package com.agriculture.mapper;

import com.agriculture.entity.vo.OrderUserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderUserVOMapper extends BaseMapper<OrderUserVO> {
    @Select("SELECT oid,cid,ototal,odate,osate,orders.create_time,orders.uid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from platform.orders join platform.user on user.uid=orders.cid where cid=#{cid}")
    Page<OrderUserVO> myorders(Page<OrderUserVO> iPage, Integer cid);


    @Select("SELECT oid,cid,ototal,odate,osate,orders.create_time,orders.uid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from platform.orders join platform.user on user.uid=orders.cid where orders.uid=#{uid} ")
    Page<OrderUserVO> bmyorders(Page<OrderUserVO> iPage, Integer uid);

    @Select("SELECT oid,cid,ototal,odate,osate,orders.create_time,orders.uid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from platform.orders join platform.user on user.uid=orders.cid")
    Page<OrderUserVO> allorders(Page<OrderUserVO> iPage);

    @Select("SELECT oid,cid,ototal,odate,osate,orders.create_time,orders.uid,uaccount,uname,upwd,utype,usex,uemail,utel,uaddress,uimg,udesp,state from platform.orders join platform.user on user.uid=orders.cid where orders.uid=#{uid} and orders.cid=#{cid}")
    Page<OrderUserVO> ciduidorders(Page<OrderUserVO> iPage, Integer uid, Integer cid);
}


