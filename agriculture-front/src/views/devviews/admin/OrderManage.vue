<template>
  <div class="ordermanage-container">
    <div class="searchblock">
      <el-button>
        <el-dropdown @command="chooseValue">
        <span class="el-dropdown-link">
          <i class="el-icon-caret-bottom" style="font-size: 18px">{{ choose }}</i>
        </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item v-for="item in option1" :key="item.value" :command="item.label">
              <span style="margin: 5px 10px;">{{ item.label }}</span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-button>
      <el-input v-model="value"  prefix-icon="el-icon-search" @keyup.enter.native="search()"></el-input>
    </div>
    <el-table
      :data="orders"
      v-loading="loading"
      style="width: 100%;text-align:center;margin-left: -10%;">
      <el-table-column
        type="index"
        label="序号"
        width="150%">
      </el-table-column>
      <el-table-column
        prop="oid"
        label="订单编号"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="cid"
        label="用户编号"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="uname"
        label="用户姓名"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="usex"
        label="性别"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="atate"
        label="用户状态"
        width="100%">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.state === 0 ? 'success' : 'message'"
            v-if="scope.row.state === 0"
            disable-transitions>正常</el-tag>
          <el-tag
            :type="scope.row.state === 0 ? 'success' : 'message'"
            v-else
            disable-transitions>注销</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="ototal"
        label="总消费/元"
        width="150%">
      </el-table-column>
      <el-table-column
        prop="osate"
        label="订单状态"
        width="150%"
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
      <el-table-column
        prop="odate"
        label="时间"
        width="200%">
      </el-table-column>
      <el-table-column label="操作" width="150%">
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
    <div class="pay">
      <el-dialog title="订单支付" :visible.sync="dialogFormVisible" width="380px" style="padding: 20px">
        <img src="../../../assets/images/支付宝.jpg" style="width: 300px;margin-left: 20px">
        <div slot="footer" class="dialog-footer" style="text-align: center">
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
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="aPage.page"
      :page-sizes="[10,20,50]"
      :page-size="aPage.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="aPage.total"
      style="text-align: center;display: block;bottom: 200px;">
    </el-pagination>
  </div>
</template>

<script>
import {
  goodsByGeAPI,
  goodsByLeAPI, goodsByNameAPI,
  orderAllAPI,
  orderUserAllAPI,
  orderUserGeAPI,
  orderUserLeAPI, orderUserOidAPI, orderUserOsateAPI, orderUserUameAPI,
  updateOrderAPI
} from "../../../api";

