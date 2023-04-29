<template>
  <div class="admin-container">
    <div class="img" style="margin-left: 20px;padding: 5px">
      <img src="../../../assets/images/logo.jpg" class="logo" width="100px">
      <img src="../../../assets/images/font.png" height="100px">
    </div>
    <div class="admin-content">
      <el-container style="height: 1000px; border: 1px solid #eee">
        <el-aside width="200px"  style="background-color: rgb(235, 246, 235)">
        <AdminNav></AdminNav>
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
  </div>
</template>

<script>
import AdminNav from "../../../components/AdminNav";
export default {
  name: "Admin",
  components: {AdminNav},
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
.logo{
  border-radius: 50px;
  box-shadow: 2px 2px 0 rgba(0,0,0,0.4);
}
.el-header {
  background-color: #faf6ec;
  color: #333;
  line-height: 60px;
  height: 100%;
}
.admin-content{
  height: 800px;
}
.el-container{
  height: 100%;
}
</style>
