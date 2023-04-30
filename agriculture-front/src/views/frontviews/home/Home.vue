<template>
  <div class="home-container">
    <HomeMainOver></HomeMainOver>
    <HomeLeft ></HomeLeft>
    <HomeRight></HomeRight>
    <HomeMiddle></HomeMiddle>
    <HomeMiddle2></HomeMiddle2>
  </div>
</template>

<script>
import Nav from "../../../components/Nav";
import HomeMainOver from "./HomeMainOver";
import HomeLeft from "./HomeLeft";
import HomeRight from "./HomeRight";
import HomeMiddle from "./HomeMiddle";
import HomeMiddle2 from "./HomeMiddle2";
export default {
  name: "Home",
  components: {
    Nav,
    HomeMainOver,
    HomeLeft,
    HomeRight,
    HomeMiddle,
    HomeMiddle2,
  }
}
</script>

<style scoped>
  .home-container{
    /*background-image: url("../../../assets/images/b10.jpg");*/
    /*background-size: cover;*/
    /*background-image: linear-gradient(0grad, #f3f6f1,#cac6c6);*/
    height: 100%;
    width: 100%;
    margin-top: -30px;
    padding: 10px 10px 50px 10px;
    position: static;
  }
</style>
