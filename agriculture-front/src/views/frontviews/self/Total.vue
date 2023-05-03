<template>
  <div class="total">
    <input type="checkbox" @click="fullCheck" :checked="isfull">全选
    <div class="goods-control">
      <span>合计:</span>
      <span class="total-price">￥{{total}}</span>
      <span class="total-count">共计:{{count}}件</span>
      <el-button type="success" round @click="payMoney">结算</el-button>
      <el-dialog title="订单支付" :visible.sync="dialogFormVisible" width="20%" style="padding: 20px">
        <img src="../../../assets/images/支付宝.jpg" style="width: 300px;margin-left: 20px">
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelinfo">取 消</el-button>
          <el-button type="primary" @click="confirminfo">支 付</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "Total",
  data(){
    return{
      dialogFormVisible:false,
    }
  },
  props:{
    total:{
      type:Number,
      default:0
    },
    count:{
      type:Number,
      default:0
    },
    isfull:{
      type:Boolean,
      default: false
    },
  },
  methods:{
    fullCheck(e){
      //监听全选的状态
      // console.log(e.target.checked)
      this.$emit('fullState',e.target.checked)
    },
    cancelinfo(){
      this.dialogFormVisible = false;
    },
    confirminfo(){
      this.dialogFormVisible = false;
      this.$message.success("支付成功")
    },
    payMoney(){
      this.dialogFormVisible=true;
    }
  }
}
</script>

<style scoped>
  .total{
    margin: 40px 180px 20px ;
  }
  .goods-control{
    margin-left: 100px;
    margin-top: -25px;
  }
  .el-button{
    margin-left: 50px;
    font-size: 15px;
  }
  .total-count{
    padding-left: 15px;
    letter-spacing: 4px;
  }
</style>
