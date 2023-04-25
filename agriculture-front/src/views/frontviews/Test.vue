<template>
  <div>
    <div id="allmap" class="allmap"></div>
  </div>
</template>

<script>

export default {
  name: "Test",
  data(){
    return{

    }
  },
  mounted() {
    //初始化
    // 创建Map实例
    this.map = new BMap.Map("allmap");
    // 初始化地图,设置中心点坐标和地图级别
    this.map.centerAndZoom("成都", this.mapZoom);
    // 设置地图显示的城市 此项是必须设置的
    this.map.setCurrentCity("成都");
    // 启用滚轮放大缩小，默认禁用
    this.map.enableScrollWheelZoom(true);
    // 启用地图惯性拖拽，默认禁用
    this.map.enableContinuousZoom(true);
    // 启用地图拖拽，默认启用
    this.map.enableDragging(true);

    const cityControl = new BMap.CityListControl({
      /*
  	控件的停靠位置（可选，默认左上角）
  	BMAP_ANCHOR_TOP_RIGHT 右上角
  	BMAP_ANCHOR_BOTTOM_LEFT 左下角
  	BMAP_ANCHOR_BOTTOM_RIGHT 右下角
    */
      anchor: BMAP_ANCHOR_TOP_LEFT,
      // 控件基于停靠位置的偏移量（可选）
      offset: new BMap.Size(10, 5),
    });
    // 将控件添加到地图上
    this.map.addControl(cityControl);
  },


}
</script>

<style scoped>
.logo{
  border-radius: 50px;
  box-shadow: 2px 2px 0 rgba(0,0,0,0.4);
}
</style>
