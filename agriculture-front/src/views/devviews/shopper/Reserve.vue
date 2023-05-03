<template>
  <div class="user-container">
    <div style="margin: 10px 0">
      <el-input style="width: 200px" placeholder="请输入景点名称" suffix-icon="el-icon-search" v-model="sname"></el-input>
      <el-button class="ml-5" type="primary" @click="query">搜索</el-button>
      <el-button type="warning" @click="reset">重置</el-button>
    </div>

    <el-table
      :data="orders"
      v-loading="loading"
    >
      <el-table-column
        type="index"
        label="序号"
        width="110">
      </el-table-column>
      <el-table-column
        prop="uid"
        label="用户编号"
        width="110">
      </el-table-column>
      <el-table-column
        prop="uname"
        label="昵称"
        width="150">
      </el-table-column>
      <el-table-column
        prop="uaddress"
        label="地址"
        width="260">
      </el-table-column>
      <el-table-column
        prop="utel"
        label="电话"
        width="150"
      >
      </el-table-column>
      <el-table-column
        prop="udesp"
        label="简介"
        width="300"
      ></el-table-column>
      <el-table-column prop="uimg" label="图片"  width="200">
        <!-- 图片的显示 -->
        <template   slot-scope="scope">
          <img :src="scope.row.surl"   height="150" />
        </template>
      </el-table-column>
      <el-table-column
        prop="sdate"
        label="日期"
        width="150"
      ></el-table-column>
      <el-table-column
        prop="usex"
        label="性别"
        width="150"
      ></el-table-column>
      <el-table-column
        prop="state"
        label="状态"
        width="200"
      >
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.sstate === 1 ? 'danger' : 'success'"
            v-if="scope.row.sstate === 1"
            disable-transitions>关闭</el-tag>
          <el-tag
            :type="scope.row.sstate === 1? 'danger' : 'success'"
            v-else
            disable-transitions>开放</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="240px">

        <template slot-scope="scope">
          <el-button type="success" @click="handleEdit(scope.row)">编辑 <i class="el-icon-edit"></i></el-button>
          <el-popconfirm
            class="ml-5"
            confirm-button-text='确定'
            cancel-button-text='我再想想'
            icon="el-icon-info"
            icon-color="red"
            title="您确定删除吗？"
            @confirm="deleteScenery(scope.$index, scope.row)"
          >
            <el-button type="danger" slot="reference">删除 <i class="el-icon-remove-outline"></i></el-button>
          </el-popconfirm>

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

  </div>
</template>

<script>
import {
  articleSaveorModifyAPI,
  deleteSceneryAPI,
  findUserAllAPI, modifyUserAPI,
  sceneryAllAPI,
  sceneryLikeNameAPI
} from "../../../api";

export default {
  data() {
    return {
      dialogFormVisible:false,
      visible: false,
      loading:false,
      activeName: '1',
      sname:'',
      orders:[],
      articlePage:{
        page: 1,
        size:4,
        total:0,
        uid:JSON.parse(localStorage.getItem('user')).uid
      }
    }
  },
  methods:{
    async handleEdit(row){
      this.orders = JSON.parse(JSON.stringify(row))
      this.dialogFormVisible = true
    },
    reset(){
      this.sname = ""
    },
    async query(){
      this.articlePage.sname=this.sname
      console.log(this.sname)
      const {data: res} = await sceneryLikeNameAPI(this.articlePage)
      if (res.code === '00000') {
        this.orders = res.data.records;
        this.articlePage.total = res.data.total;
        this.$message.success("查询成功")
        // this.$router.go(0);
      }
      else{
        this.$message.error("没有和其有关的景点名称")
      }
    },
    async saveormodify(){
      this.orders.uid=JSON.parse(localStorage.getItem('user')).uid;
      const {data: res} = await modifyUserAPI(this.orders)
      if (res.code === '00000') {
        this.$message.success("成功")
        this.$router.go(0);
      }
      else{
        this.$message.error("失败")
      }
    },
    handleAdd() {
      this.dialogFormVisible = true
      this.orders = {}
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.articlePage.size=val;
      this.getOrders();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.articlePage.page=val;
      this.getOrders();
    },
    async deleteScenery(index,row){
      const {data: res} = await deleteSceneryAPI(row.sid)
      console.log(res)
      alert("删除成功！")
      this.$router.go(0);
    },
    async getOrders() {
      const json = JSON.stringify(this.articlePage);
      const {data: res} = await findUserAllAPI();
      // sceneryAllAPI(json);
      console.log(res)
      if (res.code === '00000') {
        this.orders = res.data;
        // this.articlePage.total = res.data.total;
        this.$message.success("获取用户信息成功")
      }
      else{
        this.$message.error("获取用户信息失败")
      }
    }
  },
  created() {
    this.getOrders()
  },
}
</script>

<style scoped>

</style>
