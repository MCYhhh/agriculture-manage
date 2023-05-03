<template>
  <div class="reserve-container">
    <el-table
      :data="reserves"
      v-loading="loading"
      style="width: 100%;text-align:center;margin-left: -10%;">
      <el-table-column
        type="index"
        label="序号"
        width="150%">
      </el-table-column>
      <el-table-column
        prop="rid"
        label="预约编号"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="sname"
        label="景点名称"
        width="150%">
      </el-table-column>
      <el-table-column
        prop="saddress"
        label="地址"
        width="250%">
      </el-table-column>
      <el-table-column
        prop="surl"
        label="图片"
        width="170%">
        <template slot-scope="scope">
          <img :src="scope.row.surl" width="100%" height="100%" alt="">
        </template>
      </el-table-column>
      <el-table-column
        prop="dnum"
        label="人数"
        width="70%">
      </el-table-column>
      <el-table-column
        prop="sprice"
        label="门票"
        width="70%">
      </el-table-column>
      <el-table-column
        prop="dtotal"
        label="共计"
        width="70%">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        label="游览日期"
        width="200%">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="预约时间"
        width="200%">
      </el-table-column>
    </el-table>
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
  reserveSceneryfindAllAPI,
} from "../../../api";

export default {
  name: "Reserve",
  reserves:[],
  data() {
    return {
      loading:false,
      activeName: '1',
      dialogFormVisible:false,  //控制支付弹框
      dialogDetailFormVisible:false,  //控制详情弹框
      reserves:[],
      aPage:{
        page: 1,
        size:10,
        cid:0,
        uid: JSON.parse(localStorage.getItem('user')).uid,
      }
    }
  },
  methods:{
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
    async getList() {
      const json = JSON.stringify(this.aPage);
      const {data: res} = await reserveSceneryfindAllAPI(json);
      console.log(res)
      if (res.code === '00000') {
        this.reserves = res.data.records;
        this.aPage.total = res.data.total;
        console.log(this.reserves)
        this.$message.success("获取全部预约信息成功")
      }
      else{
        this.$message.error("获取全部预约信息失败")
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
</style >
