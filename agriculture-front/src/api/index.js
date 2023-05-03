// 封装接口方法

import request from '../utils/index';    //引入自定义的axios函数

//注册接口
export const registerAPI = (json) => {     //,usrl,uinfo
  return request({
    url: '/user/register',       //注册接口地址：以向该接口发送注册表单的数据，放入用户信息表获得返回结果           跟后端沟通！！！！！！！
    method: 'POST',
    data: json,
  })
}

//登录接口
export const loginAPI = (json) => {     //,usrl,uinfo
  return request({
    url: '/user/login',
    method: 'POST',
    data: json,
  })
}
export const articleAPI = (json) => {
  return request({
    url:'/article/findAll',
    method:'POST',
    data:json,
  })
}
export const articleDetailAPI = (id) => {
  return request({
    url:'/article/'+id,
    method:'GET',
  })
}
export const sceneryAllAPI = (json) => {
  return request({
    url:'/scenery/findAll',
    method:'POST',
    data:json,
  })
}

//注销
export const logoutAPI = () => {
  return request({
    url:'/user/logout',
    method:'GET',
  })
}

//发表文章
export const saveArticleAPI = (json) => {
  return request({
    url:'/article/save',
    method:'POST',
    data:json,
  })
}

// 文件上传
export function uploadAPI (file) {
  return request({
    url: '/file/upload',
    method: 'POST',
    data: file,
  })
}

//个人订单
export const selfOrderAPI = (json) => {
  return request({
    url:'/orders/findCid',
    method:'POST',
    data:json
  })
}

//根据订单编号修改订单
export const updateOrderAPI = (json) => {
  return request({
    url:'/orders/modify',
    method:'POST',
    data:json
  })
}

//订单详情
export const orderDetailAPI = (oid) => {
  return request({
    url:'/orderdetailvo/myorder/'+oid,
    method:'GET',
    data:oid
  })
}

//商品详情
export const goodsDetailAPI = (json) => {
  return request({
    url:'/goods/findByGid',
    method:'POST',
    data:json
  })
}

//修改用户信息
export const modifyUserAPI = (json) => {
  return request({
    url:'/user/modify/',
    method:'POST',
    data:json
  })
}

//获取购物车商品信息
export const trolleyGoodsAPI = (json) => {
  return request({
    url:'/trolleyGoods/findByCid',
    method:'POST',
    data:json
  })
}
