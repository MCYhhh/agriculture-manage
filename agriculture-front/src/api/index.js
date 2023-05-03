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
//查找某个类型的文章
export const articleTypeAPI = (json) => {
  return request({
    url:'/article/findType',
    method:'POST',
    data:json,
  })
}
//根据时间排序
export const articleOrderbytime = (json) => {
  return request({
    url:'/article/orderBytime',
    method:'POST',
    data:json,
  })
}
//根据分数排序
export const articleOrderbyscore = (json) => {
  return request({
    url:'/article/orderByscore',
    method:'POST',
    data:json,
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

export const ordersFindCidAPI = (json) => {
  return request({
    url:'/orders/findCid',
    method:'POST',
    data:json,
  })
}

export const detailOrdersSaveAPI = (json) => {
  return request({
    url:'/detailorder/save',
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
export const goodsByNameAPI = (json) => {
  return request({
    url:'/goods/findByGname',
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

export const logoutAPI = () => {
  return request({
    url:'/user/logout',
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
//删除景点
export const deleteSceneryAPI = (id) => {
  return request({
    url:'/scenery/delete/'+id,
    method:'DELETE',
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

//发表文章
export const saveArticleAPI = (json) => {
  return request({
    url:'/article/save',
    method:'POST',
    data:json,
  })
}

// 预定创建
export const reserveSaveAPI = (json) => {
  return request({
      url:'/reserve/save',
  method:'POST',
    data:json,
})
}

// 查询所有订单
export const orderAllAPI = (json) => {
  return request({
    url:'/orders/findAll',
    method:'POST',
    data:json
  })
}

// 查询所有订单用户
export const orderUserAllAPI = (json) => {
  return request({
    url:'/orderuservo/allorders',
    method:'POST',
    data:json
  })
}

// 订单用户查询所有消费小于等于
export const orderUserLeAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserLe',
    method:'POST',
    data:json
  })
}

// 订单用户查询所有消费大于等于
export const orderUserGeAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserGe',
    method:'POST',
    data:json
  })
}

// 状态查询订单用户
export const orderUserOsateAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserOsate',
    method:'POST',
    data:json
  })
}


// 订单编号查询订单用户
export const orderUserOidAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserOid',
    method:'POST',
    data:json
  })
}

// 用户姓名查询订单用户
export const orderUserUameAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserUame',
    method: 'POST',
    data: json,
  })
}

// 查询所有订单
export const orderAllAPI = (json) => {
  return request({
    url:'/orders/findAll',
    method:'POST',
    data:json
  })
}

// 查询所有订单用户
export const orderUserAllAPI = (json) => {
  return request({
    url:'/orderuservo/allorders',
    method:'POST',
    data:json
  })
}

// 订单用户查询所有消费小于等于
export const orderUserLeAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserLe',
    method:'POST',
    data:json
  })
}

// 订单用户查询所有消费大于等于
export const orderUserGeAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserGe',
    method:'POST',
    data:json
  })
}

// 状态查询订单用户
export const orderUserOsateAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserOsate',
    method:'POST',
    data:json
  })
}


// 订单编号查询订单用户
export const orderUserOidAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserOid',
    method:'POST',
    data:json
  })
}

// 用户姓名查询订单用户
export const orderUserUameAPI = (json) => {
  return request({
    url:'/orderuservo/orderUserUame',
    method: 'POST',
    data: json,
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

//新增景点
export const articleSaveAPI = (json) => {
  return request({
    url:'/scenery/save',
    method:'POST',
    data:json
  })
}
//新增或者更改景点
export const articleSaveorModifyAPI = (json) => {
  return request({
    url:'/scenery/saveOrmodify',
    method:'POST',
    data:json
  })
}

//根据景点名字模糊查询
export const sceneryLikeNameAPI = (json) => {
  return request({
    url:'/scenery/findBySname',
    method:'POST',
    data:json
  })
}
//根据uid选择景点
export const sceneryByuIdAPI = (json) => {
  return request({
    url:'/scenery/selectUid',
    method:'POST',
    data:json
  })
}
//根据uid以及景点名字模糊查询
export const sceneryUidLikeNameAPI = (json) => {
  return request({
    url:'/scenery/findByUidSname',
    method:'POST',
    data:json
  })
}
