<template>
  <div class="nav-container">
    <el-menu class="el-menu-demo" mode="horizontal"
             :router="true"
             text-color="#fff"
             v-for="item in nav" :key="nav.id">
      <el-menu-item :index='item.path' style=" font-size: 22px;">{{item.name}}</el-menu-item>
    </el-menu>
<!--    <el-menu :router='true'-->
<!--             active-text-color='#ffd04b'-->
<!--             mode="horizontal"-->
<!--             v-for="item in nav" :key="nav.id"-->
<!--    >-->
<!--      <el-menu-item :index='item.path'>{{item.name}}-->
<!--                  <el-popover-->
<!--                    placement="top-start"-->
<!--                    :title="item.title"-->
<!--                    trigger="hover"-->
<!--                    :content="item.content">-->
<!--                  </el-popover>-->
<!--      </el-menu-item>-->
<!--    </el-menu>-->
<!--    <el-row :gutter="15" class="nav-row">-->
<!--      <el-col :span="3" class="first-nav-col">-->
<!--        <router-link to="home" v-for="item in nav" :key="item.id" :to="item.path">-->
<!--          <el-popover-->
<!--            placement="top-start"-->
<!--            width="200"-->
<!--            :title="item.title"-->
<!--            trigger="hover"-->
<!--            :content="item.content">-->
<!--&lt;!&ndash;            {{item.name}}&ndash;&gt;-->
<!--&lt;!&ndash;            <span slot="name">{{item.name}}</span>&ndash;&gt;-->
<!--            <el-button type="success" plain slot="reference" class="btn">{{item.name}}</el-button>-->
<!--          </el-popover>-->
<!--        </router-link>-->
<!--      </el-col>-->

<!--    </el-row>-->

  </div>
</template>

<script>
export default {
  name: "Nav",
  data(){
    return{
      nav:[
        {id:1,title:'一站式解决旅游攻略',content:'将根据您的需求为您设计出最合适的旅游路线',path:'/front/home',name:'首页'},
        {id:2,title:'一站式解决旅游攻略',content:'将根据您的需求为您设计出最合适的旅游路线',path:'/front/travel',name: '旅游规划'},
        {id:3,title:'一站式解决旅游攻略',content:'将根据您的需求为您设计出最合适的旅游路线',path:'/front/shop',name: '惠农惠物'},
        {id:4,title:'一站式解决旅游攻略',content:'将根据您的需求为您设计出最合适的旅游路线',path:'/front/community',name: '社区中心'},
        {id:5,title:'一站式解决旅游攻略',content:'将根据您的需求为您设计出最合适的旅游路线',path:'/front/game',name: '宣传助力'},
        {id:6,title:'一站式解决旅游攻略',content:'将根据您的需求为您设计出最合适的旅游路线',path:'/front/self/home',name: '个人中心'},
      ]
    }
  }
}
</script>

<style scoped>
  .nav-container{
    background-image: linear-gradient(120deg, #7fb2ec, #a79cf1);
    padding: 5px 0 0 250px;
    margin:0 -20px;
    height: 40px;
  }

  .el-menu{
    width: 200px;
    height: 40px;
    display: inline-block;
    padding-right: 20px;
    background-color:rgba(0,0,0,0);
    margin-top: -10px;
    border-bottom: 0;
  }

  /deep/.el-menu .el-menu-item:hover{
    /*outline: 0 !important;*/
    color: #2E95FB !important;
    background-color:rgba(0,0,0,0)!important;
  }
  /deep/.el-menu .el-menu-item.is-active {
    /*outline: 0 !important;*/
    color: #ffffff !important;
    background-color:rgba(0,0,0,0)!important;
    border-bottom: none;
  }


</style>
