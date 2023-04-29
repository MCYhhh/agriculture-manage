<template>
  <div class="nav-container">
    <el-menu v-for="item in shoppermenus" :key="item.mid"
             :router="true"
             active-text-color="#ffd04b"
             :default-active="$route.path">
      <el-menu-item :index='item.mpath'><i :class="item.micon"></i><span>{{item.mtitle}}</span></el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "ShopperNav",
  data(){
    return{
      shoppermenus:[
        {mid:10,mtitle:'首页',mdesp:'首页',mpath:'/shopper/home',mrouter:'Home',mvisible:0,state:0,micon:'el-icon-s-home'},
        {mid:1,mtitle:'用户管理',mdesp:'用户管理',mpath:'/shopper/user',mrouter:'UserManage',mvisible:0,state:0,micon:'el-icon-user-solid'},
        {mid:2,mtitle:'订单管理',mdesp:'订单管理',mpath:'/shopper/order',mrouter:'OrderManage',mvisible:0,state:0,micon:'el-icon-s-order'},
        {mid:3,mtitle:'商品管理',mdesp:'商品管理',mpath:'/shopper/goods',mrouter:'GoodsManage',mvisible:0,state:0,micon: 'el-icon-s-goods'},
        {mid:4,mtitle:'景区管理',mdesp:'景区管理',mpath:'/shopper/scenery',mrouter:'SceneryManage',mvisible:0,state:0,micon: 'el-icon-s-ticket'},
      ]
    }
  }
}
</script>

<style scoped>
.nav-container{
  height: 100%;
}
.el-menu {
  background-color: rgb(221, 241, 209)
}
/deep/.el-menu .el-menu-item.is-active {
  /*outline: 0 !important;*/
  color: #303133 !important;
  background-color:rgba(0,0,0,0)!important;
  border-bottom: none;
}
</style>
