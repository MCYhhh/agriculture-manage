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
    // {
    //   path: '/',
    //   name: 'Login',
    //   component: HelloWorld,
    //   children:[
    //     {
    //       path: '/test1',
    //       name: 'Test1',
    //       component: Test1
    //     },
    //   ]
    // },
  ]
})

const VueRouterPush = Router.prototype.push
Router.prototype.push = function push (to) {
  return VueRouterPush.call(this, to).catch(err => err)
}
