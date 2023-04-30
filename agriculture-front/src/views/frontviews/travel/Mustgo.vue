<template>
  <div class="mustgo">
    <el-card class="card" shadow="hover" v-for="item in scenerys">
      <div class="scenery">
        <div class="sname">
          <p class="title">{{item.sname}} </p>
        </div>
        <el-button type="primary" class="button" @click="getSceneryDetail">点击了解</el-button>
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
        @current-change="sceneryPage.page"
        :current-page="sceneryPage.page"
        :page-sizes="[4, 8, 10, 16, 20]"
        :page-size="sceneryPage.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="sceneryPage.total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "mustgo",
  data(){
    return {
      scenerys:[
        {
          sid:1,
          sname:"黄花水长城",
          saddress:"北京市怀柔去黄花水长城",
          sprice:7.2,
          sdesp:"该地址有700年的历史，存在各种历史以及，现存完整。景点附近有各种客栈，提供住宿休息",
          surl:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          sstate:1,
          sdate:"2022-2-21",
          uid:1
        },
        {
          sid:1,
          sname:"黄花水长城",
          saddress:"北京市怀柔去黄花水长城",
          sprice:7.2,
          sdesp:"该地址有700年的历史，存在各种历史以及，现存完整。景点附近有各种客栈，提供住宿休息",
          surl:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          sstate:1,
          sdate:"2022-2-21",
          uid:1
        }
      ],
      sceneryPage:{
        page: 1,
        size:10,
        total:100,
      }
    }
  },
  methods:{
    getSceneryDetail(){
      this.$router.push("/front/home");
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
  }
}
</script>

<style scoped>
.info p{
  display:inline-block;
  margin-right: 100px;
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
.button{
  position: relative;
  top: -70px;
  left: 700px;
}
.img{
  float: right;
  top: 20px;
  right: 20px;
}
</style>
