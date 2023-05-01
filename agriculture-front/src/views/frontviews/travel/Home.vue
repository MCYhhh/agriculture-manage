<template>
<!--  <div class="travel-container">-->
<!--    <van-search v-model="value" placeholder="请输入搜索关键词" />-->
<!--  </div>-->
  <div class="scenery_container">
    <div class="map">
      <test></test>
    </div>
    <div  class="title" v-bind:style="{ fontWeight: 'bold' }">景区</div>
    <p style="margin-left: 350px">
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;"  @click="gomustgo()" >游玩必去</el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="ethnic()">民族风情</el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;">网红打卡</el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="transport()">交通指南</el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="accommodation()">住宿指南</el-button>
    </p>
    <div class="demo-image__placeholder" style="margin-left:110px;margin-bottom: 15px;margin-top: -5px">
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">大理黄龙潭</p></el-card>
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">大理网红拍照打卡</p></el-card>
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">傣家粽</p></el-card>
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">云泼水</p></el-card>
    </div>

    <el-card style="width: 80%;margin-left: 100px;">
      <div class="demo-image__preview" v-for="(item,index) in news" :key="item.id">
        <el-image
          style="width: 200px; margin-bottom: -40px;padding-top: 10px"
          :src="item.surl"
          :preview-src-list="item.srcList"
        >
        </el-image>
        <div class="content">
          <p>
            <span>{{item.sname}} </span>
            <el-button type="success" round style="margin-left:800px;margin-bottom: -10px"><span style="font-size: 15px">预约</span></el-button>
              <el-divider direction="horizon"></el-divider>
<!--          <span>{{item.type}}</span>-->
          </p>
          <hr>
          <p >
            <el-tag>地点</el-tag>
            {{item.saddress}}
          </p>
          <p >
            <el-tag type="warning">介绍</el-tag>
            {{item.sdesp}}
          </p>
        </div>
        <div class="itemrate">
<!--          <el-rate-->
<!--            v-model="item.score"-->
<!--            show-score-->
<!--            text-color="#ff9900"-->
<!--            score-template="{value}">-->
<!--          </el-rate>-->
          <p style="position: relative;top: -70px;left:160px;margin-bottom: 35px">
            <span class="date" >
              <van-icon name="clock-o" style="font-weight: lighter;font-size: 5px"/>
              <span style="font-size: 15px" >{{item.create_time}} </span>
               <el-link type="success" style="font-size: 16px;margin-left: 10px"> / 悦享滇韵</el-link>
            </span>
            <i class="el-icon-d-arrow-right" style="margin-left: 50px;"></i>
            <span style="font-size: 15px;color:green;">了解更多</span>

          </p>
          <!--          <span>@{{item.uname}}</span>-->

<!--          <el-button type="primary" class="browse">了解更多</el-button>-->
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


    <div class="reserveinfo" >
      <el-dialog title="填写预定信息" :visible.sync="dialogFormVisible" width="30%">
        <el-form>
          <el-form-item label="姓名" label-width="100px">
            <el-input  v-model="user1.uname" disabled></el-input>
          </el-form-item>
          <el-form-item label="用户昵称" label-width="100px">
            <el-input  v-model="user1.uname"></el-input>
          </el-form-item>
          <el-form-item label="性别" label-width="100px">
            <el-radio-group v-model="user1.usex">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="邮箱" label-width="100px">
            <el-input type="email" v-model="user1.uemail"></el-input>
          </el-form-item>
          <el-form-item label="手机号" label-width="100px">
            <el-input type="number" v-model="user1.utel"></el-input>
          </el-form-item>
          <el-form-item label="居住地" label-width="100px">
            <el-input v-model="user1.uaddress"></el-input>
          </el-form-item>
          <el-form-item label="备注" label-width="100px">
            <el-input v-model="user1.udesp"></el-input>
          </el-form-item>
          <el-form-item label="状态" label-width="100px">
            <el-input v-model="user1.state" disabled></el-input>
          </el-form-item>
          <el-form-item label="创建时间" label-width="100px">
            <el-input v-model="user1.create_time" disabled></el-input>
          </el-form-item>
          <el-form-item label="最近更新时间" label-width="100px">
            <el-input v-model="user1.update_time" disabled></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelinfo">取 消</el-button>
          <el-button type="primary" @click="confirminfo">确 定</el-button>
        </div>
      </el-dialog>
    </div>




  </div>

</template>

