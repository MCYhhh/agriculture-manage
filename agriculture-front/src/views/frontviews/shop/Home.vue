<template>
  <div class="shop-container">
    <div class="back" @click="backFront()">
      <i class="el-icon-d-arrow-left" style="font-size: 25px;color: #999999;" ></i>
      <span style="font-size: 22px;color:#e0dddd;" >返回</span>
    </div>
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
    <div class="goodslist">
      <el-row style="margin: 70px">
        <el-col :span="4" v-for="(item, index) in goods" :key="item.gid" :offset="index%4 > 0 ? 2 : 0"
                style="padding-bottom: 30px">
          <el-card :body-style="{ padding: '10px'}" style="width:130%" shadow="hover">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                 style="width:100%;margin: auto" class="image">
            <div style="padding: 14px;">
              <span>{{ item.gname }}</span>
              <span style="padding-left: 20px">
                <el-tag type="warning">￥{{ item.gprice }}元</el-tag><van-icon name="shop-o" class="icon"
                                                                              style="margin-left: 10px">店铺</van-icon></span>
              <p>{{ item.gdesp }}</p>
              <van-goods-action>
                <van-goods-action-button type="warning" text="加入购物车"
                                         @click="addcart(item.gname,item.gid,item.gprice)"/>
                <van-goods-action-button type="danger" text="立即购买" @click="buy(item.gprice,item.gid,item.gname)"/>
              </van-goods-action>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <div class="orderinfo">
      <el-dialog title="订单信息" :visible.sync="buyVisible" width="30%">
        <el-form>
          <el-form-item label="姓名" label-width="100px">
            <el-input v-model="user.uname" disabled></el-input>
          </el-form-item>
          <el-form-item label="电话" label-width="100px">
            <el-input v-model="user.utel" disabled></el-input>
          </el-form-item>
          <el-form-item label="收获地址" label-width="100px">
            <el-input v-model="user.uaddress" disabled></el-input>
          </el-form-item>
          <el-form-item label="商品" label-width="100px">
            <el-input v-model="gname" disabled></el-input>
          </el-form-item>
          <el-form-item label="单价" label-width="100px">
            <el-input v-model="gprice" disabled></el-input>
          </el-form-item>
          <el-form-item label="数量" label-width="100px">
            <el-slider
              v-model="num"
              show-input>
            </el-slider>
          </el-form-item>
          <el-form-item label="共计" label-width="100px">
            <el-input v-model="total" disabled></el-input>
          </el-form-item>
          <el-form-item label="备注" label-width="100px">
            <el-input v-model="other"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelinfo">取 消</el-button>
          <el-button type="primary" @click="orderbutton">下 单</el-button>
        </div>
      </el-dialog>
    </div>
    <div class="trolleyinfo">
      <el-dialog title="购物车信息" :visible.sync="trolleyVisible" width="30%">
        <el-form>
          <el-form-item label="商品" label-width="100px">
            <el-input v-model="gname" disabled></el-input>
          </el-form-item>
          <el-form-item label="单价" label-width="100px">
            <el-input v-model="gprice" disabled></el-input>
          </el-form-item>
          <el-form-item label="数量" label-width="100px">
            <el-slider
              v-model="num"
              show-input>
            </el-slider>
          </el-form-item>
          <el-form-item label="共计" label-width="100px">
            <el-input v-model="total" disabled></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelCartinfo">取 消</el-button>
          <el-button type="primary" @click="addCartbutton">加入购物车</el-button>
        </div>
      </el-dialog>
    </div>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="aPage.page"
        :page-sizes="[20,50,100,200]"
        :page-size="aPage.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="aPage.total"
        style="text-align: center;display: block;bottom: 200px;">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import {
  goodsAllAPI,
  ordersSaveAPI,
  ordersFindCidAPI,
  detailOrdersSaveAPI,
  trolleySaveAPI,
  goodsByNameAPI, goodsByLeAPI, goodsByGeAPI
} from "../../../api";

