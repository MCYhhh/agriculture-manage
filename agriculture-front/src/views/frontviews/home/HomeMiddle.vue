<template>
  <div class="homemiddle-container">
    <h2 class="neon">=====好物推荐====</h2>
    <div class="recgoods">
      <van-grid :border="false" :column-num="4" v-for="(items,index) in goodsList" :key="index">
        <van-grid-item v-for="(item,index) in items" :key=item.gid class="goods-grid" style="padding-top: 150px;margin-top: -50px">
          <van-image :src="item.gimg"/>
          <div class="goods" style="padding-top: 40px">
            <el-tag type="warning" style="position: relative;top: 15px;left: -150px;margin-bottom: 20px;font-size: 13px">{{ item.uname }}</el-tag>
            <p class="goodsname" style="width: 150px;margin-left: -100px">
              <el-tag type="danger">￥{{item.gprice}}</el-tag>
              <span>{{item.gdesp}}</span>
            </p>
          </div>
          <div class="goodsdetail">
              <van-icon name="like-o" class="icon">关注</van-icon>
              <van-icon name="shop-o" class="icon">进入店铺</van-icon>
              <van-icon name="shopping-cart-o" color="#1989fa" class="icon">加入购物车</van-icon>
          </div>
        </van-grid-item>
      </van-grid>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeMiddle",
  data(){
    return{
      goodsList:[
        [{gid:1,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg:'https://img01.yzcdn.cn/vant/apple-1.jpg'},
        {gid:2,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg: 'https://img01.yzcdn.cn/vant/apple-2.jpg'},
        {gid:3,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg: 'https://img01.yzcdn.cn/vant/apple-2.jpg'},
        {gid:4,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg: 'https://img01.yzcdn.cn/vant/apple-2.jpg'}],
        [{gid:1,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg:'https://img.zcool.cn/community/0190bc5b0d56f5a8012043d8a59d1a.jpg@3000w_1l_0o_100sh.jpg'},
          {gid:2,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg: 'https://desk-fd.zol-img.com.cn/t_s640x530c5/g4/M0A/06/04/ChMly113EU2IT0RaACsB4KbnZOsAAXnXwE5C-kAKwH4388.jpg'},
          {gid:3,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg: 'https://img01.yzcdn.cn/vant/apple-2.jpg'},
          {gid:4,uname:'小李大产量',gname:'人参果',gdesp:'俏农优选 人参果5斤大果（单果60到90克）新鲜水果黄肉黄心大圆果 生鲜',gprice:50,gimg: 'https://img01.yzcdn.cn/vant/apple-2.jpg'}],
        ]
    }
  }
}
</script>

<style scoped>
  .homemiddle-container{
    margin: 0 auto;
    width: 1600px;
    height:400px ;
    position: static;
  }
  h2{
    width: 1000px;
    height: 200px;
    position: absolute;
    left: 50%;
    margin-left: -150px;
    background-image: -webkit-linear-gradient(left, #eec0a0,#66ffff 10%, #00ffbb 20%, #e3b4e3 30%, #CCCCFF 40%, #00FFFF 50%,#CCCCFF 60%,#CC00CC 70%,#CC00FF 80%,#66FFFF 90%,blue 100%);
    -webkit-text-fill-color: transparent;
    -webkit-background-clip: text;
    -webkit-background-size: 200% 100%;
    -webkit-animation: masked-animation 4s linear infinite;
    font-size: 35px;
  }
  @keyframes masked-animation {
    0% {
      background-position: 0  0;
    }
    100% {
      background-position: -100%  0;
    }
  }

  .van-grid-item{
    position: static;
    padding: 8px 25px 5px 30px;
    box-shadow: 5px 5px 3px rgba(222, 125, 125, 0.1);
    margin-bottom: 85px;
    height: 250px;
  }

  .goods-grid{

  }

  .van-image{
    position: relative;
    left:-100px;
    width: 200px;
    height: 200px;
  }
  .recgoods{
    top: 180px;
    /*left:-20px;*/
    position: relative;
    left: 5%;
    margin-left: -150px;
  }
  .goodsdetail{
    position: relative;
    left: -90px;
    top:-170px
  }
  .icon{
    font-size: 13px;
    border: solid 1px #cac6c6;
    padding: 5px;
    margin-left: -5px;
  }
  .goods{
    position: relative;
    top: -210px;
    left: 180px;
  }

</style>