<script>
import test from "../../test";
export default {
  name: "Home",
  components: {test},
  data() {
    return {
      user1:{
        // uid:1,
        // uname:"孙雨彤"
      },
      reserve1:{
        // rid:1,
        // uid:user1.uid,
        // sid:'',

      },
      dialogFormVisible: false,
      news:[
        {
          id:1,
          surl:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          sname:'蝴蝶泉公园',
          type:'娱乐',
          saddress:'云南省大理白族自治州蝴蝶泉公园',
          sdesp:'大理三月好风光 蝴蝶泉边好梳妆,一曲《蝴蝶泉边》的美妙歌声响彻了中华大地，一部爱情电影《五朵金花》的故事传遍了全国，大理蝴蝶泉公园几近家喻户晓。蝴蝶泉公园,位于苍山云弄峰麓,原名“无底潭”，是国家AAA级旅游景区、国家重点风景名胜区、苍山世界地质公园。景区距大理古城25公里。景区内清泉甘凉、蝴蝶相容、绿树成荫、花团锦簇。',
          score: 3.7,
          create_time:'2022-03-19',
          // s:'小星星'
        },
        {
          id:2,
          surl:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          sname:'漫山公园',
          type:'游记',
          saddress:'好好看',
          sdesp:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 2.1,
          create_time:'2022-02-09',
          // uname:'星月银河'
        },
        {
          id:3,
          surl:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          sname:'樱花公园',
          type:'游记',
          saddress:'好好看',
          sdesp:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 4.2,
          create_time:'2022-02-19',
          // uname:'似水流年'
        },
        {
          id:4,
          surl:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
          srcList:['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'],
          site:'香山公园',
          type:'游记',
          saddress:'好好看',
          sdesp:'最近风沙肆虐，水源不足等灾害频频发生;气候离不开环境，环境也离不开气候，在这两者之间，人类却成了第三者。\n' +
            '随手关灯，是一种再普通不过的行为，然而10亿人在同一时间做同样的一件普通的事，人们心中激荡起强烈的情感共鸣，进而产生对人类命运和地球未来的共同关切。这样的举动，能否激起人类这个“第三者”对环保意识的觉醒?\n',
          score: 3.7,
          create_time:'2022-01-19',
          // uname:'畅游世界'
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
    gomustgo(){
       this.$router.push("/front/mustgo")
     },
   hot(){
      this.$router.push("/front/hot")
    },
    ethnic(){
      this.$router.push('/front/ethnic')
    },
    transport(){
      this.$router.push('/front/transport')
    },
    accommodation(){
      this.$router.push('/front/accomodation')
    },
    onConfirm() {
      this.$refs.item.toggle();
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
    // create(){
    //   console.log("创建文章")
    // },
    cancelinfo(){
      this.dialogFormVisible = false;
      console.log(this.user)
      console.log(this.user1)
    },
    confirminfo(){
      console.log(this.user.uname)
      this.dialogFormVisible = false;
      this.user=JSON.parse(JSON.stringify(this.user1));
    },
    modifyinfo(){
      this.user1=JSON.parse(JSON.stringify(this.user));
      this.dialogFormVisible = true
    }
  },
  created() {
    // this.user1=localStorage.getItem('user')
  }
}




</script>

<style scoped>
.frontimages{
  width:300px;
  height:260px;
  display: inline-block;
  background-color: #F6EEE8FF;
}
.description{
  font-size: 16px;
  color: #a9b5c0;
  text-align: center;
}
.map{
  margin-left: -300px;
  margin-top: 100px;
}
.fimages :hover{
  width: 270px;
  /*height: 260px;*/
}
.title{
  width: 77.2%;
  height:60px;
  /*font-family: "Helvetica Neue", Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;*/
  font-size: 22px;
  /*text-align:center;*/
  padding-left:40px;
  vertical-align: middle;
  line-height: 60px;
  color:white;
  background-color: #3d8ce3;
  margin-left: 100px;
  margin-top: -360px;
}

.scenery_container{
  margin:
    -0px 0 -180px 300px
}
.content{
  position: relative;
  /*left: 120px;*/
  /*top:-75px;*/
  left: 240px;
  top: -105px;
  width: 75%;
}
span{
  font-weight: bold;
  font-size: 18px;
}
/deep/ .van-popup--top{
  width: 20%;
}
.divide{
  margin-top: -85px;
}
.itemrate {
  position: static;
  margin-left: 700px;
  margin-top: -15px;
}
.itemrate .el-rate{
  position: relative;
  top:-25px
}
.itemrate .browse{
  position: relative;
  top:-105px;
  left:380px;
  /*color:red;*/
}
</style>
