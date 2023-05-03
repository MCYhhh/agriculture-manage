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
            path: 'order',
            name: 'OrderManage',
            component: () => import ('@/views/frontviews/self/OrderManage'),
          },
          {
            path: 'info',
            name: 'Info',
            component: () => import ('@/views/frontviews/self/Info'),
          },
          {
            path: 'reserve',
            name: 'Reserve',
            component: () => import ('@/views/frontviews/self/Reserve'),
          },
          {
            path: 'trolley',
            name: 'Trolley',
            component: () => import ('@/views/frontviews/self/Trolley'),
          },
        ]
      },
      {
        path: 'travel',
        name: 'Travel',
        component: () => import ('@/views/frontviews/travel/Home'),
      },
      {
        path: 'mustgo',
        name: 'mustgo',
        component: () => import ('@/views/frontviews/travel/Mustgo'),
      },
      {
        path: 'hot',
        name: 'Hot',
        component: () => import ('@/views/frontviews/travel/Hot'),
      },
      {
        path: 'community',
        name: 'Community',
        component: () => import ('@/views/frontviews/community/Home'),
      },
      {
        path: 'game',
        name: 'Game',
        component: () => import ('@/views/frontviews/Game/Home'),
        children: [

        ]
      },
      {
        path: 'shop',
        name: 'Shop',
        component: () => import ('@/views/frontviews/shop/Home'),
      },
    ]
  },
  {
    path: '/front/transport',
    name: 'Transport',
    component: () => import ('@/views/frontviews/travel/Transport'),
  },
  {
    path: '/front/accomodation',
    name: 'Accommodation',
    component: () => import ('@/views/frontviews/travel/Accommodation'),
  },
  {
    path: '/front/ethnic',
    name: 'Ethnic',
    component: () => import ('@/views/frontviews/travel/Ethnic'),
  },
  {
    path: '/front/mustgo',
    name: 'mustgo',
    component: () => import ('@/views/frontviews/travel/Mustgo'),
  },
  {
    path: '/front/hot',
    name: 'Hot',
    component: () => import ('@/views/frontviews/travel/Hot'),
  },
  {
    path: '/front/transport',
    name: 'Transport',
    component: () => import ('@/views/frontviews/travel/Transport'),
  },
  {
    path: '/front/accomodation',
    name: 'Accommodation',
    component: () => import ('@/views/frontviews/travel/Accommodation'),
  },
  {
    path: '/front/ethnic',
    name: 'Ethnic',
    component: () => import ('@/views/frontviews/travel/Ethnic'),
  },
  {
    path: '/front/mustgo',
    name: 'mustgo',
    component: () => import ('@/views/frontviews/travel/Mustgo'),
  },
  {
    path: '/front/hot',
    name: 'Hot',
    component: () => import ('@/views/frontviews/travel/Hot'),
  },
  {
    path: '/front/detail',
    name: 'Detail',
    component: () => import ('@/views/frontviews/travel/Detail'),
  },
  {
    path: '/front/game/detail',
    name: 'Detail',
    component: () => import ('@/views/frontviews/Game/ArticleDetail'),
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
      // {
      //   path: 'system',
      //   name: 'SystemManage',
      //   component:()=>import ('@/views/devviews/admin/SystemManage'),
      // },
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
      // {
      //   path: 'auth',
      //   name: 'AuthManage',
      //   component:()=>import ('@/views/devviews/admin/AuthManage'),
      // },
      // {
      //   path: 'role',
      //   name: 'RoleManage',
      //   component:()=>import ('@/views/devviews/admin/RoleManage'),
      // },
      {
        path:'reserve',
        name:'Reserve',
        component:()=>import ('@/views/devviews/admin/Reserve'),
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
      },
      {
        path:'reserve',
        name:'Reserve',
        component:()=>import ('@/views/devviews/shopper/Reserve'),
      },
    ]
  },
  {
    path:'/404',
    name:'NotFound',
    component:()=>import ('@/views/404'),
  },
  {
    path: '/file',
    name: 'file',
    component: () => import ('@/views/file'),
  },
]


// const VueRouterPush = Router.prototype.push
// Router.prototype.push = function push (to) {
//   return VueRouterPush.call(this, to).catch(err => err)
// }
//
// const originalPush = Router.prototype.push
// Router.prototype.push = function push(location, onResolve, onReject) {
//   if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
//   return originalPush.call(this, location).catch(err => err)
// }


//
const router = new Router({
  mode: 'history',
  base: './',
  routes
})

// // // 提供一个重置路由的方法
// export const resetRouter = () => {
//   router.matcher = new Router({
//     mode: 'history',
//     base:'./',
//     routes
//   })
// }

// 注意：刷新页面会导致页面路由重置
export const setRoutes = () => {
  const storeMenus = localStorage.getItem("menus");
  if (storeMenus) {

    // 获取当前的路由对象名称数组
    const currentRouteNames = router.getRoutes().map(v => v.mtitle)
    if (currentRouteNames.includes('admin')) {
      // 拼装动态路由
      const adminRoute = {
        path: '/admin', name: 'Admin', component: () => import ('@/views/devviews/admin/Admin'), meta: {
          title: '管理员后台'
        }, redirect: '/admin/home'
      }
      const menus = JSON.parse(storeMenus)
      menus.forEach(item => {
        if (item.mpath) {  // 当且仅当path不为空的时候才去设置路由
          let itemMenu = {
            path: item.mpath.replace("/", ""),
            name: item.mtitle,
            component: () => import('@/views/devviews/admin/' + item.mrouter + '.vue')
          }
          adminRoute.children.push(itemMenu)
        } else if (item.children.length) {
          item.children.forEach(item => {
            if (item.mpath) {
              let itemMenu = {
                path: item.mpath.replace("/", ""),
                name: item.mtitle,
                component: () => import('@/views/devviews/admin/' + item.mrouter + '.vue')
              }
              adminRoute.children.push(itemMenu)
            }
          })
        }
      })
      // 动态添加到现在的路由对象中去
      router.addRoute(adminRoute)
    }
    if (currentRouteNames.includes('shopper')) {
      // 拼装动态路由
      const adminRoute = {
        path: '/shopper', name: 'Shopper', component: () => import ('@/views/devviews/shopper/Shopper'), meta: {
          title: '商家后台'
        }, redirect: '/shopper/home'
      }
      const menus1 = JSON.parse(storeMenus)
      menus1.forEach(item => {
        if (item.mpath) {  // 当且仅当path不为空的时候才去设置路由
          let itemMenu = {
            path: item.mpath.replace("/", ""),
            name: item.mtitle,
            component: () => import('@/views/devviews/shopper/' + item.mrouter + '.vue')
          }
          adminRoute.children.push(itemMenu)
        } else if (item.children.length) {
          item.children.forEach(item => {
            if (item.mpath) {
              let itemMenu = {
                path: item.mpath.replace("/", ""),
                name: item.mtitle,
                component: () => import('@/views/devviews/shopper/' + item.mrouter + '.vue')
              }
              adminRoute.children.push(itemMenu)
            }
          })
        }
      })
      // 动态添加到现在的路由对象中去
      router.addRoute(adminRoute)
    }

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
          next("/")
        }
      }
      // 其他的情况都放行
      next()

    })
  }
}
export default router
