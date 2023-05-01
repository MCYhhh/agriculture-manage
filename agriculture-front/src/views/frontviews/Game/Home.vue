<template>
  <div class="articleList">
    <el-card class="card" shadow="hover" v-for="item in news" >
      <el-button type="primary" class="button" @click="getArticleDetail(item.id)">点击了解</el-button>
      <el-image style="width:200px; height: 200px;" class="img" alt="图片"
                :src="item.img"
                :preview-src-list="item.srcList">
        {{item.img}}
      </el-image>
      <div class="text">
        <div class="article">
          <p class="title">{{item.title}} </p>
          <!--          <p class="uname">作者:{{item.uname}}</p>-->
        </div>
        <div class="info">
          <p class="type">
            <el-tag>类型</el-tag>
            {{item.type}}
          </p>
          <p class="score">
            <el-tag>评分</el-tag>
            {{item.score}}
          </p>
          <p class="createTime" >
            <el-tag>创建时间</el-tag>
            {{item.create_time}}
          </p>
        </div>
        <div class="summary" >
          <p type="success">摘要:{{item.summary}}</p>
        </div>
      </div>
    </el-card>
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
import {articleAPI} from "../../../api";
export default {
  name: "ArticleLIst",
  data(){
    return {
      news:[],
      articlePage:{
        page: 1,
        size:4,
        total:0,
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
    getArticleDetail(id){
      console.log(id);
      localStorage.setItem("articleDetailId",id)
      this.$router.push("/front/game/detail")
    },
   async getarticleList() {
     const json = JSON.stringify(this.articlePage);
     const {data: res} = await articleAPI(json);
     console.log(res);
     console.log("开始");
     if (res.code==='00000'){
       console.log("文章获取成功");
       this.news=res.data.records;
       console.log(res.data.records[0].img);
       this.articlePage.total=res.data.total;
     }else {
       this.$message.error(res.msg)
     }
     console.log("结束")
   }
  },
  created() {
    this.getarticleList()
  },
}
</script>

<style scoped>
.articleList{
  /*position: static;*/
  margin-left: 160px;
}
.img{
  float: left;
  margin:auto 5px;
}
.article p{
  margin-right: 5px;
  display: inline;
}
.score,.type,.createTime{
  display: inline;
  margin-right: 20px;
}
.info{
  margin:  10px auto ;
}
.title{
  font-size: 25px;
}
.summary{
  font-size: 20px;
  margin:  10px auto ;
}
.text{
  padding-bottom: 5px;
  padding-left: 20px;
  float: left;
  height: 300px;
}
.card{
  display: inline-block;
  margin: 15px;
  width: 40%;
  height:290px;
  background: #e4eeee;
}
.button{
  /*top: 10px;*/
  /*right: 50px;*/
  /*right: 10px;*/
  top:25px;
  margin-left: 400px;
  position: relative;
  font-size: 15px;
  color: white;
  background: #7fb2ec;
}
el-pagination{
  display: block;
}

</style>
