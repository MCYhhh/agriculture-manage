<template>
  <div class="articleContent">
    <div class="back">
      <i class="el-icon-d-arrow-left" style="font-size: 25px;color: #999999;" @click="backgame"></i>
      <span style="font-size: 22px;color:#e0dddd;" >返回</span>

    </div>
    <div class="title">
<!--      <i class="l-icon-guide"></i>-->
      交通攻略
    </div>
    <div class="uname">
      <p>@悦享滇韵</p>
    </div>
    <hr>
    <div class="summary" >
      <p type="success"><span style="font-weight: bold;color: #055dad"> 云南</span>，一个最远的地方也是最近的地方，苍山洱海、玉龙雪山、泸沽湖、香格里拉、西双版纳...云南的美景让人心生神往。但是当你想真正踏足的时候，却不知道这么多的美景目的地该如何选择。如果你是第一次来云南旅游，推荐最经典的线路是：昆明—大理—丽江—泸沽湖—香格里拉。
        这条线路经典的经典比较多，比较集中，都是在一条线，每个地方都有机场，全国好多城市都有直飞的航班。交通也很方便，可以根据自己的时间随意搭配。</p>
    </div>

    <div class="img">
      <el-image style="width:auto; height: 700px;padding: 10px 350px ;"
                :src="news.img"
                :preview-src-list="news.srcList">
      </el-image>
    </div>
    <hr>
    <div class="content" >
      <div class="el-icon-s-operation" >攻略</div>
      <div class="paragraph">
      <div class="little-title">一.昆明长水机场——火车站（昆明站） </div>
      <p class="content1" style = "white-space: pre-wrap">{{news.content1}}</p>
      </div>

      <div class="paragraph">
        <div class="little-title">二.昆明——大理 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content2}}</p>
      </div>

      <div class="img">
        <el-image style="width:auto; height: 700px;padding: 10px 350px ;"
                  :src="news.srcList[1]"
                  :preview-src-list="news.srcList">
        </el-image>
      </div>

      <div class="paragraph">
        <div class="little-title">三.大理——丽江 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content3}}</p>
      </div>

      <div class="paragraph">
        <div class="little-title">四.丽江——泸沽湖 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content4}}</p>
      </div>

      <div class="paragraph">
        <div class="little-title">五.丽江——香格里拉 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content5}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Transport",
  data() {
    return {
      news: {
        content1: '（1）机场大巴专线919c线，票价13元；\n' +
          '（2）地铁6号线-东部汽车站转—3号线-东风广场站转——2号线-环城南路站，预计1.6小时；\n' +
          '（3）打车大约1小时，120元左右；\n' +
          '（4）昆明长途客运站有好几个：去版纳方向，要到南部汽车客运站坐，在新螺狮湾，在昆明的最南边！去大理方向，要到西部客运站，不是西北部客运站，一定不要弄混。',
        content2:'（1）火车：动车开通之后，两地之间只需要两个小时左右即可到达，从早上七点到晚上九点多班次很密集，二等座票价145元。\n' +
          '（2）大巴：绝大部分大巴需要5小时左右车程，可以在昆明西部汽车客运站坐大巴去大理，全程高速，票价80-140元。\n' +
          '（3）机场—大理古城：专线公交每天7：30起，按航班到达时间提供服务，直到当天航班全部结束。旅客可以在机场出站口右侧机场快线候车区乘车，上车购票即可，到下关火车站每人次15元，到 大理古城每人次30元',
        content3:'（1）火车：大理到丽江每天只有1班车，D8791（20:31-21:52），二等座票价52元；普通火车的班车比较多，硬座票价34元。\n' +
          '（2）大巴：每天7:10-19:00，大理汽车站、汽车北站滚动发车，差不多半个小时就会有一班车，票价50-80元不等。\n' +
          '（3）机场—丽江古城：专线公交从丽江三义国际机场（2号出站口）—丽江市区福慧路蓝天宾馆院内，根据航班到站时间滚动发车，最后一个航班落地后，民航班车收车，票价为20元/人。\n' +
          'Tips：没有直达古城，出了蓝天宾馆之后左转向前走两百米左右到达福慧市场公交站，坐11路公交车经过两站抵达古城口)',
        content4:'（1）大巴：丽江客运站每天上午有两趟、下午有一趟丽江到泸沽湖客运站（大落水）的大巴车，运行时间大概5个小时左右，价格七十左右。\n' +
          '（2）拼车：价格130—180元左右一位，客栈一般都会有拼车的业务，但建议一个人出行的不要跟陌生人拼车。\n' +
          '（3）包车：从丽江包车前往泸沽湖，需要确认车辆运营资质。根据车型不同，轿车400—600；商务车600—800。\n' +
          '（4）机场—泸沽湖：从泸沽湖机场返程的大巴车根据航班的起降情况同步调整，一般飞机降落后半小时出出发，可以到大落水。票价30元 ，路程大约1个小时。',
        content5:'（1）大巴：每天7:30－17:10之间，约45分钟会有一班车，旺季有加车。中巴车票价58元，大巴车票价63元。车程4个小时。\n' +
          '（2）包车：从丽江包车前往香格里拉，需要确认车辆运营资质。根据车型不同，轿车400—600；商务车600—800；\n' +
          '（3）机场—独克宗古城：目前没有机场大巴，只能坐出租车。距离不远，20分钟左右就到，30元左右。',
        img:'https://pic4.zhimg.com/v2-7b5cb1365840d17bf0119cff0c010f16_r.jpg',
        srcList: ['https://pic4.zhimg.com/v2-7b5cb1365840d17bf0119cff0c010f16_r.jpg','https://p1-q.mafengwo.net/s16/M00/BF/21/CoUBUmEuN4WAQpEBABmrddaOMac200.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90'],
      },
    }
  },
  methods:{
    backgame(){
      this.$router.push('/front/travel')
    }
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
  font-weight: bold;
}
.paragraph{
  margin-top: 25px;
  margin-left: 100px;
}
.little-title{
  font-size: 21px;
  font-weight: bold;
  color:black;
}
.uname{
  margin:0 30% 0 56%;
  color: green;
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
.summary p{
  font-size:20px ;
}
.el-icon-s-operation{
  font-size: 30px;
  color: #6096a8;
}
</style>
















