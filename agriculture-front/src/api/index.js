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
    url: '/user/login',       //注册接口地址：以向该接口发送注册表单的数据，放入用户信息表获得返回结果           跟后端沟通！！！！！！！
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
export const ArticleUserAPI = (json) => {
  return request({
    url:'/articleUser/findAll',
    method:'POST',
    data:json,
  })
}
export const articleUserDetailAPI = (json) => {
  return request({
    url:'/articleUser/findByAid',
    method:'POST',
    data:json,
  })
}
export const sceneryAllAPI = (json) => {
  return request({
    url:'/scenery/findAll',
    method:'POST',
    data:json,
  })
}
export const saveArticleAPI = (json) => {
  return request({
    url:'/article/save',
    method:'POST',
    data:json,
  })
}

export const logoutAPI = () => {
  return request({
    url:'/user/logout',
    method:'GET',
  })
}
export const detailOrdersSaveAPI = (json) => {
  return request({
    url:'/detailorder/save',
    method:'POST',
    data:json,
  })
}
export const ordersFindCidAPI = (json) => {
  return request({
    url:'/orders/findCid',
    method:'POST',
    data:json,
  })
}
export const goodsByNameAPI = (json) => {
  return request({
    url:'/goods/findByGname',
    method:'POST',
    data:json,
  })
}
export const goodsAllAPI = (json) => {
  return request({
    url:'/goods/findAll',
    method:'POST',
    data:json,
  })
}
export const trolleySaveAPI = (json) => {
  return request({
    url:'/trolley/save',
    method:'POST',
    data:json,
  })
}
export const ordersSaveAPI = (json) => {
  return request({
    url:'/orders/save',
    method:'POST',
    data:json,
  })
}
export const goodsByLeAPI = (json) => {
  return request({
    url:'/goods/selectLe',
    method:'POST',
    data:json,
  })
}
export const goodsByGeAPI = (json) => {
  return request({
    url:'/goods/selectGe',
    method:'POST',
    data:json,
  })
}
