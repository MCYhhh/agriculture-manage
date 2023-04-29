import Vue from 'vue'
import Router from 'vue-router'
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
    path:'/front',
    name:'Front',
    component:()=>import ('@/views/frontviews/Front'),
    redirect: '/front/home',
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () => import ('@/views/frontviews/home/Home'),
      },
      {
        path: 'self',
        name: 'Self',
        component: () => import ('@/views/frontviews/self/Self'),
        redirect:'/front/self/home',
        children:[
          {
            path: 'home',
            name: 'Home',
            component: () => import ('@/views/frontviews/self/Home'),
          },
          {
            path: 'infochange',
            name: 'Infochange',
            component: () => import ('@/views/frontviews/self/Infochange'),
          }
        ]
      },
      {
        path: 'travel',
        name: 'Travel',
        component: () => import ('@/views/frontviews/travel/Home'),
      },
      {
        path: 'community',
        name: 'Community',
        component: () => import ('@/views/frontviews/community/Home'),
      },
      {
        path: 'game',
        name: 'Game',
        component: () => import ('@/views/frontviews/game/Home'),
      },
      {
        path: 'shop',
        name: 'Shop',
        component: () => import ('@/views/frontviews/shop/Home'),
      },
    ]
  },
  {
    path: '/admin',
    name: 'Admin',
    component:()=>import ('@/views/devviews/admin/Admin'),
    redirect: '/admin/home',
    children: [
      {
        path: 'home',
        name: 'Home',
        component:()=>import ('@/views/devviews/admin/Home'),
      },
      {
        path: 'order',
        name: 'OrderManage',
        component:()=>import ('@/views/devviews/admin/OrderManage'),
      },
      {
        path: 'user',
        name: 'UserManage',
        component:()=>import ('@/views/devviews/admin/UserManage'),
      },
      {
        path: 'system',
        name: 'SystemManage',
        component:()=>import ('@/views/devviews/admin/SystemManage'),
      },
      {
        path: 'goods',
        name: 'GoodsManage',
        component:()=>import ('@/views/devviews/admin/GoodsManage'),
      },
      {
        path: 'scenery',
        name: 'SceneryManage',
        component:()=>import ('@/views/devviews/admin/SceneryManage'),
      },
      {
        path: 'auth',
        name: 'AuthManage',
        component:()=>import ('@/views/devviews/admin/AuthManage'),
      },
      {
        path: 'role',
        name: 'RoleManage',
        component:()=>import ('@/views/devviews/admin/RoleManage'),
      },
    ]
  },
  {
    path: '/shopper',
    name: 'Shopper',
    component:()=>import ('@/views/devviews/shopper/Shopper'),
    redirect: '/shopper/home',
    children:[
      {
        path:'home',
        name:'Home',
        component:()=>import ('@/views/devviews/shopper/Home'),
      },
      {
        path:'order',
        name:'OrderManage',
        component:()=>import ('@/views/devviews/shopper/OrderManage'),
      },
      {
        path:'user',
        name:'UserManage',
        component:()=>import ('@/views/devviews/shopper/UserManage'),
      },
      {
        path:'goods',
        name:'GoodsManage',
        component:()=>import ('@/views/devviews/shopper/GoodsManage'),
      },
      {
        path: 'scenery',
        name: 'SceneryManage',
        component: () => import ('@/views/devviews/shopper/SceneryManage'),
      }
    ]
  },
  {
    path:'/cart',
    name:'Cart',
    component:()=>import ('@/views/devviews/Cart'),
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


// const VueRouterPush = Router.prototype.push
// Router.prototype.push = function push (to) {
//   return VueRouterPush.call(this, to).catch(err => err)
// }
//
const originalPush = Router.prototype.push
Router.prototype.push = function push(location, onResolve, onReject) {
  if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
  return originalPush.call(this, location).catch(err => err)
}


//
const router = new Router({
  mode: 'history',
  base: './',
  routes
})

// // 提供一个重置路由的方法
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
//       const manageRoute = {
//         path: '/front', name: 'Front', component: () => import('@/views/frontviews/Front'), meta: {
//           title: '农旅信息管理后台'
//         }, redirect: "/login",
//         children: [
//           {
//             path: 'home',
//             name: 'Home',
//             component: () => import ('@/views/frontviews/home/Home'),
//           },
//           {
//             path: 'self',
//             name: 'Self',
//             component: () => import ('@/views/frontviews/self/Home'),
//           },
//           {
//             path: 'travel',
//             name: 'Travel',
//             component: () => import ('@/views/frontviews/travel/Home'),
//           },
//           {
//             path: 'community',
//             name: 'Community',
//             component: () => import ('@/views/frontviews/community/Home'),
//           },
//           {
//             path: 'game',
//             name: 'Game',
//             component: () => import ('@/views/frontviews/game/Home'),
//           },
//           {
//             path: 'shop',
//             name: 'Shop',
//             component: () => import ('@/views/frontviews/shop/Home'),
//           },
//         ]
//       }
//       // const menus = JSON.parse(storeMenus)
//       // menus.forEach(item => {
//       //   if (item.path) {  // 当且仅当path不为空的时候才去设置路由
//       //     let itemMenu = { path: item.path.replace("/", ""), name: item.name, component: () => import('../views/' + item.pagePath + '.vue')}
//       //     manageRoute.children.push(itemMenu)
//       //   } else if(item.children.length) {
//       //     item.children.forEach(item => {
//       //       if (item.path) {
//       //         let itemMenu = { path: item.path.replace("/", ""), name: item.name, component: () => import('../views/' + item.pagePath + '.vue')}
//       //         manageRoute.children.push(itemMenu)
//       //       }
//       //     })
//       //   }
//       // })
//       // 动态添加到现在的路由对象中去
//       router.addRoute(manageRoute)
//     }

//   }
// }
//
// // 重置我就再set一次路由
// setRoutes()


// router.beforeEach((to, from, next) => {
//   localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称
//   store.commit("setPath")
//
//   // 未找到路由的情况
//   if (!to.matched.length) {
//     const storeMenus = localStorage.getItem("menus")
//     if (storeMenus) {
//       next("/404")
//     } else {
//       // 跳回登录页面
//       next("/login")
//     }
//   }
//   // 其他的情况都放行
//   next()
//
// })

//路由导航守卫
router.beforeEach((to, from, next) => {
  //判断是否是登录页，如果是接着下一步
  if (to.path === '/') return next()
  //    获取token
  const tokenStr = localStorage.getItem('token')
  //判断token是否存在，
  if (!tokenStr) {
    return next('/')

  }
  next()
})

export default router
