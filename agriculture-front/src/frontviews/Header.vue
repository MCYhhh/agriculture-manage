<template>
    <header class="head-nav">
        <el-row>
            <el-col :span="1" class="imageicon">
                <el-image style="width:40px;height:40px;margin-top: 0px;" :src="img"></el-image>
            </el-col>
            
            <el-col :span="6" class="greating">
                <span class="welcome">您好! 欢迎来到新疆</span>
            </el-col>
            
            <el-col :span="6" class="user">
                <div>
                    <el-button type="primary" round>登录</el-button>
                    <el-button type="primary" round>注册</el-button>
                </div>
            </el-col>
            
        </el-row>

    </header>
</template>

<script>
    export default {
        name: "Headerb",
        data(){
            return{
                img:require('../../src/assets/images/logo.png'),
            }
            
        }
    };
</script>

<style scoped>
    .head-nav {
        width: 100%;
        height: 20px;
        padding-top:20px;
        background-color: rgb(208, 214, 214);
    }
    .imageicon{
      margin-top: -20px;
      margin-left: 30px;  
    }
    .greating {
        margin-top:-7px;
        line-height: 10px;
        min-width: 100px;
        padding-left: -5px;
    }
    .welcome {
        left:10px;
        vertical-align: middle;
        font-size: 20px;
        font-family: "Arial,Helvetica,sans-serif";
        letter-spacing: 3px;
        text-align: left;
        color:#00050c;
        font-weight:border;
        margin-left:0px;
        margin-top:10px;
    }
    .user {
        margin-top:-11px;
        line-height: 10px;
        text-align: right;
        float: right;
        padding-right: 20px;
        padding-top: -2px;   
    }

    .el-button {
        margin-top: -5px;
        font-size: 10px;
    }
</style>
