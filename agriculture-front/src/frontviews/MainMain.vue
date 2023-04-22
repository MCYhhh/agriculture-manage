<template>
    <div class="block">
        <el-row>
            <el-col>
                <el-carousel   :interval="5000" arrow="always"  height="400px">
                    <el-carousel-item v-for=" item in banners" :key="item.src">
                    <img  style="width:800px;height:500px " :src="item">
                    </el-carousel-item>
                </el-carousel>
            </el-col>    
        </el-row>
    </div>
</template>

<script>
    export default{
        name:"MainMain",
        data(){
            return{
                banners: [
                    require('../../src/assets/images/xinjiang.jpg'),
                    require('../../src/assets/images/xinjiang.jpg'),
                    require('../../src/assets/images/xinjiang.jpg')
                ]
            }
        }
    }
</script>