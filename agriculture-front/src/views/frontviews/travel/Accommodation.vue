<template>
  <div class="articleContent">
    <div class="back">
      <i class="el-icon-d-arrow-left" style="font-size: 25px;color: #999999;" @click="backgame"></i>
      <span style="font-size: 22px;color:#e0dddd;" >返回</span>

    </div>
    <div class="title">
      住宿攻略
    </div>
    <div class="uname">
      <p>@悦享滇韵</p>
    </div>
    <hr>
    <div class="summary" >
      <p type="success"><span style="font-weight: bold;color: #055dad ;"> 云南</span>常年气候温和，土地肥沃，以秀丽山水和少数民族风情闻名于世七彩云南，彩云之南。一座座山峰耸立，一片片森林凝翠，一朵朵鲜花怒放，一条条飞瀑流泉。云南的风情如一朵彩云追赶着另一朵彩云，一份情怀撞击着另一份情怀；云南的颜色如一道赤橙黄绿青蓝紫的长虹，彰示着五彩缤纷的灵气，流淌着千姿百态的动感。</p>
    </div>

    <div class="img">
      <el-image style="width:auto; height: 700px;padding: 10px 350px ;"
                :src="news.srcList[3]"
                :preview-src-list="news.srcList">
      </el-image>
    </div>
    <hr>
    <div class="content" >
      <div class="el-icon-s-operation" >攻略</div>
      <div class="paragraph">
        <div class="little-title">一.昆明 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content1}}</p>
      </div>

      <div class="paragraph">
        <div class="little-title">二.大理 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content2}}</p>
      </div>

      <div class="img">
        <el-image style="width:auto; height: 700px;padding: 10px 350px ;"
                  :src="news.srcList[2]"
                  :preview-src-list="news.srcList">
        </el-image>
      </div>

      <div class="paragraph">
        <div class="little-title">三.丽江 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content3}}</p>
      </div>

      <div class="paragraph">
        <div class="little-title">四.泸沽湖 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content4}}</p>
      </div>

      <div class="paragraph">
        <div class="little-title">五.香格里拉 </div>
        <p class="content1" style = "white-space: pre-wrap">{{news.content5}}</p>
      </div>







    </div>
  </div>
</template>

<script>
export default {
  name: "Accommodation",
  data() {
    return {
      news: {
        content1: '昆明毕竟是省会，住宿很方便，高档酒店，快捷酒店，青年旅社都有，推荐几个住宿片区，以考虑离除火车站、长途汽车站、机场较近的地方，还可以选择金马坊，翠湖，官渡古镇片区。',
        content2:'大理的住宿其实也是跟好玩的地儿紧密联系的，有大家都知道的古城、双廊、才村，也有略微小众的环海西路（海西）、环海东路（海东）、金梭岛、喜洲等地方，其中古城、双廊、喜洲、才村本身就是第一次来大理的必到之地，住这里应该可以省去不少奔波的劳心。\n' +
          '（1）如果是以玩为主，那么推荐住古城或双廊，毕竟旅游发展，不管去哪里的交通都会相对方便。\n' +
          '（2）如果是以住为主，那么就推荐金梭岛、海西、海东的民宿，因为这些地方往往都没什么游客，很比较安静，可以心无挂念地欣赏洱海，缺点是周边没什么景点。',
        content3:'丽江主要有大研和束河两个古镇。客栈的数量可以用“巨多”来形容，价位几十到几百不等，方圆3.5公里的大研古镇散布了一千四五百家的大小客栈，而相对安静，还未被完全开发的束河也有数百家客栈。\n' +
          '（1）如果您在旅游旺季(春节、五一、十一长假)打算前往丽江旅行，一定要在出发前预定好房间。\n' +
          '（2）如果您选择的是纳西人的客栈，请尊重主人的民族习惯；如果您住的是家庭客栈，也请体谅主人的辛苦，尽量保持环境的卫生，晚上不要在外面逗留太晚。\n' +
          '（3）选择有单独庭院、有公共活动空间的客栈入住。这样的客栈空间宽敞，住在里面不觉得压抑，客房之间的相互影响较小。\n' +
          '（4）假如你的行程是5天，没必要一次交给客栈5天的房钱，不妨先交两天，感受一下，安顿下来后，可以边玩边看，或许会有更适合你的客栈——参观风格各异的客栈，本身也是一种享受。假如一开始住下的客栈不尽人意，两天后就可以退房走人。',
        content4:'泸沽湖的住宿主要分三个区域：大落水、里格、尼塞。\n' +
          '（1）大落水村开发较早，是泸沽湖交通的中心，宿选择更多，条件更好，沿湖的海景房比比皆是，吃饭购物也要便宜一些。\n' +
          '（2）里格的住宿房间面向泸沽湖，没有遮挡物，视野开阔，价格相对贵一些，里格半岛的住宿贵而且不一定能订到房。\n' +
          '（4）尼塞村的村子小人口少，比较安静，适合喜欢原生态、晚上也不需要热闹夜生活（酒吧、篝火会），就想纯粹感受世外桃源的朋友。',
        content5:'香格里拉住宿地点多在独克宗古城区，旅馆多为民居式客栈，价位在100-300元不等，环境很好也很有特色，县城内团结路、北门街一带也是旅馆集中区域。\n' +
          '著名的五星级酒店有天界神川大酒店、香格里拉大酒店。四星级酒店有扎西德勒酒店等。三星级和二星级酒店数量更多，可以说在香格里拉住宿问题是不用担心的。',
        img:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        srcList: ['https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg','https://p1-q.mafengwo.net/s16/M00/BF/21/CoUBUmEuN4WAQpEBABmrddaOMac200.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90','https://p1-q.mafengwo.net/s16/M00/BF/40/CoUBUmEuN8qAaTXiADTR163bpk4906.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90','https://p1-q.mafengwo.net/s16/M00/BF/38/CoUBUmEuN7OAZoqOABXLo0Rl8cw563.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90'],
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






















