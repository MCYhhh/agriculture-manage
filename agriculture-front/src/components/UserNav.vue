<template>
  <div class="nav-container">
    <el-menu v-for="item in usermenus" :key="item.mid"
             :router="true"
             active-text-color="#ffd04b"
             :default-active="$route.path">
      <el-menu-item :index='item.mpath'><i :class="item.micon"></i><span>{{item.mtitle}}</span></el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "UserNav",
  data(){
    return{
      usermenus:[
        {mid:10,mtitle:'首页',mdesp:'首页',mpath:'/front/self/home',mrouter:'Home',mvisible:0,state:0,micon:'el-icon-s-home'},
        {mid:1,mtitle:'个人信息',mdesp:'个人信息',mpath:'/front/self/info',mrouter:'UserManage',mvisible:0,state:0,micon:'el-icon-user-solid'},
        {mid:2,mtitle:'我的订单',mdesp:'我的订单',mpath:'/front/self/order',mrouter:'OrderManage',mvisible:0,state:0,micon:'el-icon-s-goods'},
        {mid:3,mtitle:'购物中心',mdesp:'购物中心',mpath:'/front/self/trolley',mrouter:'GoodsManage',mvisible:0,state:0,micon: 'el-icon-s-ticket'},
        {mid:4,mtitle:'我的预约',mdesp:'我的预约',mpath:'/front/self/reserve',mrouter:'SceneryManage',mvisible:0,state:0,micon: 'el-icon-s-claim'},
      ]
    }
  }
}
</script>

<style scoped>
/*.nav-container{*/
/*  height: 100%;*/
/*}*/
.el-menu {
  background-color: rgb(235, 246, 235)
}
/deep/.el-menu .el-menu-item.is-active {
  /*outline: 0 !important;*/
  color: #303133 !important;
  background-color:rgba(0,0,0,0)!important;
  border-bottom: none;
}
span{
  font-size: 16px;
}
</style>
