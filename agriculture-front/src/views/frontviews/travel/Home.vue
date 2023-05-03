<template>
  <!--  <div class="travel-container">-->
  <!--    <van-search v-model="value" placeholder="请输入搜索关键词" />-->
  <!--  </div>-->
  <div class="scenery_container">
    <div class="map">
      <test></test>
    </div>
    <div class="title" v-bind:style="{ fontWeight: 'bold' }">景区</div>
    <p style="margin-left: 350px">
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="gomustgo()">游玩必去
      </el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="ethnic()">民族风情
      </el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="hot()">网红打卡
      </el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="transport()">交通指南
      </el-button>
      <i class="el-icon-arrow-right"></i>
      <el-button type="primary" plain style="font-size: 20px;padding:10px;margin-top: 10px;margin-bottom: 20px;" @click="accommodation()">住宿指南
      </el-button>
    </p>
    <div class="demo-image__placeholder" style="margin-left:110px;margin-bottom: 15px;margin-top: -5px">
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan10.jpg" style="width: 270px;  ">
        <p class="description">大理黄龙潭</p></el-card>
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan11.jpg" style="width: 260px;  ">
        <p class="description">大理网红拍照打卡</p></el-card>
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan12.jpg" style="width: 260px;  ">
        <p class="description">傣家粽</p></el-card>
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan13.jpg" style="width: 260px;">
        <p class="description">云泼水</p></el-card>
    </div>

    <el-card style="width: 80%;margin-left: 100px;">
      <div class="demo-image__preview" v-for="(item,index) in scenerys" :key="item.id">
        <el-image style="width: 200px; margin-bottom: -40px;padding-top: 10px" :src="item.surl" :preview-src-list="item.srcList">
        </el-image>
        <div class="content">
          <p>
            <span>{{ item.sname }} </span>
            <el-button type="success" round style="margin-left:800px;margin-bottom: -10px">
              <span style="font-size: 15px" @click="goreserve(item.sprice,item.sname,item.sid)">预约</span></el-button>
          </p>
          <hr>
          <p>
            <el-tag>地点</el-tag>
            {{ item.saddress }}
          </p>
          <p>
            <el-tag type="warning">介绍</el-tag>
            {{ item.sdesp }}
          </p>
        </div>
        <div class="itemrate">
          <p style="position: relative;top: -70px;left:160px;margin-bottom: 35px">
            <span class="date">
              <van-icon name="clock-o" style="font-weight: lighter;font-size: 5px"/>
              <span style="font-size: 15px">{{ item.create_time }} </span>
               <el-link type="success" style="font-size: 16px;margin-left: 10px"> / 悦享滇韵</el-link>
            </span>
            <i class="el-icon-d-arrow-right" style="margin-left: 50px;"></i>
            <span style="font-size: 15px;color:green;">了解更多</span>

          </p>
        </div>
        <el-divider class="divide"></el-divider>
      </div>
      <div class="block">
        <el-pagination @size-change="handleSize" @current-change="handleCurrent" :current-page="aPage.page" :page-sizes="[5,10,15,20,50]" :page-size="aPage.size" layout="total, sizes, prev, pager, next, jumper" :total="aPage.total">
        </el-pagination>
      </div>
    </el-card>
    <div class="reserveinfo">
      <el-dialog title="预订信息" :visible.sync="reserveVisible" width="30%">
        <el-form>
          <el-form-item label="姓名" label-width="100px">
            <el-input v-model="uname" disabled></el-input>
          </el-form-item>
          <el-form-item label="景点" label-width="100px">
            <el-input v-model="sceneryname" disabled></el-input>
          </el-form-item>
          <el-form-item label="门票" label-width="100px">
            <el-input v-model="sprice" disabled></el-input>
          </el-form-item>
          <el-form-item label="数量" label-width="100px">
            <el-input type="number" style="text-align: center" v-model="dnum" min="1" max="5">
            </el-input>
          </el-form-item>
          <el-form-item label="共计" label-width="100px">
            <el-input v-model="dtotal" disabled></el-input>
          </el-form-item>
          <el-form-item label="日期" label-width="100px">
            <el-date-picker v-model="updateTime" type="datetime" placeholder="选择日期时间" default-time="9:00:00">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="备注" label-width="100px">
            <el-input v-model="other"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelinfo">取 消</el-button>
          <el-button type="primary" @click="reservebutton">确认预约</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import test from "../../test";
import {sceneryAllAPI,reserveSaveAPI} from "../../../api";
import reserve from "../self/Reserve.vue";
import item from "vue-baidu-map/components/context-menu/Item.vue";

