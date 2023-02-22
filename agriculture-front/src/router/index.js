import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Test1 from "../devviews/Test1";
import Test2 from "../devviews/Test2";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      children:[
        {
          path: '/test1',
          name: 'Test1',
          component: Test1
        },
        {
          path: '/test2',
          name: 'Test2',
          component: Test2
        }
      ]
    },
  ]
})

const VueRouterPush = Router.prototype.push
Router.prototype.push = function push (to) {
  return VueRouterPush.call(this, to).catch(err => err)
}
