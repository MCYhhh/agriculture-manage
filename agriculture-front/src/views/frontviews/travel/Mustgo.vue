<nav></nav>
<template>
  <div class="mustgo">
    <el-card class="card" shadow="hover" v-for="item in scenerys">
      <div class="scenery">
        <div class="sname">
          <p class="title">{{item.sname}} </p>
        </div>
        <el-button type="primary" class="button" @click="getDetail">点击了解</el-button>
        <div class="info">
          <p class="saddress">
            地址:{{item.saddress}}
          </p>
          <p class="sprice">
            类型:{{item.sprice}}
          </p>
          <p class="sdate" >
            更新时间:{{item.sdate}}
          </p>
          <p class="state" v-if="item.sstate===0">
            是否开放：是
          </p>
          <p class="state" v-else>
            是否开放：否
          </p>
        </div>
        <div class="sdesp">
          <p>描述:{{item.sdesp}}</p>
        </div>
      </div>
      <el-image style="width:300px; height: 300px;top: 0" class="img" alt="图片"
                :src="item.surl"
                :preview-src-list="item.srcList" >
      </el-image>
    </el-card>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="aPage.page"
        :page-sizes="[5,10,15,20,50]"
        :page-size="aPage.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="aPage.total"
        style="text-align: center;display: block;bottom: 200px;">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import {sceneryAllAPI} from "../../../api";

export default {
  name: "mustgo",
  data(){
    return {
      scenerys:[],
      aPage:{
        page: 1,
        size:10,
        total:100,
      }
    }
  },
  methods:{
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
    getDetail(){
      this.$router.push('/front/game/detail')
    },
    async getList() {
      const json = JSON.stringify(this.aPage);
      const {data: res} = await sceneryAllAPI(json);
      console.log(res);
      console.log("开始");
      if (res.code==='00000'){
        console.log("景点获取成功");
        this.scenerys=res.data.records;
        console.log("this.scenerys"+this.scenerys[0]);
        this.aPage.total=res.data.total;
      }else {
        this.$message.error(res.msg)
      }
      console.log("结束")
    }
  },
  created() {
    this.getList()
  },
}
</script>

<style scoped>
.info p{
  display:inline-block;
  margin-right: 30px;
}
.scenery {
  width:70%;
  display: inline-block;
  position: static;
}
.sname{
  font-size: 40px;
}
.sdesp{
  font-size: 25px;
}
.card{
  margin: 10px auto;
  /*position: static;*/
  width: 80%;
  border-radius: 20px;
}
.el-card__body, .el-main{
  position: static;
}
.el-card__body{
  box-shadow: #999999 5px 6px;
}
.button{
  position: relative;
  top: -70px;
  left: 80%;
}
.img{
  float: right;
  top: 20px;
  right: 20px;
}
</style>
