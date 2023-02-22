<template>
  <div>
    <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu router>
        <el-submenu index="1" v-for="(item,index) in this.$router.options.routes" :key="index" >
          <template slot="title">
            <i class="el-icon-message"></i>
            <span>{{item.name}}</span>
          </template>
<!--          <el-menu-item-group >-->
            <el-menu-item :index="children.path" v-for="(children,indexj) in item.children">{{children.name}}</el-menu-item>
<!--          </el-menu-item-group>-->
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>

      <el-main>
      </el-main>
      <el-main>
          <router-view/>
      </el-main>
    </el-container>
    </el-container>
  </div>
</template>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
export default {
  name :"Home",
};
</script>
