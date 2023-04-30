<template>
  <div class="homeright-container">
    <div class="notify" style="width: 400px">
      <van-notice-bar left-icon="volume-o" :scrollable="true"  v-for="(item,index) in topics" :key="item.id">
        <van-swipe
          vertical
          class="notice-swipe"
          :autoplay="3000"
          :show-indicators="false"
        >
          <van-swipe-item>{{item.content}}</van-swipe-item>
        </van-swipe>
      </van-notice-bar>
    </div>
    <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white" vertical v-for="(items,index) in goods" :key="index">
      <van-swipe-item v-for="(item,index) in items" :key="item.id" style="height: 125px">
        <van-card
          :num="item.num"
          :price="item.price"
          :desc="item.desc"
          :title="item.title"
          :thumb="item.thumb"
        >
          <template #tags>
            <van-tag plain type="danger">标签</van-tag>
            <van-tag plain type="danger">标签</van-tag>
          </template>
<!--          <template #footer>-->
<!--            <van-button size="mini">按钮</van-button>-->
<!--            <van-button size="mini">按钮</van-button>-->
<!--          </template>-->
        </van-card>
      </van-swipe-item>
    </van-swipe>
  </div>
</template>

<script>
export default {
  name: "HomeRight",
  data() {
    return {
      goods: [
        [{num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
        {num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
        {num: "2", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
        {num: "3", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
        {num: "4", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"}],
        [{num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "2", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "3", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "4", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"}],
        [{num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "2", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "3", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "4", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"}],
        [{num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "1", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "2", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "3", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"},
          {num: "4", price: "2.00", desc: "描述商品", title: "商品信息", thumb: "https://img01.yzcdn.cn/vant/ipad.jpeg"}],
      ],
      topics: [
        {id: 1, content: "小李家桃子熟啦，快来采摘！！"},
        {id: 2, content: "小惠助农，点击详情！！"},
        {id: 3, content: "顾客有福利啦！！"},
        {id: 4, content: "花香城一天导航游玩~~~"},
        {id: 5, content: "限时领取，3折优惠购买~~~"},
        {id: 6, content: "小李家桃子熟啦，快来采摘！！"},
        // {id: 7, content: "小惠助农，点击详情！！"},
        // {id: 8, content: "顾客有福利啦！！"},
        // {id: 9, content: "花香城一天导航游玩~~~"},
        // {id: 10, content: "限时领取，3折优惠购买~~~"},
      ]
    }
  }
}
</script>

<style scoped>
  .my-swipe{
    height: 125px;
    margin-top: 50px;
  }
  .my-swipe .van-swipe-item {
    color: #fff;
    font-size: 20px;
    /*line-height: 150px;*/
    text-align: center;
  }
  .homeright-container{
    position: absolute;
    top: 600px;
    right: 25px;
    width: 400px;
    height: 1000px;
    box-shadow: -5px 5px 5px rgba(0,0,0,0.2);
  }
  /deep/ .van-swipe-item{
    height: 150px;
  }
  .notice-swipe {
    height: 50px;
    line-height: 50px;
  }
  .van-notice-bar{
    margin: 5px;
  }
  .notify{
    box-shadow: 5px 5px 5px rgba(0,0,0,0.2);

  }
</style>

