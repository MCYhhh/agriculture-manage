<template>
  <div class="articleList">
    <el-card class="card" shadow="hover" v-for="item in news">
      <el-button class="button" round>点击了解</el-button>
      <el-image style="width:200px; height: 200px;" class="img" alt="图片"
                :src="item.img"
                :preview-src-list="item.srcList" >
      </el-image>
      <div class="text">
        <div class="article">
          <p class="title">{{item.title}} </p>
          <p class="uname">作者:{{item.uname}}</p>
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
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage1"
        :page-sizes="[25, 50, 75, 100]"
        :page-size="25"
        layout="total, sizes, prev, pager, next, jumper"
        :total="100">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "ArticleLIst",
  data(){
    return {
      news:[
        {
          id:1,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'大厦公园',
          type:'娱乐',
          summary:'多走走多看看，最近的恻然封',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-03-19',
          uid:1,
          uname:'小星星'
        },
        {
          id:3,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'樱花公园',
          type:'游记',
          summary:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 4.2,
          create_time:'2022-02-19',
          uid:1,
          uname:'似水流年'
        },
        {
          id:4,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'香山公园',
          type:'游记',
          summary:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-01-19',
          uid:1,
          uname:'畅游世界'
        },
        {
          id:1,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'大厦公园',
          type:'娱乐',
          summary:'多走走多看看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-03-19',
          uid:1,
          uname:'小星星'
        },
        {
          id:2,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'漫山公园',
          type:'游记',
          summary:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 2.1,
          create_time:'2022-02-09',
          uid:1,
          uname:'星月银河'
        },
        {
          id:3,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'樱花公园',
          type:'游记',
          summary:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 4.2,
          create_time:'2022-02-19',
          uid:1,
          uname:'似水流年'
        },
        {
          id:4,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'香山公园',
          type:'游记',
          summary:'好好看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-01-19',
          uid:1,
          uname:'畅游世界'
        },
        {
          id:1,
          img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          title:'大厦公园',
          type:'娱乐',
          summary:'多走走多看看',
          content:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-03-19',
          uid:1,
          uname:'小星星'
        }
      ],
      currentPage4: 1,
    }
  },
  methods:{
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
  },
  mounted() {
  }
}
</script>

<style scoped>
.articleList{
  position: static;
}
.img{
  float: left;
  margin:auto 5px;
}
.article p{
  display: inline;
  margin-right: 5px;
}
.score,.type,.createTime{
  display: inline;
  margin-right: 20px;
}
.info{
  margin:  10px auto;
}
.title{
  font-size: 25px;
}
.summary{
  font-size: 20px;
  margin-top: 10px;
}
.text{
  padding-left: 20px;
  float: left;
  height: 200px;
}
.card{
  float: left;
  margin: 15px;
  width: 750px;
  height: 240px;
  background: #d0caca;
  position: static;
}
.button{
  position: relative;
  top: 0;
  right: 0;
  font-size: 20px;
  color: white;
  background: #7fb2ec;
}
.block{
  position: absolute;
  bottom:-580px;
  right: 600px;
  margin-bottom: 20px;
}
</style>
