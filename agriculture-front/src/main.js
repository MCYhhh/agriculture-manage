// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//引入地图
//导入Vant组件
import Vant from 'vant';
import 'vant/lib/index.css';
import store from "./store";
// import BaiduMap from 'vue-baidu-map'
// Vue.use(BaiduMap, {
//   ak: 'XZnOK8f5Kf9q3IDnx1i1aBUQ5RKHLSl7'  //这个地方是官方提供的ak密钥
// })



Vue.use(ElementUI,{size:"small"})
Vue.use(Vant)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})

// Vue.use(BaiduMap, { ak: 'XZnOK8f5Kf9q3IDnx1i1aBUQ5RKHLSl7' })

// Vue.use(VueAMap);
// VueAMap.initAMapApiLoader({
// //修改下面的key值
//   key: '5ab0ce0f11ed78656df74d8a41c15a2b',
//   // plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor'],
//   plugin: ['AMap.Geolocation','AMap.Scale','AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor'],
//   // 默认高德 sdk 版本为 1.4.4
//   // v: '1.4.4'
// });
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
