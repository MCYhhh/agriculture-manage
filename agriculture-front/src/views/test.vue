<!--<template>-->
<!--  <div id="app">-->
<!--    <div id="nav">-->
<!--      <router-link to="/">Home</router-link> |-->
<!--      <router-link to="/about">About</router-link>-->
<!--    </div>-->

<!--    <div class="amap-wrapper">-->
<!--      <el-amap-->
<!--        class="amap-box"-->
<!--        vid="amap-vue"-->
<!--        :zoom="zoom"-->
<!--        :center="center"-->
<!--      ></el-amap>-->
<!--    </div>-->
<!--    <router-view />-->
<!--  </div>-->

<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "App",-->
<!--  data() {-->
<!--    return {-->
<!--      zoom: 11,-->
<!--      center: [112.5862, 37.8268],-->
<!--    };-->
<!--  },-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.amap-wrapper {-->
<!--  width: 400px;-->
<!--  height: 400px;-->
<!--  float:left;-->
<!--}-->
<!--#app {-->
<!--  font-family: Avenir, Helvetica, Arial, sans-serif;-->
<!--  -webkit-font-smoothing: antialiased;-->
<!--  -moz-osx-font-smoothing: grayscale;-->
<!--  text-align: center;-->
<!--  color: #2c3e50;-->
<!--}-->

<!--#nav {-->
<!--  padding: 30px;-->
<!--}-->

<!--#nav a {-->
<!--  font-weight: bold;-->
<!--  color: #2c3e50;-->
<!--}-->

<!--#nav a.router-link-exact-active {-->
<!--  color: #42b983;-->
<!--}-->
<!--</style>-->




<!--<template>-->
<!--  <div id="app">-->
<!--    <div id="nav">-->
<!--      <router-link to="/">Home</router-link> |-->
<!--      <router-link to="/about">About</router-link>-->
<!--    </div>-->

<!--    <div class="amap-wrapper">-->
<!--      <el-amap-->
<!--        class="amap-box"-->
<!--        vid="amap-vue"-->
<!--        :zoom="zoom"-->
<!--        :center="center"-->
<!--      ></el-amap>-->
<!--    </div>-->
<!--    <router-view />-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "App",-->
<!--  data() {-->
<!--    return {-->
<!--      zoom: 11,-->
<!--      center: [112.5862, 37.8268],-->
<!--    };-->
<!--  },-->
<!--};-->
<!--</script>-->

<!--<style>-->
<!--.amap-wrapper {-->
<!--  width: 800px;-->
<!--  height: 800px;-->
<!--  float: right;-->
<!--}-->
<!--#app {-->
<!--  font-family: Avenir, Helvetica, Arial, sans-serif;-->
<!--  -webkit-font-smoothing: antialiased;-->
<!--  -moz-osx-font-smoothing: grayscale;-->
<!--  text-align: center;-->
<!--  color: #2c3e50;-->
<!--}-->

<!--#nav {-->
<!--  padding: 30px;-->
<!--}-->

<!--#nav a {-->
<!--  font-weight: bold;-->
<!--  color: #2c3e50;-->
<!--}-->

<!--#nav a.router-link-exact-active {-->
<!--  color: #42b983;-->
<!--}-->
<!--</style>-->






