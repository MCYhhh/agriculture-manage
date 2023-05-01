<template>
  <div class="shopper-container">
    <div class="img" style="margin-left: 20px;padding: 5px">
      <Logo></Logo>
    </div>
    <div class="shopper-content">
      <el-container style="height: 1000px; border: 1px solid #eee">
        <el-aside width="200px"  style="background-color: rgb(221, 241, 209)">
         <ShopperNav></ShopperNav>
        </el-aside>
        <el-container>
          <el-header style="text-align: right; font-size: 12px">
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
import ShopperNav from "../../../components/ShopperNav";
import Logo from "../../../components/Logo";
export default {
  name: "Shopper",
  components: {Logo, ShopperNav}
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
.shopper-content{
  height: 800px;
}
.el-container{
  height: 100%;
}
</style>
