<template>
  <div class="articleList">
    <el-card class="card" shadow="hover" v-for="item in goods" >
      <el-button type="primary" class="button" @click="getGoodsDetail(item)">点击了解</el-button>
      <img style="width:200px; height: 200px;" class="img" alt="图片"
                :src="item.gimg"
      >
      <div class="text">
        <div class="article">
          <p class="title">{{item.gname}} </p>
        </div>
        <div class="info">
          <p class="type">
            <el-tag>价格</el-tag>
            {{item.gprice}}元/斤
          </p>
          <p class="createTime" >
            <el-tag>创建时间</el-tag>
            {{item.createTime | dateFormat}}
          </p>
        </div>
        <div class="summary" >
          <p type="success">描述:{{item.gdesp}}</p>
        </div>
      </div>
    </el-card>
    <div class="detail">
      <el-dialog title="商品详情" :visible.sync="dialogDetailFormVisible" width="700px">
        <div class="info" style="margin: 0 0 0 200px">
          <el-image :src=(apply.gimg) title="点击查看商品大图" :preview-src-list="srcList" style="width: 300px"></el-image>
          <div class="msg">
            <el-tag type="info">商品名称</el-tag>
            <div class="detail">{{ apply.gname }}</div>
            <el-tag type="info">商品价格</el-tag>
            <div class="detail">{{ apply.gprice }}元/斤</div>
            <el-tag type="info">商品创建时间</el-tag>
            <div class="detail">{{ apply.createTime | dateFormat}}</div>
            <el-tag type="info">商品描述</el-tag>
            <div class="detail">{{ apply.gdesp }}</div>
            <el-tag type="info">商品状态</el-tag>
            <div class="detail">
              <div v-if="apply.state==0" class="no">商品未售罄~</div>
              <div v-else-if="apply.state==1" class="wait">商品已售罄</div>
            </div>
          </div>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelinfo">取 消</el-button>
          <el-button type="primary" @click="confirminfo">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import dayjs from 'dayjs'
export default {
  name: "OrderDetail",
  data(){
    return {
      goods:[],
      news:[],
      apply:{},
      srcList:[],
      dialogDetailFormVisible:false,
    }
  },

  methods:{
    cancelinfo(){
      this.dialogDetailFormVisible = false;
    },
    confirminfo(){
      this.dialogDetailFormVisible = false;
    },
    getGoodsDetail(item){
      this.dialogDetailFormVisible=true
      this.apply=item
      localStorage.setItem('item',JSON.stringify(this.apply))
      this.srcList.push(this.apply.gimg)
    },
  async getOrderDetail(){
     const oid=localStorage.getItem('orderDetailId')  //获得用户订单的id
    await this.request.get("/orderdetailvo/myorder/"+oid).then(res=>{
        this.news=res.data.data
      })
     for(let i =0;i<this.news.length;i++){
     await this.request.get("/goods/"+this.news[i].gid).then(res=>{
         this.goods.push(res.data.data)
       })
     }
    },

  },
  created() {
    this.getOrderDetail()
  },
  filters: {
    dateFormat(time) {
      //对time进行格式化处理 ，得到YYYY-MM-DD HH:mm:ss
      //  把格式化的结果，return出去
      //  直接调用dayjs()得到的是当前的时间
      //  dayjs（给定的日期时间）得到指定的时间
      //  只要导入了dayjs 的库文件，在window全局，就可以使用dayjs()方法
      const dstr = dayjs(time).format("YYYY-MM-DD")
      return dstr
    }
  }
}
</script>

<style scoped>
.articleList{
  position: static;
  margin-left: 160px;
}
.img{
  float: left;
  margin:auto 5px;
}
.article p{
  margin-right: 5px;
  display: inline;
}
.score,.type,.createTime{
  display: inline;
  margin-right: 20px;
}
.info{
  margin:  10px auto ;
}
.title{
  font-size: 25px;

}
.summary{
  font-size: 20px;
  margin:  10px auto ;
}
.text{
 position: relative;
  right: -50px;
  top: 20px;

}
.card{
  display: inline-block;
  margin: 15px;
  width: 40%;
  height:290px;
  background: #e4eeee;
}
.button{
  /*top: 10px;*/
  /*right: 50px;*/
  /*right: 10px;*/
  top:25px;
  margin-left: 400px;
  position: relative;
  font-size: 15px;
  color: white;
  background: #7fb2ec;
}
el-pagination{
  display: block;
}

</style>
