<template>
  <div class="articleContent">
    <div class="back">
      <i class="el-icon-d-arrow-left" style="font-size: 25px;color: #999999;" @click="backgame"></i>
      <span style="font-size: 22px;color:#e0dddd;" >返回</span>
    </div>
    <div class="title">
        {{news.title}}
    </div>
    <div class="uname">
      <p>作者:{{news.uname}}</p>
    </div>
    <div class="info">
      <div class="type">
        <el-tag>类型</el-tag>
        {{news.type}}
      </div>
      <div class="score">
        <el-tag>评分</el-tag>
        {{news.score}}
      </div>
      <div class="createTime" >
        <el-tag>创建时间</el-tag>
        {{news.createTime}}
      </div>
      <div class="updateTime">
        <el-tag>更新时间</el-tag>
        {{news.updateTime}}
      </div>
    </div>
    <hr>
    <div class="summary" >
      <p type="success">摘要:{{news.summary}}</p>
    </div>

    <div class="img">
      <el-image style="width:auto; height: 700px;padding: 10px 200px ;"
                :src="news.img">
      </el-image>
    </div>
    <hr>
    <div class="content" >
      <div class="el-icon-s-operation" >正文</div>
      <p style = "white-space: pre-wrap"> {{news.content}}</p>
    </div>
  </div>
</template>

<script>
import {articleDetailAPI} from "../../../api";

export default {
  name: "ArticleDetail",
  data() {
    return {
      id:1,
      news: {},
   }
  },
  methods:{
    backgame(){
      localStorage.removeItem('articleDetailId')
      this.$router.push('/front/game')
    },
    async getArticleDetail(id){
      const {data: res} = await articleDetailAPI(id);
      console.log(res);
      console.log("开始");
      if (res.code==='00000'){
        console.log("文章获取成功");
        this.news=res.data;
        console.log(res.data);
      }else {
        this.$message.error(res.msg)
      }
      console.log("结束")
    }
  },
  created(){
    this.id=localStorage.getItem("articleDetailId")
    this.getArticleDetail(this.id);
  }
}
</script>

<style scoped>
.articleContent{
  margin:10px 100px;
  /*border:5px #d9d6d6 solid ;*/
  /*border: 7mm ridge rgba(97, 111, 145, 0.7);/*/
  /*border: thick  double #32a1ce;*/
  padding: 10px;
}
.title{
  text-align: center;
  font-size: 50px;
}
.uname{
  margin:0 30% 0 50%;
}
.type,.score,.updateTime,.createTime{
  display: inline;
  margin:10px 20px;
}
.info{
  text-align: center;
}
.summary p,.content p{
  line-height: 200%;
}
.content div{
  font-size: 30px;
  color:#7fb2ec;
}
</style>