export default {
  name: "OrderManage",
  data() {
    return {
      value: '',
      choose: '选择类型',
      option1: [
        {label: '没有条件', value: -1},
        {label: '订单状态', value: 0},
        {label: '消费小于', value: 2},
        {label: '消费大于', value: 3},
        {label: '订单编号', value: 4},
        {label: '用户姓名', value: 1},
      ],
      tag:0,
      loading:false,
      activeName: '1',
      dialogFormVisible:false,  //控制支付弹框
      dialogDetailFormVisible:false,  //控制详情弹框
      orders:[],
      aPage:{
        page: 1,
        size:10,
        total:0,
        uid:0,
        uname:"",
        ototal:0,
        oid:0,
        osate:0,
        cid:JSON.parse(localStorage.getItem('user')).uid
      }
    }
  },
  methods:{
    chooseValue(label) {
      this.choose = label
      if (this.choose.includes('小于')) {
        this.$message({
          message: '请输入输入价格，将查询小于等于该价格的商品',
          type: 'success'
        });
      } else if (this.choose.includes('大于')) {
        this.$message({
          message: '请输入输入消费，将查询大于等于该消费的订单',
          type: 'success'
        });
      } else if (this.choose.includes('订单编号')) {
        this.$message({
          message: '请输入订单编号，查询相应订单',
          type: 'success'
        });
      }else if (this.choose.includes('用户姓名')) {
        this.$message({
          message: '请输入用户姓名，查询相应订单',
          type: 'success'
        });
      }else if (this.choose.includes('订单状态')){
        this.$message({
          message: '请输入“已支付”或“待支付”',
          type: 'success'
        })
      }else{
        this.$message({
          message: '请输入有效值',
          type: 'success'
        })
      }
      this.tag = 1
      if (this.choose.includes('没有条件')){
        this.tag = 0
      }
    },
    search() {
      if (this.tag === 0) {
        this.aPage.size=10
        this.aPage.page=1
        this.getList();
      } else if (this.value==="") {
        this.$message({
          message: "请输入值",
          type: "warning",
        })
      }else{
        console.log(typeof this.value)
        console.log(this.value)
        this.aPage.size=10
        this.aPage.page=1
        if (this.choose.includes('小于')) {
          console.log("Le")
          const numReg = /^([1-9][0-9]*)+(.[0-9]{1,2})?$/
          const numRe = new RegExp(numReg)
          if (numRe.test(this.value)) {
            console.log("拿到输入值-数字", this.value)
            console.log(this.value)
            this.aPage.ototal = Number(this.value)
            console.log("this.aPage.ototal"+this.aPage.ototal)
            this.getOrderLeList()
          }else{
            console.log("非数字", this.value)
            console.log(typeof this.value)
            this.$message({
              type: 'error',
              message: '请输入数字 ',
              duration: 10000,
              showClose: true,
            })
          }
        } else if (this.choose.includes('大于')) {
          console.log("Ge")
          const numReg = /^([1-9][0-9]*)+(.[0-9]{1,2})?$/
          const numRe = new RegExp(numReg)
          if (numRe.test(this.value)) {
            console.log("拿到输入值-数字", this.value)
            console.log(this.value)
            this.aPage.ototal = Number(this.value)
            console.log("this.aPage.ototal"+this.aPage.ototal)
            this.getOrderGeList()
          }else{
            console.log("非数字", this.value)
            console.log(typeof this.value)
            this.$message({
              type: 'error',
              message: '请输入数字 ',
              duration: 10000,
              showClose: true,
            })
          }
        } else if (this.choose.includes('订单编号')) {
          console.log("cid")
          const numReg = /^([1-9][0-9]*)+(.[0-9]{1,2})?$/
          const numRe = new RegExp(numReg)
          if (numRe.test(this.value)) {
            console.log("拿到输入值-数字", this.value)
            console.log(this.value)
            this.aPage.oid = Number(this.value)
            console.log("this.aPage.oid"+this.aPage.oid)
            this.getOrderOidList()
          }else{
            console.log("非数字", this.value)
            console.log(typeof this.value)
            this.$message({
              type: 'error',
              message: '请输入数字 ',
              duration: 10000,
              showClose: true,
            })
          }
        }else if (this.choose.includes('用户姓名')) {
          console.log("uname")
          this.aPage.uname=this.value
          console.log("this.aPage.uname"+this.aPage.uname)
          this.getOrderUnameList()
        }else if (this.choose.includes('订单状态')){
          console.log("osate")
          if (this.value.includes('已支付')){
            this.aPage.osate=1
            console.log("this.aPage.osate"+this.aPage.osate)
            this.getOrderOsateList()
          }else if (this.value.includes('待支付')){
            this.aPage.osate=0
            console.log("this.aPage.osate"+this.aPage.osate);
            this.getOrderOsateList()
          }else{
            this.$message({
              message: '请输入“已支付”或“待支付”',
              type: 'warning'
            })
          }
        }
      }
    },
    async getOrderLeList() {
      this
      console.log("getOrderLeList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await orderUserLeAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.orders=[]
        console.log("通过消费小于total获取成功");
        console.log(res);
        this.orders = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取订单",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    async getOrderGeList(){
      console.log("getOrderGeList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await orderUserGeAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.orders=[]
        console.log("通过消费大于total获取成功");
        console.log(res);
        this.orders = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取订单",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    async getOrderUnameList(){
      console.log("getOrderUnameList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await orderUserUameAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.orders=[]
        console.log("通过用户名获取成功");
        console.log(res);
        this.orders = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取订单",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    async getOrderOidList(){
      console.log("getOrderOidList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await orderUserOidAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.orders=[]
        console.log("通过订单编号获取成功");
        console.log(res);
        this.orders = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取订单",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    async getOrderOsateList(){
      console.log("getOrderOsateList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await orderUserOsateAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.orders=[]
        console.log("通过订单状态获取成功");
        console.log(res);
        this.orders = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取订单",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
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
      this.aPage.size=val;
      this.getList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.aPage.page=val;
      this.getList();
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
      }
    },
    handleDetail(index, row) {
      localStorage.setItem("orderDetailId",row.oid)
      this.$router.push("/front/self/orderdetail")
      console.log(index, row);
    },
    async getList() {
      const json = JSON.stringify(this.aPage);
      const {data: res} = await orderUserAllAPI(json);
      console.log(res)
      if (res.code === '00000') {
        this.orders = res.data.records;
        this.aPage.total = res.data.total;
        this.$message.success("获取全部订单成功")
      }
      else{
        this.$message.error("获取全部订单失败")
      }
    }
  },
  created() {
    this.getList()
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
.searchblock {
  margin: 0 auto;
  padding-bottom: 10px;
  width: 700px;
  position: static;
}

.searchblock /deep/ .el-input__inner {
  border-radius: 100px;
  border-color: rgba(218, 82, 82, 0) ;
  width: 600px;
  height: 40px;
}

.searchblock .el-input {
  border-radius: 100px;
  position: absolute;
  width: 600px;
  height: 40px;
}

.searchblock .el-input:hover {
  box-shadow: 3px 3px 3px rgba(1, 1, 1, 0.2);
}

.searchblock .el-button {
  border-radius: 30px;
  border:10px;
}
</style >
