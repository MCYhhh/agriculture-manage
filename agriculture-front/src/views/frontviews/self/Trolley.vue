<template>
  <!--  购物页面-->
  <div class="cart" v-if="goodsList">
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
    <CartBody v-for="item in goodsList" :key="item.gid"
              :name="item.gname"
              :price="item.gprice"
              :image="item.gimg"
              :gdesp="item.gdesp"
              :state="item.state"
              @changeState="getState"
              :id="item.gid"
              :num="item.tnum"></CartBody>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="articlePage.page"
      :page-sizes="[4,6,8]"
      :page-size="articlePage.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="articlePage.total"
      style="text-align: center;display: block;bottom: 200px;">
    </el-pagination>
  </div>
</template>

<script>
// import MainHeaderb from "../../frontviews/MainHeaderb";
import CartHeader from "./CartHeader";
import CartBody from "./CartBody";
import Total from "./Total";
import axios from 'axios'
import bus from "../../../eventBus";
import { trolleyGoodsAPI} from "../../../api";
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
      goodsList:[],
      articlePage:{
        page: 1,
        size:4,
        total:0,
        cid:JSON.parse(localStorage.getItem('user')).uid
      }
    }
  },
  methods:{
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.articlePage.size=val;
      this.getarticleList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.articlePage.page=val;
      this.getarticleList();
    },

    //  封装请求列表数据的方
    async initCartList(){
      //调用axios的post方法，请求列表数据
      const json=JSON.stringify(this.articlePage)
      const {data:res}=await trolleyGoodsAPI(json)
      console.log(res)
      if (res.code==='00000'){
        console.log("购物车获取成功");
        this.goodsList=res.data.records;
        console.log(this.news);
        this.goodsList.forEach(item=> {
          if(item.state===0)
            item.state = false
          else
            item.state = true
        })
        this.articlePage.total=res.data.total;
        console.log(this.goodsList)
        this.$message.success("获取购物车信息成功")
      }else{
        this.$message.error("获取购物车信息失败")
      }

    },
    getState(val){
      console.log("触发Cart组件",val)
      this.goodsList.some(item=>{
        if (item.gid===val.id){
          item.state=val.value
        }
      })
    },
    getfullState(val){
      this.goodsList.forEach(item=>item.state=val)
    }
  },
  created() {
    this.initCartList()
    bus.$on('addNum',val=>{
      this.goodsList.some(item=>{
        if(item.gid===val.id ){
          item.tnum=val.value
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
        if(item.gid===val.id ){
          item.tnum=val.value
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
      return this.goodsList.filter(item=>item.state).reduce((sum,item)=> (sum+=item.gprice*item.tnum),0)
    },
    fullState(){
      return this.goodsList.every(item=>item.state)
    },
    totalCount(){
      return this.goodsList.filter(item=>item.state).reduce((sum,item)=> (sum+=item.tnum),0)
    }
  }
}
</script>

<style scoped>

</style>
