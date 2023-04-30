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
    method:'GET',
    data:json,
  })
}
