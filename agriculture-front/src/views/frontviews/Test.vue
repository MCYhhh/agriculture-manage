<template>
  <div class="user-main">
    <div class="map-container">
      <baidu-map
        class="bm-view"
        :center="center"
        :zoom="zoom"
        :scroll-wheel-zoom="scrollZoom"
        @ready="handler"
      >
        <!-- 全景 -->
        <bm-panorama></bm-panorama>
        <!-- 缩略图 -->
        <bm-overview-map
          anchor="BMAP_ANCHOR_BOTTOM_RIGHT"
          :isOpen="true"
        ></bm-overview-map>
        <!-- 点位 -->
        <bm-marker
          :position="center"
          :dragging="false"
          animation="BMAP_ANIMATION_BOUNCE"
          :icon="iconpoint"
          @click="infoWindowOpen"
          :zIndex="100"
        >
          <!-- 窗体信息 -->
          <bm-info-window
            :show="show"
            @close="infoWindowClose"
            @open="infoWindowOpen"
          ><div>
            <p>甘肃农业职业技术学院</p>
            <p>地址：兰州市城关区段家滩425号</p>
            <p>电话：0931-4673806</p>
            <p>邮箱：gnzyzb@126.com</p>
          </div>
          </bm-info-window>
        </bm-marker>
        <!-- 检索路线 -->
        <div class="search-route">
          <el-radio-group v-model="routeaddress" size="small">
            <el-row>
              <el-col :span="8"><el-radio-button label="驾车"></el-radio-button></el-col>
              <el-col :span="8"><el-radio-button label="步行"></el-radio-button></el-col>
              <el-col :span="8"><el-radio-button label="公交"></el-radio-button></el-col>
            </el-row>
          </el-radio-group>
          <el-input
            v-model="myaddress"
            size="small"
            placeholder="我的位置"
          >
            <template slot="append">
              <el-button type="primary" icon="el-icon-close" @click="clearPathfinding"></el-button>
            </template>
          </el-input>
          <div class="routebox" :style="{height: routeHeight}">
            <!-- 驾车路线 -->
            <bm-driving
              v-if="routeaddress == '驾车'"
              :start="myaddress"
              end="甘肃农业职业技术学院"
              endCity="兰州"
              :auto-viewport="true"
            ></bm-driving>
            <!-- 步行路线 -->
            <bm-walking
              v-if="routeaddress == '步行'"
              :start="myaddress"
              end="甘肃农业职业技术学院"
              endCity="兰州"
              :auto-viewport="true"
            ></bm-walking>
            <!-- 公交路线 -->
            <bm-transit
              v-if="routeaddress == '公交'"
              :start="myaddress"
              end="甘肃农业职业技术学院"
              endCity="兰州"
              :auto-viewport="true"
            ></bm-transit>
          </div>
        </div>
        <!-- 地区检索 -->
        <!-- <bm-local-search :keyword="myaddress" :auto-viewport="true" :location="location"></bm-local-search> -->
      </baidu-map>
    </div>
  </div>
</template>

<script>
export default {
  name: "Map",
  data() {
    return {
      myaddress: "",
      location: "",
      center: { lng: 103.89554, lat: 36.050646 }, // 设置经纬度
      zoom: 16, // 缩放等级
      scrollZoom: true, // 是否开启滚轮缩放
      iconpoint: {
        url: "/image/nz-logo.png",
        size: { width: 25, height: 25 },
      },
      show: true, // 控制窗体信息
      routeaddress: '驾车',
      routeHeight: '0',
    };
  },
  watch: {
    myaddress(val){
      if(val){
        this.routeHeight = '450px'
      }else{
        this.routeHeight = '0'
      }
    }
  },
  methods: {
    handler({ BMap, map }) {
      // console.log(BMap, map)
    },
    Pathfinding() {},
    clearPathfinding() {
      this.myaddress = "";
      this.location = "";
    },
    infoWindowClose() {
      this.show = false;
    },
    infoWindowOpen() {
      this.show = true;
    },
  },
};
</script>

<style lang="scss" scoped>
.address {
  margin-bottom: 22px;
  i {
    color: #5494ff;
    font-size: 20px;
    margin-right: 5px;
  }
  .schname {
    font-size: 16px;
    color: #333;
    margin-right: 12px;
    font-weight: bold;
  }
  .addresstext {
    font-size: 12px;
    color: #5494ff;
  }
}
.map-container {
  width: 100%;
  height: 600px;
  .bm-view {
    width: 100%;
    height: 600px;
    position: relative;
    .search-route {
      position: absolute;
      top: 10px;
      left: 10px;
      width: 300px;
      ::v-deep .el-radio-group{
        width: 100%;
        .el-radio-button{
          width: 100%;
        }
        .el-radio-button__inner{
          width: 100%;
          border-radius: 0;
          border: 0;
        }
        .el-radio-button__orig-radio:checked+.el-radio-button__inner{
          background-color: #5494ff;
        }
      }
      .routebox{
        overflow-y: auto;
      }
    }
  }
}
</style>
