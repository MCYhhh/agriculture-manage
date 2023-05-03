<template>
  <div class="articleContent">
    <div class="back" @click="backgame">
      <i class="el-icon-d-arrow-left" style="font-size: 25px;color: #999999;" ></i>
      <span style="font-size: 22px;color:#e0dddd;" >返回</span>
    </div>
    <div class="title">
      {{news.site}}
    </div>
    <div class="uname">
      <p style="color: green">{{news.uname}}</p>
    </div>

    <hr>
    <div class="summary" >
      <p type="success" style="font-size: 20px;margin-left: 180px;">摘要:{{news.abstarct}}</p>
    </div>

    <div class="img">
      <img style="width:auto; height: 700px;padding: 10px 300px ;"
                :src="news.srcList[0]">
    </div>
    <hr>
    <div class="content" >
      <div class="el-icon-s-operation" >正文</div>
      <div>
      <img style="width:auto; height: 700px;padding: 10px 300px ;"
                :src="news.srcList[1]">
      </div>
      <p style = "white-space: pre-wrap;font-size: 18px"> {{news.content}}</p>
    </div>
  </div>

</template>
<script>

export default {
name: "Detail",
    data() {
    return {
    news: {},
    }
    },
    methods:{
    backgame(){
    localStorage.removeItem('item')
    this.$router.push('/front/ethnic')
    },
    },
    created(){
    console.log(localStorage.getItem('item'))
      console.log(typeof localStorage.getItem('item'))
    this.news=JSON.parse(localStorage.getItem('item'))
      console.log(this.news)
    // this.getArticleDetail(this.id);
    }
    }
    </script>

    <style scoped>
    .articleContent{
      margin:10px 100px;
      padding: 10px;
    }
    .title{
      text-align: center;
      font-size: 30px;
      font-weight: bold;
    }
    .uname{
      margin:0 30% 0 58%;
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


