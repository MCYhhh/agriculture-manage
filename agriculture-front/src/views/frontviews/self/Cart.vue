<template>
<!--  购物页面-->
  <div class="cart">
<!--    导航栏-->
<!--    <MainHeaderb></MainHeaderb>-->
<!--    header头部区-->
    <CartHeader></CartHeader>
<!--    商品合计-->
    <Total :total="sumTotal"
            :isfull="fullState"
            @fullState="getfullState"
          :count="totalCount"></Total>
<!--    body商品区-->
<!--    循环渲染每一个商品的信息-->
    <CartBody v-for="item in goodsList" :key="item.id"
    :name="item.goods_name"
    :price="item.goods_price"
    :image="item.goods_img"
    :state="item.goods_state"
    @changeState="getState"
    :id="item.id"
    :num="item.goods_count"></CartBody>
  </div>
</template>

<script>
// import MainHeaderb from "../../frontviews/MainHeaderb";
import CartHeader from "./CartHeader";
import CartBody from "./CartBody";
import Total from "./Total";
import axios from 'axios'
import bus from "../../../eventBus";
export default {
  name: "Cart",
  components:{
    // MainHeaderb,
    CartHeader,
    CartBody,
    Total
  },
  data(){
    return{
      goodsList:[]
    }
  },
  methods:{
  //  封装请求列表数据的方
    async initCartList(){
      //调用axios的get方法，请求列表数据
      const {data:res}=await axios.get("https://www.escook.cn/api/cart")
      // console.log(res)
      //如果数据请求成功
      if(res.status===200)
        this.goodsList=res.list
      else
        console.log("获取购物车数据失败！")
      // console.log(this.goodsList)
    },
    getState(val){
      console.log("触发Cart组件",val)
      this.goodsList.some(item=>{
        if (item.id===val.id){
          item.goods_state=val.value
        }
      })
    },
    getfullState(val){
      this.goodsList.forEach(item=>item.goods_state=val)
    }
  },
  created() {
    this.initCartList()
    bus.$on('addNum',val=>{
      this.goodsList.some(item=>{
        if(item.id===val.id ){
          item.goods_count=val.value
        }
      })
    })
    bus.$on('subNum',val=>{
      if(val.value<=0)
        return  this.$message({
          message: '商品数量不能小于1！',
          type: 'error'
        });
      this.goodsList.some(item=>{
        if(item.id===val.id ){
          item.goods_count=val.value
        }
      })
    })
  },
  computed:{
    sumTotal(){
      //把购物车数组中，已勾选的商品，总价累加起来
      // return  this.goodsList
      //   .filter(item=>item.goods_state)
      //   .reduce((total,item)=>( total+=item.goods_price*item.goods_count),0)
      return this.goodsList.filter(item=>item.goods_state).reduce((sum,item)=> (sum+=item.goods_price*item.goods_count),0)
    },
    fullState(){
      return this.goodsList.every(item=>item.goods_state)
    },
    totalCount(){
      return this.goodsList.filter(item=>item.goods_state).reduce((sum,item)=> (sum+=item.goods_count),0)
    }
  }
}
</script>

<style scoped>

</style>