export default {
  name: "Home",
  computed: {
    item() {
      return item
    }
  },
  components: {test},
  data() {
    return {
      scenerys: [],
      aPage: {
        page: 1,
        size: 10,
        total: 100,
      },
      reserveVisible:false,
      sid:0,
      uid:0,
      gid:0,
      sceneryname:"",
      sprice:0,
      dnum:0,
      dtotal: 0,
      uname:"",
      updateTime:"",
      other:"",
      reserveContent:{
        sid:0,
        uid:0,
        gid:0,
        dnum:0,
        dtotal: 0,
        updateTime:"",
      }
    }
  },
  methods: {
    handleSize(val) {
      console.log(`每页 ${val} 条`);
      this.aPage.size = val;
      this.getList();
    },
    handleCurrent(val) {
      console.log(`当前页: ${val}`);
      this.aPage.page = val;
      this.getList();
    },
    async getList() {
      const json = JSON.stringify(this.aPage);
      const {data: res} = await sceneryAllAPI(json);
      console.log(res);
      console.log("开始");
      if (res.code === '00000') {
        console.log("景点获取成功");
        this.scenerys = res.data.records;
        console.log("this.scenerys" + this.scenerys[0]);
        this.aPage.total = res.data.total;
      } else {
        this.$message.error(res.msg)
      }
      console.log("结束")
    },
    gomustgo() {
      this.$router.push("/front/mustgo")
    },
    hot() {
      this.$router.push("/front/hot")
    },
    ethnic() {
      this.$router.push('/front/ethnic')
    },
    transport() {
      this.$router.push('/front/transport')
    },
    accommodation() {
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
    goreserve(sprice,sname,sid){
      console.log("reserve")
      this.dnum=1
      this.updateTime=""
      this.other=""
      this.sceneryname=sname
      this.sprice=sprice
      this.sid=sid
      this.uname=JSON.parse(localStorage.getItem("user")).uname
      this.uid=JSON.parse(localStorage.getItem("user")).uid
      this.reserveVisible=true
    },
    cancelinfo() {
      console.log("cancelinfo")
      this.reserveVisible=false
    },
    reservebutton() {
      this.reserveContent.sid = this.sid
      this.reserveContent.uid = this.uid
      this.reserveContent.gid = 10
      this.reserveContent.dnum = this.dnum
      this.reserveContent.dtotal = this.dtotal
      this.reserveContent.updateTime = this.updateTime
      console.log("this.reserveContent")
      console.log(this.reserveContent)
      this.reserveVisible = false
      this.reserveSave()
    },
    async reserveSave(){
      console.log("reserveapi")
      const json = JSON.stringify(this.reserveContent);
      const {data: res} = await reserveSaveAPI(json);
      console.log(res);
      console.log("开始");
      if (res.code === '00000') {
        console.log("预订成功");

        this.aPage.total = res.data.total;
      } else {
        this.$message.error(res.msg)
      }
      console.log("结束")
    }
  },
  created() {
    this.getList()
  },
  watch: {
    dnum: {
      handler(neaVal) {
        console.log("num变化")
        this.dtotal = this.sprice * this.dnum;
      },
      deep: true
    }
  },
}
</script>

<style scoped>
.frontimages {
  width: 300px;
  height: 260px;
  display: inline-block;
  background-color: #F6EEE8FF;
}

.description {
  font-size: 16px;
  color: #a9b5c0;
  text-align: center;
}

.map {
  margin-left: -300px;
  margin-top: 100px;
}

.fimages :hover {
  width: 280px;
  /*height: 260px;*/
}

/*.img :hover{*/
/*  width: 280px;*/
/*}*/
.title {
  width: 77.2%;
  height: 60px;
  /*font-family: "Helvetica Neue", Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;*/
  font-size: 22px;
  /*text-align:center;*/
  padding-left: 40px;
  vertical-align: middle;
  line-height: 60px;
  color: white;
  background-color: #3d8ce3;
  margin-left: 100px;
  margin-top: -360px;
}

.scenery_container {
  margin: -0px 0 -180px 300px
}

.content {
  position: relative;
  /*left: 120px;*/
  /*top:-75px;*/
  left: 240px;
  top: -105px;
  width: 75%;
}

span {
  font-weight: bold;
  font-size: 18px;
}

/deep/ .van-popup--top {
  width: 20%;
}

.divide {
  margin-top: -85px;
}

.itemrate {
  position: static;
  margin-left: 700px;
  margin-top: -15px;
}

.itemrate .el-rate {
  position: relative;
  top: -25px
}

.itemrate .browse {
  position: relative;
  top: -105px;
  left: 380px;
  /*color:red;*/
}
</style>