<!--<template>-->
<!--  <div class="box">-->
<!--    <div :style="{width:'100%',height:'300px'}">-->
<!--      <el-amap vid="amap" :plugin="plugin" class="amap-demo" :center="center"></el-amap>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  data(){-->
<!--    const self = this;-->
<!--    return {-->
<!--      center: [121.59996, 31.197646],-->
<!--      lng: 0,-->
<!--      lat: 0,-->
<!--      loaded: false,-->
<!--      plugin: [{-->
<!--        enableHighAccuracy: true,//是否使用高精度定位，默认:true-->
<!--        timeout: 100,          //超过10秒后停止定位，默认：无穷大-->
<!--        maximumAge: 0,           //定位结果缓存0毫秒，默认：0-->
<!--        convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true-->
<!--        showButton: true,        //显示定位按钮，默认：true-->
<!--        buttonPosition: 'RB',    //定位按钮停靠位置，默认：'LB'，左下角-->
<!--        showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true-->
<!--        showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true-->
<!--        panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true-->
<!--        zoomToAccuracy:true,//定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：f-->
<!--        extensions:'all',-->
<!--        pName: 'Geolocation',-->
<!--        events: {-->
<!--          init(o) {-->
<!--            // o 是高德地图定位插件实例-->
<!--            o.getCurrentPosition((status, result) => {-->
<!--              console.log(result)-->
<!--              if (result && result.position) {-->
<!--                self.lng = result.position.lng;-->
<!--                self.lat = result.position.lat;-->
<!--                self.center = [self.lng, self.lat];-->
<!--                self.loaded = true;-->
<!--                self.$nextTick();-->
<!--              }-->
<!--            });-->
<!--          }-->
<!--        }-->
<!--      }]-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->




<template>
  <div class="Map" >
    <p id="tip" style="font-size: 20px;font-weight: bold;margin-left: 90px;color:#8698a6">--地图--</p>
    <div id="container" ref="refMagnify"></div>
    <i class="el-icon-full-screen" @click="magnify" ></i>
    <el-input v-model="searchLocationValue" placeholder="位置" class="handle-input mr10"></el-input>
    <el-tooltip class="item" effect="dark" content="搜索目标地址" placement="bottom-start" >
    <el-button type="primary" class="mr10" @click="searchLocation" content="搜索目标地址">搜索</el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="light" content="一键导航" placement="bottom">
    <el-button type="primary" class="mr10" @click="navigation">导航</el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="获取当前位置" placement="bottom-end">
    <el-button type="primary" class="mr10" @click="fixedPosition">获取我的位置</el-button>
    </el-tooltip>


  </div>
</template>


<script>
// import BaiduMap from vue-baidu-map/components/map/Map.vue'
// <!--<script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=刚才申请的AK">-->
export default {
  name:'test1',
  data() {
    return {
      center: {
        lng: 0,
        lat: 0
      },
      zoom: 10,
      model: {
        lng: '',
        lat: '',
        address: ''
      },
      map: null,
      searchLocationValue: '',
      local: null
    }
  },
  methods: {
    magnify(){
    },

    /**
     * 初始化地图
     */
    initMap() {
      // 创建Map实例 注意要和上面写的div的id名一样
      this.map = new BMap.Map("container");

      // 初始化地图,设置初始化位置，及地图级别
      var initPoint=new BMap.Point(116.404, 39.915);
      this.map.centerAndZoom(initPoint, 12);
      // 开启鼠标滚轮缩放
      this.map.enableScrollWheelZoom(true);

      // 创建标注
      this.map.addOverlay(new BMap.Marker(initPoint));

      const _this = this;
      //添加地图点击事件
      this.map.addEventListener('click', function(e) {

        console.log('点击位置经纬度：' + e.point.lng + ',' + e.point.lat);
        _this.center.lng = e.point.lng;
        _this.center.lat = e.point.lat;
        //清除之前的标记
        _this.map.clearOverlays();
        // 创建点标记
        var point = new BMap.Point(_this.center.lng, _this.center.lat);
        //获取位置信息
        var geocoder = new BMap.Geocoder();
        geocoder.getLocation(point, function(geocoderResult, LocationOptions) {
          //清除之前的标记
          _this.map.clearOverlays()
          _this.map.addControl(new BMap.NavigationControl());
          var marker = new BMap.Marker(point);
          // 创建标注
          _this.map.addOverlay(marker);
          //地址定位成功
          var address = geocoderResult.address;
          console.log("所处地址", address)
        });

      });



    },
    /**
     * 获取自己的位置
     */
    fixedPosition() {
      const _this = this;
      var geolocation = new BMap.Geolocation();
      geolocation.getCurrentPosition(function(r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
          var mk = new BMap.Marker(r.point);
          _this.map.addOverlay(mk);
          _this.map.panTo(r.point);
          _this.center.lng = r.point.lng;
          _this.center.lat = r.point.lat;

          var city_name = r.address.province + r.address.city;
          console.log("当前位置--》", city_name);
          console.log("当前位置经纬度--》", r.point.lng,r.point.lat);
        } else {
          console.log('获取失败');
        }
      });
    },
    /**
     * 地图搜索
     */
    searchLocation() {

      this.local = new BMap.LocalSearch(this.map, {
        renderOptions: {
          map: this.map
        },
        onSearchComplete: this.searchCallback //设置回调函数

      });
      this.local.search(this.searchLocationValue); //设置搜索参数

    },
    /**
     * 搜索结果的回调函数
     */
    searchCallback() {
      var point = this.local.getResults().getPoi(0).point;
      //获取第一个智能搜索的结果
      console.log("当前位置的经纬度",point.lng, point.lat);
      this.model.lat=point.lat;
      this.model.lng=point.lng;

    },
    /**
     * 导航
     */
    navigation(){
      if(this.center.lng==0||this.center.lat==0){
        alert("请先获取您的位置")
        return
      }

      //出发地
      var p1 = new BMap.Point(this.center.lng, this.center.lat);
      //目的地
      var p2 = new BMap.Point(this.model.lng, this.model.lat);

      var driving = new BMap.DrivingRoute(this.map, {
        renderOptions: {
          map: this.map,
          autoViewport: true
        }
      });
      driving.search(p1, p2);
    }

  },


  mounted() {
    //初始化地图
    this.initMap();

  },


}
</script>

<style scoped>
#l-map {
  height: 100px;
  width: 100px;
}

