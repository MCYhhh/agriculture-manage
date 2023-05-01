<template>
  <div class="articleContent" >
    <div class="back">
      <i class="el-icon-d-arrow-left" style="font-size: 25px;color: #999999;" @click="backgame"></i>
      <span style="font-size: 22px;color:#e0dddd;" >返回</span>
    </div>
    <div style="text-align: center;font-weight: bold;font-size: 28px ">------民俗民风------</div>
    <p class="images">
      <div style="width: 679px;display: inline-block;margin-left: 200px;">
      <transition name="el-zoom-in-top">
        <img class="big" src="../../../assets/images/yunnan7.jpg" v-show="show2">
      </transition>
      <p class="image1">元阳梯田</p>
  </div>
      <div class="group">
        <div>
      <transition  name="el-zoom-in-top">
        <img class="smalla" src="../../../assets/images/yunnan2.jpg" v-show="show2">
      </transition>
          <p class="image2">民族刺绣背衫</p>
        </div>

        <div>
      <transition   name="el-zoom-in-top">
        <img class="smalla" src="../../../assets/images/yunnan5.jpg" v-show="show2">
      </transition>
          <p class="image3">普洱茶田</p>
        </div>

      <transition   name="el-zoom-in-bottom">
        <img class="smallb"  src="../../../assets/images/yunnan1.jpg" v-show="show2">
      </transition>
      <transition  name="el-zoom-in-bottom">
        <img class="smallb" src="../../../assets/images/yunnan4.jpg" v-show="show2">
      </transition>
      </div>
