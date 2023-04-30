<template>
  <div class="shop-container">
    <div style="margin: 10px 0">
      <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="name"></el-input>
      <el-select  placeholder="价格区间" size="small" filterable @change="customerChange" v-model="pricechosen">
        <el-option v-for="(item, index) in customerOptions" :key="index" :label="item.label" :value="item.value" style="width:182px" />
      </el-select>
      <el-button class="ml-5" type="primary" @click="search">搜索</el-button>
      <el-button type="warning" @click="reset">重置</el-button>
    </div>
    <div class="goodslist">
      <el-row style="margin: 70px">
        <el-col :span="4" v-for="(item, index) in goods" :key="item.gid" :offset="index%4 > 0 ? 2 : 0" style="padding-bottom: 30px">
          <el-card :body-style="{ padding: '10px' }">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
            <div style="padding: 14px;">
              <span>{{ item.gname }}</span>
              <span style="padding-left: 20px">
                <el-tag type="warning">￥{{ item.gprice }}元</el-tag><van-icon name="shop-o" class="icon" style="margin-left: 10px">店铺</van-icon></span>
              <p>{{item.gdesp}}</p>
<!--
              <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>-->
                <van-goods-action >
                  <van-goods-action-button type="warning" text="加入购物车" @click="addcart"/>
                  <van-goods-action-button type="danger" text="立即购买" @click="buy"/>
                </van-goods-action>
              </div>
          </el-card>
        </el-col>
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
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data(){
    return{
      customerOptions:[
        {label:'低于50元',price:50,value:'1'},
        {label:'51~100元',price:100,value:'2'},
        {label:'101~200元',price:200,value:'3'},
        {label:'201~500元',price:500,value:'4'},
        {label:'501~1000元',price:1000,value:'5'},
        {label:'大于1000元',price:1000,value:'6'},   //选用大于1000的接口
      ],
      pricechosen:"",
      name:'',
      goods:[
        {gid:1,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:2,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:3,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:4,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:5,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:6,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:7,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:8,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:9,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'},
        {gid:10,gname:'大满园梨子',gprice:85,gstate:0,gimg:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',gdesp:'好好吃'}
      ]
    }
  },
  methods:{
    search(){
      console.log('搜索搜索')
    },
    reset(){
      this.pricechosen=''
      this.name=''
    },
    customerChange(id) {
      const thisLabel = this.customerOptions.find(item => item.value === id).label
      console.log(`label----->`, thisLabel,id) //label-----> 国风
      this.pricechosen=thisLabel
    },
    addcart(){
      console.log('加入购物车')
    },
    buy(){
      console.log('买买买')
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
  }
}
</script>

<style scoped>
  .bottom clearfix{
    position: static;
  }
  .van-goods-action{
    position: relative;
  }
  .block{
    position: absolute;
    top: 1380px;
    left: 80px;
    /*border-top: 1px solid black;*/
    /*padding-top: 5px;*/
    /*width: 800px;*/
    /*box-shadow: 5px 5px 3px rgba(0,0,0,0.5);*/
  }
</style>
