<template>
  <div class="admin-container">
    <div class="img" style="margin-left: 20px;padding: 5px">
      <Logo></Logo>
    </div>
    <div class="admin-content">
      <el-container style="height: 1000px; border: 1px solid #eee">
        <el-aside width="200px"  style="background-color: rgb(221, 241, 209)">
        <AdminNav></AdminNav>
        </el-aside>
        <el-container>
          <el-header >
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
import Logo from "../../../components/Logo";
export default {
  name: "Admin",
  components: {Logo, AdminNav},
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
  background-color: #ecf6e5;
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
