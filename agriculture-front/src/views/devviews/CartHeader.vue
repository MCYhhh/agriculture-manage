<template>
  <div class="cart-header">
    <el-card shadow="always">
      {{title}}
    </el-card>
  </div>
</template>

<script>
export default {
  name: "CartHeader",
  data(){
    return{
      title:'购物中心'
    }
  }
}
</script>

<style scoped>
  .cart-header{
    font-size: 30px;
  }
  .el-card{
    color: #f1c18b;
    font-weight: bolder;
  }
</style>
