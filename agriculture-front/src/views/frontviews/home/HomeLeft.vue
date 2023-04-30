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
            <span>{{item.site}}</span>
            <el-divider direction="vertical"></el-divider>
            <span>{{item.type}}</span>
          </p>
          <p >
            <el-tag>摘要</el-tag>
            {{item.abstarct}}
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
          <el-button type="primary" class="browse">查看详情</el-button>
        </div>
        <el-divider class="divide"></el-divider>
      </div>
      <div class="block">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[100, 200, 300, 400]"
          :page-size="100"
          layout="total, sizes, prev, pager, next, jumper"
          :total="400">
        </el-pagination>
      </div>
    </el-card>

  </div>

</template>

<script>
export default {
  name:'HomeLeft',
  data() {
    return {
      dialogFormVisible: false,
      news:[
        {
          id:1,
          url:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          site:'大厦公园',
          type:'娱乐',
          abstarct:'多走走多看看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-03-19',
          uname:'小星星'
        },
        {
          id:2,
          url:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          site:'漫山公园',
          type:'游记',
          abstarct:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 2.1,
          create_time:'2022-02-09',
          uname:'星月银河'
        },
        {
          id:3,
          url:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          site:'樱花公园',
          type:'游记',
          abstarct:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 4.2,
          create_time:'2022-02-19',
          uname:'似水流年'
        },
        {
          id:4,
          url:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          site:'香山公园',
          type:'游记',
          abstarct:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-01-19',
          uname:'畅游世界'
        }
      ],
      value: 0,
      switch1: false,
      switch2: false,
      option: [
        { text: '全部文章', value: 0 },
        { text: '娱乐趣谈', value: 1 },
        { text: '游记探寻', value: 2 },
      ],
      currentPage4: 4
    }
  },
  methods:{
    onConfirm() {
      this.$refs.item.toggle();
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
    create(){
      console.log("创建创建文章")
    }
  },
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
