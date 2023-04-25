<template>
  <div>
    <baidu-map :ak="yourAk"></baidu-map>
  </div>
</template>

<script>
// import BaiduMap from 'vue-baidu-map'

import BaiduMap from "vue-baidu-map";

export default {
  components: {
    BaiduMap,
  },
  data() {
    return {
      yourAk: 'XZnOK8f5Kf9q3IDnx1i1aBUQ5RKHLSl7', // 在这里替换成您的百度地图AK
    }
  },
}
</script>
