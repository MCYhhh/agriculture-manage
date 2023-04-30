<template>
  <div class="front-container">
    <div class="img" style="margin-left: 20px;padding: 5px">
      <img src="../../assets/images/logo.jpg" class="logo" width="100px">
      <img src="../../assets/images/font.png" height="100px">
<!--      <span style="font-size: 25px;margin-top: -10px">悦享滇韵</span>-->
<!--      <el-image src=""></el-image>-->
<!--      <h1>欢迎来到小惠旅游乡</h1>-->
    </div>
    <el-container>
      <el-header>
        <Nav></Nav>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>

  </div>

</template>

<script>
import Nav from "../../components/Nav";
export default {
  name: "Home",
  components: {Nav},

}
</script>

<style scoped>
  .logo {
    border-radius: 50px;
    box-shadow: 2px 2px 0 rgba(0, 0, 0, 0.4);
  }
</style>
