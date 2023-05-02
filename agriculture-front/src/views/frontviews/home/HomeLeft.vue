<template>
  <div class="homeleft-container">
    <div class="newstitle">
      <van-dropdown-menu style="width: 20%">
        <van-dropdown-item v-model="value" :options="option" />
        <van-dropdown-item title="筛选" ref="item" >
          <van-cell center title="最新榜">
            <template #right-icon>
              <van-switch v-model="switch1" size="24" active-color="#ee0a24" />
            </template>
          </van-cell>
          <van-cell center title="最热榜">
            <template #right-icon>
              <van-switch v-model="switch2" size="24" active-color="#ee0a24" />
            </template>
          </van-cell>
          <div style="padding: 5px 16px;">
            <van-button type="danger" block round @click="onConfirm">
              确认
            </van-button>
          </div>
        </van-dropdown-item>
      </van-dropdown-menu>
    </div>
    <el-card style="width: 60%;">
      <div class="demo-image__preview" v-for="(item,index) in news" :key="item.id">
        <el-image
          style="width: 100px; height: 100px;margin-bottom: -40px;padding-top: 10px"
          :src="item.url"
          :preview-src-list="item.srcList"
        >
        </el-image>
        <div class="content">
          <p>
            <span>{{item.title}}</span>
            <el-divider direction="vertical"></el-divider>
            <span>{{item.type}}</span>
          </p>
          <p >
            <el-tag>摘要</el-tag>
            {{item.summary}}
          </p>
          <p >
            <el-tag type="warning">正文</el-tag>
            {{item.content}}
          </p>
        </div>
        <div class="itemrate">
          <el-rate
            v-model="item.score"
            show-score
            text-color="#ff9900"
            score-template="{value}">
          </el-rate>
          <p style="position: relative;top: -60px;left:160px">
            <span class="date"><i class="el-icon-date">{{item.create_time}}</i></span>
            <el-link type="success">@{{item.uname}}</el-link>
          </p>
<!--          <span>@{{item.uname}}</span>-->
          <el-button type="primary" class="browse" @click="detail(item.id)">查看详情</el-button>
        </div>
        <el-divider class="divide"></el-divider>
      </div>
      <div class="block">
        <el-pagination
          @size-change="handleSize"
          @current-change="handleCurrent"
          :current-page="articlePage.page"
          :page-sizes="[2,4,6,8,10,20]"
          :page-size="articlePage.size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="articlePage.total">
          <!--          style="text-align: center;display: block;bottom: 200px;">-->
        </el-pagination>
<!--        <el-pagination-->
<!--          @size-change="handleSizeChange"-->
<!--          @current-change="handleCurrentChange"-->
<!--          :current-page="currentPage4"-->
<!--          :page-sizes="[100, 200, 300, 400]"-->
<!--          :page-size="100"-->
<!--          layout="total, sizes, prev, pager, next, jumper"-->
<!--          :total="400">-->
<!--        </el-pagination>-->
      </div>
    </el-card>

  </div>

</template>

<script>
import {articleAPI} from "../../../api";
import {ArticleUserAPI} from "../../../api";
export default {
  name:'HomeLeft',
  data() {
    return {
      // dialogFormVisible: false,
      news:[],
      articlePage:{
        page: 1,
        size:4,
        total:100,
      },
      value: 0,
      switch1: false,
      switch2: false,
      option: [
        { text: '全部文章', value: 0 },
        { text: '娱乐趣谈', value: 1 },
        { text: '游记探寻', value: 2 },
      ],
      // currentPage4: 4
    }
  },
  methods:{
    detail(id){
      console.log(id);
      localStorage.setItem("articleDetailId",id)
      this.$router.push("/front/game/detail")
    },
    onConfirm() {
      this.$refs.item.toggle();
    },
    handleSize(val) {
      console.log(`每页 ${val} 条`);
      this.articlePage.size=val;
      this.getarticleList();
    },
    handleCurrent(val) {
      console.log(`当前页: ${val}`);
      this.articlePage.page=val;
      this.getarticleList();
    },
    async getarticleList() {
      const json = JSON.stringify(this.articlePage);
      const {data: res} = await ArticleUserAPI(json);
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
    },

  },
  created(){
    console.log("jinlaile")
    this.getarticleList()
  }
}
</script>
<style scoped>
.homeleft-container{
  margin:-150px 0 0 180px;
  width: 2000px;
}
.content{
  position: relative;
  left: 120px;
  top:-75px;
  width: 75%;
}
span{
  font-weight: bold;
}
/deep/ .van-popup--top{
  width: 20%;
}
.divide{
  margin-top: -85px;
}
.itemrate {
  position: static;
  margin-top: -50px;
}
.itemrate .el-rate{
  position: relative;
  top:-25px
}
.itemrate .browse{
  position: relative;
  top:-105px;
  left:380px
}

</style>