#r-result {
  width: 100%;
}

.Map {
  /*position: fixed;*/
  height: 260px;
  width: 260px;
  position: static;
  /*width: 100%;*/
  /*height: 70%;*/
  margin-left: 50px;
  margin-top: 50px;
}

#container {
  overflow: hidden;
  width: 100%;
  height: 100%;
  margin: 0;
  font-family: "微软雅黑";
}
.el-icon-full-screen{
  position:relative;
  top:-30px;
  right:-240px;
  font-size:20px;
  font-weight: bold;
  /*margin-left: 245px;*/
}
</style>







<!--<template>-->
<!--<bm-control>-->
<!--<div id="searchbox" class="clearfix">-->
<!--  <div id="searchbox-container">-->

<!--    <div id="sole-searchbox-content" class="searchbox-content" style="display: block;">-->
<!--      <input id="sole-input" class="searchbox-content-common cc_cursor" type="text" name="word" autocomplete="off" maxlength="256"-->
<!--             placeholder="搜地点"-->
<!--             v-model="keyword">-->
<!--      <div class="input-clear cc_pointer" title="清空" style="display: block;"></div>-->
<!--      <div class="searchbox-content-button right-button loading-button cc_pointer route-button"-->
<!--           data-title="路线" data-tooltip="1" @click="showPanel">-->
<!--        &lt;!&ndash;                <i class="el-icon-position" id="luxian"></i>&ndash;&gt;-->
<!--        &lt;!&ndash;                <i id="luxian"> </i>&ndash;&gt;-->
<!--        <button id="luxian-button"></button>-->
<!--        &lt;!&ndash;            ::before&ndash;&gt;-->
<!--      </div>-->
<!--    </div>-->

<!--    <div id="route-searchbox-content" class="searchbox-content route-searchbox-content bus" style="display: none;">-->

