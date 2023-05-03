<template>
  <div class="homeleft-container">
    <div class="newstitle">
      <van-dropdown-menu style="width: 20%">
        <van-dropdown-item  :title="title" v-model="choiceValue" :options="option"  @change="chooseachoice"/>
        <van-dropdown-item  title="筛选" ref="item">
          <van-cell center title="最新榜">
            <template #right-icon  >
              <van-switch v-model="switch1" size="24" active-color="#ee0a24"  @change="changeStatus($event)" />
            </template>
          </van-cell>
          <van-cell center title="最热榜">
            <template #right-icon>
              <van-switch v-model="switch2" size="24" active-color="#ee0a24" @change="changeStatus1($event)"/>
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



          <div class="zhengwen"> <el-tag type="warning" >正文</el-tag>{{item.content}}</div>
        </div>
        <div class="itemrate">
          <el-rate
            v-model="item.score"
            show-score
            text-color="#ff9900"
            score-template="{value}">
          </el-rate>
          <p style="position: relative;top: -60px;left:160px">
            <span class="date"><i class="el-icon-date">{{item.create_time| dateFormat}}</i></span>
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
      </div>
    </el-card>

  </div>

</template>

<script>
import {ArticleUserAPI,articleTypeAPI,articleOrderbytime,articleOrderbyscore} from "../../../api";
import dayjs from 'dayjs'
export default {
  name:'HomeLeft',
  data() {
    return {
      title:"文章",
      choice:'',
      choiceValue:'',
      news:[],
      articlePage:{
        page: 1,
        size:4,
        total:100,
        type:0
      },
      value: 0,
      switch1: false,
      switch2: false,
      option: [
        { text: '全部文章', value:'0' },
        { text: '农产品销售', value: '1' },
        { text: '旅游分享', value: '2'},
        { text: '农产品种植技巧', value: '3' },
        { text: '民族风俗', value: '4' },
      ],
      // currentPage4: 4
    }
  },
  methods:{
    chooseachoice(i){
      this.title = this.option[i].text;
      this.choiceValue = i;
      this.choices(i)
      console.log(i)
    },
    // 开关事件
    changeStatus(e){
      console.log(e) //e返回状态，row当前行数据，index下标
      this.changes(e);
    },
    async changes(e){
      console.log(e)
      if(e===true){
        console.log("看：",this.articlePage.type)
        const json = JSON.stringify(this.articlePage);
        const {data: res} = await articleOrderbytime(json);
        console.log(res);
        console.log("开始");
        if (res.code === '00000') {
          console.log("文章获取成功");
          this.news = res.data.records;
          console.log(res.data.records);
          // news.create_time=dayjs(es.data.records[0]);
          this.articlePage.total = res.data.total;
        } else {
          this.$message.error(res.msg)
        }
        console.log("结束")
      }
      // else{
      //   this.getarticleList();
      // }
    },

    changeStatus1(e){
      console.log(e);
      this.changes1(e);
    },
    async changes1(e){
      console.log(e)
      if(e===true){
        console.log("看：",this.articlePage.type)
        const json = JSON.stringify(this.articlePage);
        const {data: res} = await articleOrderbyscore(json);
        console.log(res);
        console.log("开始");
        if (res.code === '00000') {
          console.log("文章获取成功");
          this.news = res.data.records;
          console.log(res.data.records);
          // news.create_time=dayjs(es.data.records[0]);
          this.articlePage.total = res.data.total;
        } else {
          this.$message.error(res.msg)
        }
        console.log("结束")
      }
      // else{
      //   this.getarticleList();
      // }
    },
    async choices(i) {
      // this.choice = this.option[i].text;
      console.log(i)
      if(i===1){
        console.log(i)
        this.getarticleList()
      }
      else {
        this.articlePage.type = i - 1;
        console.log("看：",this.articlePage.type)
        const json = JSON.stringify(this.articlePage);
        const {data: res} = await articleTypeAPI(json);
        console.log(res);
        console.log("开始");
        if (res.code === '00000') {
          console.log("文章获取成功");
          this.news = res.data.records;
          console.log(res.data.records);
          // news.create_time=dayjs(es.data.records[0]);
          this.articlePage.total = res.data.total;
        } else {
          this.$message.error(res.msg)
        }
        console.log("结束")
      }
    },



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
        // news.create_time=dayjs(es.data.records[0]);
        this.articlePage.total=res.data.total;
      }else {
        this.$message.error(res.msg)
      }
      console.log("结束")
    },

    },
  filters: {
    dateFormat(time) {
      //对time进行格式化处理 ，得到YYYY-MM-DD HH:mm:ss
      //  把格式化的结果，return出去
      //  直接调用dayjs()得到的是当前的时间
      //  dayjs（给定的日期时间）得到指定的时间
      //  只要导入了dayjs 的库文件，在window全局，就可以使用dayjs()方法
      const dstr = dayjs(time).format("YYYY-MM-DD HH:mm:ss")
      return dstr
    }
  },
  created(){
    console.log("jinlaile")
    this.getarticleList()
  }
}
</script>
<style scoped>
/deep/ .van-popup--top {
  top: 0;
  left: 210px;
  /*width: 100%;*/
  padding-right: 19.9px;
}

.zhengwen{
  /*width: 715px; !* (一定要加宽度）*!*/
  text-overflow: ellipsis; /* 溢出用省略号 */
  white-space: nowrap; /*溢出不换行 */
  -webkit-line-clamp: 1;  /*控制显示的行数 */
  -webkit-box-orient:vertical;
  overflow:hidden; /*超出的文本隐藏 */
}
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
  margin-top: -95px;
}
.itemrate {
  position: static;
  margin-top: -30px;
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
