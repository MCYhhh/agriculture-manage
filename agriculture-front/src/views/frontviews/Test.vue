<template>
  <div class="homemiddle-container" style="margin: 0 auto">
      <van-notice-bar left-icon="volume-o" :scrollable="true"  v-for="(item,index) in topics" :key="item.id">
      <van-swipe
        vertical
        class="notice-swipe"
        :autoplay="3000"
        :show-indicators="false"
      >
        <van-swipe-item>{{item.content}}</van-swipe-item>
        <!--        <van-swipe-item>内容 2</van-swipe-item>-->
        <!--        <van-swipe-item>内容 3</van-swipe-item>-->
      </van-swipe>
    </van-notice-bar>


  </div>
</template>

<script>
export default {
  name: "HomeLeft",
  data(){
    return{
      topics:[
        {id:1,content:"小李家桃子熟啦，快来采摘！！"},
        {id:2,content:"小惠助农，点击详情！！"},
        {id:3,content:"顾客有福利啦！！"},
        {id:4,content:"花香城一天导航游玩~~~"},
        {id:5,content:"限时领取，3折优惠购买~~~"},
      ]
    }
  }
}
</script>

<style scoped>
.notice-swipe {
  height: 40px;
  line-height: 40px;
}
.van-notice-bar{
  margin: 5px;
}
.homeleft-container{
  position: absolute;
  top: 500px;
  left: 20px;
  /*float: right;*/
  box-shadow: 5px 5px 5px rgba(0,0,0,0.2);
}
</style>
