
<template>
  <div>
    <baidu-map :ak="yourAk">
      <route-plan :plan="plan" :renderOptions="renderOptions"></route-plan>
    </baidu-map>
  </div>
</template>

<script>

import BaiduMap from "vue-baidu-map";
import RoutePlan from "vue-baidu-map";

export default {
  components: {
    BaiduMap,
    RoutePlan,
  },
  data() {
    return {
      yourAk: 'XZnOK8f5Kf9q3IDnx1i1aBUQ5RKHLSl7', // 在这里替换成您的百度地图AK
      plan: {
        startCity: '北京',
        endCity: '上海',
        mode: 'driving,transit,walking',
      },
      renderOptions: {
        map: null,
        autoViewport: true,
        panel: 'panel',
        selectFirstResult: true,
      },
    }
  },
}
</script>
