<template>
  <div class="img" style="margin-left: 20px;padding: 5px">
    <img src="../assets/images/logo.jpg" class="logo" width="100px">
    <img src="../assets/images/font.png" height="100px">
    <p style="float: right;margin-right: 120px;margin-top: 70px">
      <el-dropdown @command="chooseValue">
        <span class="el-dropdown-link">
          <i class="el-icon-caret-bottom"  style="margin-right: 15px;padding-right: -18px;font-size: 18px" >{{ uname }}</i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item v-for="item in option1" :key="item.value" :command="item.label">
            <span>{{item.label}}</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </p>
  </div>
</template>

<script>
import {logoutAPI} from "../api";
import {resetRouter, setRoutes} from "../router";
export default {
  name: "Logo",
  data(){
    return{
      uname:"",
      option1:[
        {label:'返回首页',value:0},
        {label:'进入后台',value:1},
        {label:'注销',value:2},
      ]
    }
  },
  methods:{
   async chooseValue(label){
      if(label==="返回首页"){
        this.$router.push('/front/home')
      }
      else if (label==="进入后台"){
        const utype=JSON.parse(localStorage.getItem('user')).utype;
       // resetRouter()
       //  if(utype===2)
       //    this.$router.push('/admin')
       //  else if(utype===1)
       //    this.$router.push('/shopper')
      }
      else{
        console.log("注销")
        const {data:res}=await logoutAPI()
        if(res.code === '00000'){
          localStorage.removeItem('user')
          localStorage.removeItem('menus')
          this.$router.push("/")
        }
      }
    }
  },
  created() {
    this.uname=JSON.parse(localStorage.getItem('user')).uname
  }
}
</script>

<style scoped>
.logo{
  border-radius: 50px;
  box-shadow: 2px 2px 0 rgba(0,0,0,0.4);
}
</style>
