<template>
  <div class="self-container">
        <el-container style="height: 500px; border: 1px solid #eee">
          <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :router="true">
              <el-menu-item index='/front/self/home' style=" font-size: 22px;"><i class="el-icon-menu"></i>个人中心</el-menu-item>
              <el-menu-item index='/front/self/infochange' style=" font-size: 22px;"><i class="el-icon-menu"></i>修改信息</el-menu-item>
            </el-menu>
          </el-aside>
          <el-container>
            <el-header style="text-align: right; font-size: 12px">
              <el-dropdown >
                <i class="el-icon-caret-bottom"  style="margin-right: 15px;padding-right: -20px;font-size: 22px" ></i>
                <el-dropdown-menu slot="dropdown" style="width: 100px;margin-right: -50px">
                  <el-dropdown-item>返回首页</el-dropdown-item>
                  <el-dropdown-item>管理后台</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
              <span style="margin-right: 60px;font-size: 16px">王小虎</span>
            </el-header>
            <el-main>
              <router-view></router-view>
            </el-main>
          </el-container>
        </el-container>
      </div>
    </template>

<script>
    export default {
      name: "Self",
      data() {
        const item = {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        };
        return {
          tableData: Array(20).fill(item)
        }
      }
    }
</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>
