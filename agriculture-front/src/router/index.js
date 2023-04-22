import Vue from 'vue'
import Router from 'vue-router'
import Test1 from "../views/devviews/Test1";
import Test2 from "../views/devviews/Test2";

Vue.use(Router)

export default new Router({
  routes: [
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
  ]
})

const VueRouterPush = Router.prototype.push
Router.prototype.push = function push (to) {
  return VueRouterPush.call(this, to).catch(err => err)
}
