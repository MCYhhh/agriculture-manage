<template>
  <div class="homemainover-container">
    <el-row>
      <el-col>
        <el-carousel   :interval="5000" arrow="always"  style="width: 1600px">
          <el-carousel-item v-for=" item in banners" :key="item.src">
            <img  style="width:100% " :src="item">
          </el-carousel-item>
        </el-carousel>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default{
  name:"HomeMainOver",
  data(){
    return{
      banners: [
        require('../../../assets/images/b11.jpg'),
        require('../../../assets/images/b10.jpg'),
        require('../../../assets/images/b2.jpg'),
        require('../../../assets/images/b16.jpg')
      ]
    }
  }
}
</script>
<style scoped>
  .homemainover-container{
    margin: 0 auto;
    width: 1600px;
    height:500px ;
  }
</style>