<!--      <div class="route-header">-->
<!--        <div class="searchbox-content-common route-tabs cc_cursor">-->
<!--          &lt;!&ndash;                  <el-checkbox-group&ndash;&gt;-->
<!--          &lt;!&ndash;                          :min="1"&ndash;&gt;-->
<!--          &lt;!&ndash;                          :max="1">&ndash;&gt;-->
<!--          <div class="tab-item bus-tab cc_pointer" data-index="bus">-->
<!--            <el-checkbox v-model="checkedBus">-->
<!--              <i></i>-->
<!--              <span>公交</span>-->
<!--            </el-checkbox>-->
<!--          </div>-->
<!--          <div class="tab-item drive-tab cc_pointer" data-index="drive">-->
<!--            <el-checkbox v-model="checkedDrive">-->
<!--              <i></i>-->
<!--              <span>驾车</span>-->
<!--            </el-checkbox>-->
<!--          </div>-->
<!--          <div class="tab-item walk-tab cc_pointer" data-index="walk">-->
<!--            <el-checkbox v-model="checkedWalk">-->
<!--              <i></i>-->
<!--              <span>步行</span>-->
<!--            </el-checkbox>-->
<!--          </div>-->
<!--          <div class="tab-item bike-tab cc_pointer" data-index="bike">-->
<!--            <el-checkbox v-model="checkedBike">-->
<!--              <i></i>-->
<!--              <span>骑行</span>-->
<!--            </el-checkbox>-->
<!--          </div>-->
<!--          &lt;!&ndash;                  </el-checkbox-group>&ndash;&gt;-->
<!--          <div class="arrow-wrap"></div>-->
<!--        </div>-->
<!--      </div>-->

<!--      <div class="routebox cc_cursor">-->

<!--        <div class="searchbox-content-common routebox-content">-->

<!--          <div class="routebox-revert cc_pointer" title="切换起终点">-->
<!--            <div class="routebox-revert-icon cc_pointer">-->
<!--            </div>-->
<!--          </div>-->

<!--          <div class="routebox-inputs cc_cursor">-->

<!--            <div class="routebox-input route-start cc_cursor">-->
<!--              <div class="route-input-icon">-->
<!--              </div>-->
<!--              <input autocomplete="off" maxlength="256" placeholder="输入起点"-->
<!--                     class="route-start-input cc_cursor" type="text"-->
<!--                     v-model="startKeyword">-->
<!--              <div class="input-clear" title="清空" style="display: none;">-->
<!--              </div>-->
<!--              <div class="route-input-add-icon">-->
<!--              </div>-->
<!--            </div>-->

<!--            <div class="routebox-input route-end">-->
<!--              <div class="route-input-icon">-->
<!--              </div>-->
<!--              <input autocomplete="off" maxlength="256" placeholder="输入终点" class="route-end-input cc_cursor"-->
<!--                     type="text" v-model="endKeyword">-->
<!--              <div class="input-clear" title="清空" style="display: block;">-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->

<!--        </div>-->

<!--      </div>-->
<!--    </div>-->
<!--  </div>-->


<!--  <button id="search-button" data-title="搜索" data-tooltip="2"></button>-->
<!--  &lt;!&ndash;搜索地点&ndash;&gt;-->
<!--  <bm-local-search :keyword="keyword" :auto-viewport="true" :location="北京"></bm-local-search>-->

<!--  &lt;!&ndash;公交路线规划&ndash;&gt;-->
<!--  <div v-if="checkedBus">-->
<!--    <bm-transit :start="startKeyword" :end="endKeyword" :auto-viewport="true" location="北京"></bm-transit>-->
<!--  </div>-->

<!--  &lt;!&ndash;驾车路线规划&ndash;&gt;-->
<!--  <div v-if="checkedDrive">-->
<!--    <bm-driving :start="startKeyword" :end="endKeyword" :auto-viewport="true" location="北京"></bm-driving>-->
<!--  </div>-->

<!--  &lt;!&ndash;行走路线规划&ndash;&gt;-->
<!--  <div v-if="checkedWalk">-->
<!--    <bm-walking :start="startKeyword" :end="endKeyword" :auto-viewport="true" location="北京"></bm-walking>-->
<!--  </div>-->

<!--</div>-->

<!--</bm-control>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  methods:{-->
<!--    //显示面板-->
<!--    showPanel() {-->
<!--      // console.log("showPanel")-->
<!--      var data = document.getElementById('route-searchbox-content').style.cssText-->
<!--      console.log(data)-->
<!--      // display: none;-->
<!--      if(data == "display: block;") {-->
<!--        document.getElementById('route-searchbox-content').style.cssText = "display: none;"-->
<!--      }else if(data == "display: none;"){-->
<!--        document.getElementById('route-searchbox-content').style.cssText = "display: block;"-->
<!--      }-->

<!--    }-->

<!--  }-->
<!--}-->
<!--</script>-->
