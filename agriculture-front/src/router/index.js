import Vue from 'vue'
import Router from 'vue-router'
import Test1 from "../views/devviews/Test1";
import Test2 from "../views/devviews/Test2";
import {dev} from "../../config";
import store from "../store";

Vue.use(Router)

const routes=[
  {
    path: '/',
    name: 'Login',
    component:()=>import ('@/views/Login'),
  },
  {
    path: '/register',
    name: 'Register',
    component:()=>import ('@/views/Register'),
  },
  {
    path:'/index',
    name:'Index',
    component:()=>import ('@/frontviews/Index'),
  },
  {
    path:'/cart',
    name:'Cart',
    component:()=>import ('@/views/devviews/Cart'),
  },
  {
    path:'/home',
    name:'Home',
    component:()=>import ('@/views/frontviews/home/Home'),
  },
  {
    path:'/travel',
    name:'Travel',
    component:()=>import ('@/views/frontviews/travel/Travel'),
  },
  {
    path:'/test',
    name:'Test',
    component:()=>import ('@/views/frontviews/Test'),
  },
  {
    path:'/404',
    name:'NotFound',
    component:()=>import ('@/views/404'),
  },
]


const VueRouterPush = Router.prototype.push
Router.prototype.push = function push (to) {
  return VueRouterPush.call(this, to).catch(err => err)
}

const router = new Router({
  mode: 'history',
  base: './',
  routes
})

// 提供一个重置路由的方法
export const resetRouter = () => {
  router.matcher = new Router({
    mode: 'history',
    base:'./',
    routes
  })
}

// // 注意：刷新页面会导致页面路由重置
// export const setRoutes = () => {
//   const storeMenus = localStorage.getItem("menus");
//   if (storeMenus) {
//
//     // 获取当前的路由对象名称数组
//     const currentRouteNames = router.getRoutes().map(v => v.name)
//     if (!currentRouteNames.includes('Manage')) {
//       // 拼装动态路由
//       const manageRoute = { path: '/', name: 'Manage', component: () => import('../views/Manage.vue'), meta:{
//           title: '农旅信息管理后台'
//         }, redirect: "/login",
//         children: [
//           { path: 'person', name: '个人信息', component: () => import('../views/Person.vue')},
//           { path: 'password', name: '修改密码', component: () => import('../views/Password.vue')}
//         ] }
//       const menus = JSON.parse(storeMenus)
//       menus.forEach(item => {
//         if (item.path) {  // 当且仅当path不为空的时候才去设置路由
//           let itemMenu = { path: item.path.replace("/", ""), name: item.name, component: () => import('../views/' + item.pagePath + '.vue')}
//           manageRoute.children.push(itemMenu)
//         } else if(item.children.length) {
//           item.children.forEach(item => {
//             if (item.path) {
//               let itemMenu = { path: item.path.replace("/", ""), name: item.name, component: () => import('../views/' + item.pagePath + '.vue')}
//               manageRoute.children.push(itemMenu)
//             }
//           })
//         }
//       })
//       // 动态添加到现在的路由对象中去
//       router.addRoute(manageRoute)
//     }
//
//   }
// }

// // 重置我就再set一次路由
// setRoutes()


router.beforeEach((to, from, next) => {
  localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称
  store.commit("setPath")

  // 未找到路由的情况
  if (!to.matched.length) {
    const storeMenus = localStorage.getItem("menus")
    if (storeMenus) {
      next("/404")
    } else {
      // 跳回登录页面
      next("/login")
    }
  }
  // 其他的情况都放行
  next()

})

export default router
