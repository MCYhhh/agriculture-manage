<template>
  <div class="nav-container">
    <el-menu v-for="item in adminmenus" :key="item.mid"
             :router="true"
              active-text-color="#ffd04b"
              :default-active="$route.path">
      <el-submenu :index="item.mpath" v-if="item.children!==[]">
        <template slot="title"><i :class="item.micon"></i><span>{{item.mtitle}}</span></template>
        <el-menu-item-group v-for="o in item.children" style="background-color: rgb(221, 241, 209)">
          <el-menu-item :index="o.mpath"><i :class="o.micon"></i><span>{{o.mtitle}}</span></el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-menu-item :index='item.mpath'  v-else><i :class="item.micon"></i><span>{{item.mtitle}}</span></el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "AdminNav",
  data(){
    return{
      adminmenus: localStorage.getItem("menus") ? JSON.parse(localStorage.getItem("menus")) : [],
      opens: localStorage.getItem("menus") ? JSON.parse(localStorage.getItem("menus")).map(v => v.mid + '') : []
      // adminmenus:[
      //   {mid:10,mtitle:'首页',mdesp:'首页',mpath:'/admin/home',mrouter:'Home',mvisible:0,state:0,micon:'el-icon-s-home'},
      //   {mid:1,mtitle:'用户管理',mdesp:'用户管理',mpath:'/admin/user',mrouter:'UserManage',mvisible:0,state:0,micon:'el-icon-user-solid'},
      //   {mid:2,mtitle:'订单管理',mdesp:'订单管理',mpath:'/admin/order',mrouter:'OrderManage',mvisible:0,state:0,micon:'el-icon-s-order'},
      //   {mid:3,mtitle:'商品管理',mdesp:'商品管理',mpath:'/admin/goods',mrouter:'GoodsManage',mvisible:0,state:0,micon: 'el-icon-s-goods'},
      //   {mid:4,mtitle:'景区管理',mdesp:'景区管理',mpath:'/admin/scenery',mrouter:'SceneryManage',mvisible:0,state:0,micon: 'el-icon-s-ticket'},
      //   {mid:5,mtitle:'系统管理',mdesp:'系统管理',mpath:'/admin/system',mrouter:'SystemManage',mvisible:0,state:0,micon: 'el-icon-s-tools',
      //     children:[{mid:6,mtitle:'权限管理',mdesp:'权限管理',mpath:'/admin/auth',mrouter:'AuthManage',mvisible:0,state:0,micon:'el-icon-notebook-2',},
      //       {mid:8,mtitle:'角色管理',mdesp:'角色管理',mpath:'/admin/role',mrouter:'RoleManage',mvisible:0,state:0,micon: 'el-icon-user'}]},
      // ]
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
