<template>
  <div class="orderManage-container" >
      <el-table
        :data="orders"
        v-loading="loading"
        style="width: 80%;margin-left: -10%;margin-top: -20px">
        <el-table-column
          type="index"
          label="序号"
          width="150">
        </el-table-column>
        <el-table-column
          prop="rid"
          label="预约编号"
          width="150">
        </el-table-column>
        <el-table-column
          prop="odate"
          label="时间"
          width="220">
        </el-table-column>
        <el-table-column
          prop="ototal"
          label="总消费/元"
          width="180">
        </el-table-column>
        <el-table-column
          prop="osate"
          label="状态"
          width="200"
        >
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.osate === 0 ? 'danger' : 'success'"
              v-if="scope.row.osate === 0"
              disable-transitions>待支付</el-tag>
            <el-tag
              :type="scope.row.osate === 0 ? 'danger' : 'success'"
              v-else
              disable-transitions>已支付</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="240px">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">支付</el-button>
            <el-button
              size="mini"
              type="success"
              @click="handleDetail(scope.$index, scope.row)">详情</el-button>
          </template>
        </el-table-column>
      </el-table>
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
    <div class="pay">
      <el-dialog title="订单支付" :visible.sync="dialogFormVisible" width="20%" style="padding: 20px">
        <img src="../../../assets/images/支付宝.jpg" style="width: 300px;margin-left: 20px">
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelinfo">取 消</el-button>
          <el-button type="primary" @click="confirminfo">支 付</el-button>
        </div>
      </el-dialog>
    </div>
    <div class="detail">
      <el-dialog title="订单详情" :visible.sync="dialogDetailFormVisible" >
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
import {updateOrderAPI, selfOrderAPI} from "../../../api";


export default {
  name: "OrderManage",
  data() {
    return {
      loading:false,
      activeName: '1',
      dialogFormVisible:false,  //控制支付弹框
      dialogDetailFormVisible:false,  //控制详情弹框
      orders:[],
      articlePage:{
        page: 1,
        size:4,
        total:0,
        cid:JSON.parse(localStorage.getItem('user')).uid
      }
    }
  },
  methods:{
    cancelinfo(){
      this.dialogFormVisible = false;
    },
    confirminfo(){
      this.dialogFormVisible = false;
      this.$message.success("支付成功")
    },
    modifyinfo(){
      this.dialogFormVisible = true
    },
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
  async handleEdit(index, row) {
      if(row.osate===1)
        alert("您已完成支付~~")
      else{
        this.dialogFormVisible=true
        const {data:res}=await updateOrderAPI({
          oid:row.oid,
          cid:JSON.parse(localStorage.getItem('user')).uid,
          uid:row.uid,
          osate:1
        })
        console.log("更改状态",res)
        if(res.code==='00000'){
          this.$message.success("支付完成")
        }else{
          this.$message.error("支付失败")
        }
        // this.$router.go(0)
      }

    },
    handleDetail(index, row) {
      // this.dialogDetailFormVisible=true
      localStorage.setItem("orderDetailId",row.oid)
      this.$router.push("/front/self/orderdetail")
      console.log(index, row);
    },
    async getOrders() {
      const json = JSON.stringify(this.articlePage);
      const {data: res} = await selfOrderAPI(json);
      console.log(res)
      if (res.code === '00000') {
        this.orders = res.data.records;
        this.articlePage.total = res.data.total;
        this.$message.success("获取我的订单成功")
      }
      else{
        this.$message.error("获取我的订单失败")
      }
    }
  },
  created() {
    this.getOrders()
  },

}
</script>

<style scoped>
/deep/ .el-table th.el-table__cell{
  font-size: 16px;
}
/deep/ .el-table td{
  margin-left: -10px;
}
/deep/ .el-table td.el-table__cell{
  font-size: 15px;
}

</style >