export default {
  name: "Home",
  data() {
    return {
      value: '',
      choose: '选择类型',
      option1: [
        {label: '商品名称', value: 0},
        {label: '价格大于', value: 1},
        {label: '价格小于', value: 2},
      ],
      name: '',
      tag:0,
      goods: [],
      aPage: {
        page: 1,
        size: 20,
        total: 500,
        gprice:0,
        gname:""
      },
      buyVisible: false,
      trolleyVisible: false,
      other: "",
      num: 0,
      total: 0,
      user: {},
      gprice: 0,
      gname: "",
      order: {
        oid: 1,
        cid: 0,
        ototal: 0,
        uid: 0,
        ostate: 0,
        size: 10,
        page: 1,
        create_time: "",
      },
      detail: {
        oid: 1,
        gid: 0,
        dnum: 0,
        dtotal: 0,
      },
      trolley: {
        gid: 0,
        tnum: 0,
        ttotal: 0,
        cid: 0,
        uid: 0,
      }
    }
  },
  methods: {
    backFront(){
      // this.aPage.size = 20;
      // this.aPage.page = 20;
      this.$router.go(0);
    },
    chooseValue(label) {
      this.choose = label
      if (this.choose.includes('价格小于')) {
        this.$message({
          message: '请输入输入价格，将查询小于等于该价格的商品',
          type: 'success'
        });
      } else if (this.choose.includes('价格大于')) {
        this.$message({
          message: '请输入输入价格，将查询大于等于该价格的商品',
          type: 'success'
        });
      } else {
        this.$message({
          message: '请输入商品名称',
          type: 'success'
        })
      }
      this.tag = 1
    },
    search() {
      if (this.tag === 0) {
        this.$message({
          message: "请选择条件",
          type: "warning",
        })
      } else if (this.value==="") {
        this.$message({
          message: "请输入值",
          type: "warning",
        })
      }else{
        console.log(typeof this.value)
        console.log(this.value)
        this.aPage.size=20
        this.aPage.page=1
        if (this.choose.includes('价格小于')) {
          console.log("Le")
          const numReg = /^([1-9][0-9]*)+(.[0-9]{1,2})?$/
          const numRe = new RegExp(numReg)
          if (numRe.test(this.value)) {
            console.log("拿到输入值-数字", this.value)
            console.log(this.value)
            this.aPage.gprice = Number(this.value)
            console.log("this.aPage.gprice"+this.aPage.gprice)
            this.getGoodsLeList()
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
        } else if (this.choose.includes('价格大于')) {
          console.log("Ge")
          const numReg = /^([1-9][0-9]*)+(.[0-9]{1,2})?$/
          const numRe = new RegExp(numReg)
          if (numRe.test(this.value)) {
            console.log("拿到输入值-数字", this.value)
            console.log(this.value)
            this.aPage.gprice = Number(this.value)
            console.log("this.aPage.gprice"+this.aPage.gprice)
            this.getGoodsGeList()
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
        } else {
          console.log("name")
          this.aPage.gname=this.value
          console.log("this.aPage.gname"+this.aPage.gname)
          this.getGoodsByNameList()
        }
      }
    },
    async getGoodsLeList() {
      console.log("getGoodsLeList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await goodsByLeAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.goods=[]
        console.log("通过商品价格小于gprice获取成功");
        console.log(res);
        this.goods = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取商品",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    async getGoodsGeList(){
      console.log("getGoodsGeList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await goodsByGeAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.goods=[]
        console.log("通过商品价格大于gprice获取成功");
        console.log(res);
        this.goods = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取商品",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    async getGoodsByNameList(){
      console.log("getGoodsByNameList")
      const json = JSON.stringify(this.aPage);
      const {data: res} = await goodsByNameAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        this.goods=[]
        console.log("通过商品名称gname获取成功");
        console.log(res);
        this.goods = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取商品",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    addcart(gname, gid, gprice) {
      this.num = 1;
      this.trolleyVisible = true;
      this.gname = gname
      this.gid = gid
      this.gprice = gprice
      console.log(this.gname)
      console.log('加入购物车')
    },
    cancelCartinfo() {
      this.trolleyVisible = false
    },
    async addCartbutton() {
      console.log('api')
      this.trolley.gid = this.gid;
      this.trolley.tnum = this.num;
      this.trolley.ttotal = this.total;
      this.trolley.cid = this.user.uid;
      this.trolley.uid = this.user.uid;
      const json = JSON.stringify(this.trolley);
      console.log(json)
      const {data: res} = await trolleySaveAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        console.log("购物车创建成功");
        console.log(res);
      } else {
        this.$message.error(res.msg)
      }
      console.log("结束")
      this.trolleyVisible = false
      this.$notify.success({
        title: '消息',
        message: '已加入购物车',
        showClose: false
      });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.aPage.size = val;
      if (this.choose.includes('价格小于')) {
        this.getGoodsLeList()
      } else if (this.choose.includes('价格大于')) {
        this.getGoodsGeList()
      } else if (this.choose.includes('商品名称')){
        this.getGoodsByNameList()
      }else {
        this.getGoodsList()
      }
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.aPage.page = val;
      if (this.choose.includes('价格小于')) {
        this.getGoodsLeList()
      } else if (this.choose.includes('价格大于')) {
        this.getGoodsGeList()
      } else if (this.choose.includes('商品名称')){
        this.getGoodsByNameList()
      }else {
        this.getGoodsList()
      }
    },
    async getGoodsList() {
      const json = JSON.stringify(this.aPage);
      const {data: res} = await goodsAllAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        console.log("商品获取成功");
        console.log(res);
        this.goods = res.data.records;
        this.aPage.total = res.data.total;
        this.$message({
          message: "已获取商品",
          type: "success"
        })
      } else {
        this.$message.warning("查询失败，未找到相应结果")
      }
      console.log("结束")
    },
    buy(gprice, gid, gname) {
      console.log("开始买");
      this.gprice = gprice;
      this.detail.gid = gid;
      this.gname = gname;
      this.num = 1;
      console.log("uname:" + this.user.uname)
      console.log("tel:" + this.user.utel)
      console.log("address:" + this.user.uaddress)
      console.log("address:" + this.gprice)
      if (this.user.utel === null || this.user.uaddress === null) {
        alert("购物需要收货地址，请先移步”个人中心“完善电话、地址等个人信息");
      } else {
        this.buyVisible = true;
        console.log('买买买')
      }
    },
    cancelinfo() {
      this.buyVisible = false;
    },
    orderbutton() {
      console.log("orderbutton")
      this.order.cid = this.user.uid;
      this.order.ototal = this.total;
      this.order.uid = this.user.uid;
      this.order.ostate = 0;
      this.buyVisible = false;
      this.ordersSave();
      this.$notify.success({
        title: '消息',
        message: '已下单，将尽快发货',
        showClose: false
      });
    },
    async ordersSave() {
      console.log('api')
      const json = JSON.stringify(this.order);
      const {data: res} = await ordersSaveAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        console.log("订单创建成功");
        console.log(res);
        await this.ordersFindCid();
      } else {
        this.$message.error(res.msg)
      }
      console.log("结束")
    },
    async ordersFindCid() {
      console.log('findcid')
      const json = JSON.stringify(this.order);
      const {data: res} = await ordersFindCidAPI(json);
      console.log("开始");
      if (res.code === '00000') {
        console.log("订单获取成功");
        console.log(res);
        console.log(res.data.records.length);
        this.detail.oid = JSON.parse(res.data.records[res.data.records.length - 1].oid)
      } else {
        this.$message.warning("查询失败，未找到相应结果");
      }
      console.log("订单获取结束");
      await this.detailOrdersSave();
    },
    async detailOrdersSave() {
      const json = JSON.stringify(this.detail);
      const {data: res} = await detailOrdersSaveAPI(json);
      console.log("详细信息开始开始");
      if (res.code === '00000') {
        console.log("详细订单信息创建成功");
        console.log(res);
      } else {
        this.$message.error(res.msg)
      }
      console.log("结束")
    }
  },
  watch: {
    num: {
      handler(neaVal) {
        console.log("num变化")
        this.total = this.gprice * this.num;
      },
      deep: true
    }
  },
  created(){
    this.getGoodsList();
    this.user = JSON.parse(localStorage.getItem('user'))
  }
}
</script>

<style scoped>
.bottom clearfix {
  position: static;
}

.van-goods-action {
  position: relative;
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
</style>
