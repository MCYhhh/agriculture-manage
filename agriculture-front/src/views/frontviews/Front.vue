<template>
  <div class="front-container">
    <Logo ></Logo>
    <el-container>
      <el-header>
        <Nav></Nav>
      </el-header>
      <el-main>
        <router-view></router-view>
        <Footer></Footer>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Nav from "../../components/Nav";
import Footer from "../../components/Footer";
import Logo from "../../components/Logo";
export default {
  name: "Home",
  components: {Logo, Footer, Nav},
}
</script>

<style scoped>

</style>