<!--    <hr style="margin-top:40px ;margin-left: 500px">-->
    <el-divider></el-divider>
    <p style="text-align: center;margin-left: 500px;color:#070756;">神奇美丽的自然风光，绚丽多姿的民族风情等，总有一个让你来云南的理由!</p>
    <div class="demo-image__placeholder" style="margin-left:560px;margin-bottom: 15px;margin-top: -5px">
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">大理黄龙潭</p></el-card>
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">大理网红拍照打卡</p></el-card>
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">傣家粽</p></el-card>
      <el-card class="frontimages"><el-image class="fimages" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" style="width: 260px;  "></el-image><p class="description">云泼水</p></el-card>
    </div>
    <div class="recommendation">
      <el-link style="margin-top: 15px;font-weight: bold;color:green;font-size: 16px">来云南一定要做的事</el-link>
      <p style="margin-top: -5px;color:green;">--------------------------</p>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">找个地方看云</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">去西双版纳淘一块普洱茶</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">吃一次正宗的过桥米线</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">环游一次洱海</el-link>
      <p style="font-weight: bold;">... ... ... ...</p>
    </div>
    <div class="recommendation1">
      <el-link style="margin-top: 15px;font-weight: bold;color:green;font-size: 16px">民族节日</el-link>
      <p style="margin-top: -5px;color:green;">--------------------------</p>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">彝族:火把节(农历六月二十五日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">大理白族:三月三(农历三月十五日至二十一日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">丽江纳西族:三朵节(农历二月八)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">傈僳族:阔时节(农历十二月初五到第二年正月初十)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">摩梭人:转山节(农历七月二十五日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">傣族、德昂族:泼水节(四月中旬左右)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">怒族:仙女节(农历三月十五日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">景颇族:目瑙纵歌节(农历正月十五以后的九天内择双日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">哈尼族:姑娘节(农历二月初四)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">佤族:拉木鼓节(农历十一月-佤历一月)</el-link>

      <p style="font-weight: bold;">... ... ... ...</p>
<!--      <p style="font-weight: bold;color:green">来云南一定要做的事</p>-->
<!--      <p style="margin-top: -15px;color:green">&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;</p>-->
<!--      <p>找个地方看云</p>-->
<!--      <p>去西双版纳淘一块普洱茶</p>-->
<!--      <p>吃一次正宗的过桥米线</p>-->
<!--      <p>环游一次洱海</p>-->
<!--      <p style="font-weight: bold;">... ... ... ...</p>-->
    </div>
    <el-divider></el-divider>
    <div class="description">
      <p style="margin-left: 140px;font-size: 20px">云南境内少数民族主要有彝族、哈尼族、白族、傣族、壮族、苗族、回族、傈僳族、拉祜族佤族、纳西族、景颇族、布朗族、普米族、阿昌族、怒族、基诺族、德昂族、独龙族等25个。 云南是我国民族种类最多的省份。</p>
    </div>
    </div>


</template>

<script>
  import Zaran from './Zaran'

export default {
  data()  {
    return{
      show2: false,
      images:{
        srcList: ['https://www.dalitravel.cn/upload/image/202003/03/1565a37247d0e3d02a3d669824184b50.jpg','../../../assets/images/yunnan1.jpg','https://p1-q.mafengwo.net/s16/M00/BF/21/CoUBUmEuN4WAQpEBABmrddaOMac200.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90','https://p1-q.mafengwo.net/s16/M00/BF/40/CoUBUmEuN8qAaTXiADTR163bpk4906.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90','https://p1-q.mafengwo.net/s16/M00/BF/38/CoUBUmEuN7OAZoqOABXLo0Rl8cw563.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90'],
      }
    }
  },
  components: {
    Zaran
  },
  name: "Ethnic",
  methods:{
    backgame(){
      this.$router.push('/front/travel')
    }
  },
  mounted() {
    this.show2 = true;
  }
}
</script>

<style>
.description{
  /*width:1px;*/
  /*text-align: center;*/
}
.demo-image__placeholder{
  /*width:1000px;*/
}
.frontimages{
  width:300px;
  height:260px;
  display: inline-block;
  margin-right: 30px;
  margin-bottom: 10px;
  /*padding-right: px;*/
  background-color: #F6EEE8FF;

}
.fimages :hover{
  width: 270px;
  /*height: 260px;*/
}
.el-icon-s-operation{
  font-size: 30px;
  color: #6096a8;

}
.images{
  margin-left: 200px;
  margin-top: 50px;
  /*background-image: url("");*/
}

.big{
  height:450px;
}
.group{
  position: static;
  float: right;
  width:600px;
}
.smalla{
  /*display: inline-block;*/
  float:left;
  height:225px;
  position: relative;
  left: -400px;
}
.smallb{
  /*display: inline-block;*/
  position: relative;
  height:225px;
  top:-450px;
  left: -60px;
  /*margin-top: 225px;*/

}
.image1{
  background-color: rgb(0,0,5);
  opacity: 0;
  position:absolute;
  width:674px;
  height:60px;
  margin-top: -63px;
  color:white;
  text-align: center;
}
.image1:hover{
  opacity: 0.7;
}
.image2{
  background-color: rgb(0,0,5);
  opacity: 0;
  width:337px;
  height:50px;
  margin-left: -400px;
  position: absolute;
  margin-top: 174px;
  color:white;
  text-align: center;
}
.image2:hover{
  /*background-color: rgb(0,0,5);*/
  opacity: 0.7;
}
.image3{
  background-color: rgb(0,0,5);
  opacity: 0;
  width:337px;
  height:50px;
  position: absolute;
  color:white;
  margin-left: -400px;
  margin-top: 400px;
  text-align: center;
}
.image3:hover{
  opacity: 0.7;
}
.recommendation{
  background: #f4ece7;
  float: right;
  /*margin-left: 20px;*/
  /*margin-left: 1000px;*/
  margin-right: 100px;
  margin-top: -500px;
  width: 400px;
  /*height: 300px;*/
  /*border:2px solid #a9b5c0;*/
  border-radius: 9px;
  text-align: center;
  /*position: fixed;*/
}
.recommendation1{
  background: #f4ece7;
  float: right;
  margin-right: 100px;
  margin-top: 120px;
  width: 400px;
  border-radius: 9px;
  text-align: center;
}

.el-zoom-in-top-enter-active{
  transition:0.8s linear;
}
.el-zoom-in-bottom-enter-active{
  transition:0.8s linear;
}

</style>






























