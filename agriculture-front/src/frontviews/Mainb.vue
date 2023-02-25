<template>
    <div>
        <div class="direct">
            <el-row>
                <el-col :span="20" class="directentity">
                    <div class="directbutton">
                        <el-button type="success" plain>旅游规划</el-button>
                        <el-button type="primary" plain>农产品</el-button>
                        <el-button type="info" plain>订单</el-button>
                        <el-button type="warning" plain>宣传助力</el-button>
                        <el-button type="danger" plain>社区</el-button>
                        <el-button type="success" plain>我的</el-button>
                    </div>
                </el-col>
            </el-row>
        </div>
        
        <div class="block">
            <el-row>
                <el-col>
                    <p></p>
                </el-col>
                
                <el-col>
                    <el-carousel   :interval="5000" arrow="always"  height="400px">
                        <el-carousel-item v-for=" item in banners" :key="item.src">
                        <img  style="width:800px;height:500px " :src="item">
                        </el-carousel-item>
                    </el-carousel>
               </el-col> 
                
            </el-row>
        </div>

        <div>
            <p>后面的内容</p>
        </div>
    </div>
    
</template>

<script>
    export default{
        name:"Mainb",
        data(){
            return{
                banners: [
                    require('../../src/assets/images/background.jpg'),
                    require('../../src/assets/images/background.jpg'),
                    require('../../src/assets/images/background.jpg')
                ]
            }
        },
        methods:{ }
    }
</script>

<style scoped>
    .direct{
        margin-top: 1px;
    }
    .directentity{
        margin-left:100px;
        margin-right:100px;
        background:rgba(237, 240, 218, 0.768);
        line-height: 50px;
    }
    .directbutton{
        margin-left: 100px;
        margin-right: 100px;
    }
    .el-button{
        margin-left:60px; 
        font-size: large;
    }
    .block{
        margin-top:30px;
        margin-left: 350px;
        margin-right: 350px;
        background-color: aliceblue;
    }
    .el-carousel_item h3{
        color:bisque;
        font-size: 14px;
        opacity:0.75;
        line-height:300px;
        margin:0;
    }


    .carousel{
        color:aqua;
    }
</style>