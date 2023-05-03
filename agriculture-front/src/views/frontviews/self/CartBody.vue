<template>
  <div class="cart-body">
    <el-card shadow="always">
      <div class="goods-container">
        <div class="goods-control">
          <input type="checkbox" class="el-checkbox" :checked="state" @click="changeState">
          <span style="color: #6cea9e;font-style: oblique">@悦享滇韵</span>
          <label class="goods-control-label">
<!--            商品的缩略图-->
            <img :src="image" alt="" width="100px">
          </label>
          <Counter :id="id" :count="num" :stateNew="state"></Counter>
        </div>
      </div>
<!--      商品信息框-->
      <div class="goods-info">
<!--        商品标题-->
        <h3 class="goods-title">
          <el-tag type="success">商品名称</el-tag>
          {{ name }}</h3>
        <h4 class="goods-title"><el-tag type="error">商品名称</el-tag>
          {{ gdesp }}</h4>
        <div class="goods-info-bottom">
<!--          商品价格-->
          <span class="goods-price"><el-tag type="warning">商品价格</el-tag>
            ￥{{price}}</span>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import Counter from "./Counter";
export default {
  name: "CartBody",
  components:{
    Counter
  },
  props:{
    name:{
      type:String,
      default:''
    },
    price:{
      type:Number,
      default: 0
    },
    image:{
      type:String,
      default:''
    },
    gdesp:{
      type:String,
      default:''
    },
    state:{
      type:Boolean,
      default:false
    },
    id:{
      type:Number,
      required:true
    },
    num:{
      type:Number,
      default:0
    }
  },
  methods:{
    //只要复选框的选中状态发生变化，就会调用整个函数
    changeState(e){
      const newState=e.target.checked
      console.log("thisthis",this)
      const  obj={id:this.id,value:newState}
      this.$emit('changeState',obj)
    }
  }
}
</script>

<style scoped>
  .cart-body{
    width: 80%;
    margin: 50px auto;
    border-radius: 10px;
  }
  .goods-info{
    margin-left: 400px;
    margin-top: -150px;
    padding: 10px 0;
  }
  .goods-container{
    background-color: #f6e5e7;
    border-radius: 10px;
    padding: 50px;
  }

</style>
