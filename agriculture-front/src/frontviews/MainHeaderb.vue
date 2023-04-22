<template>
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
</template>

<script>
    
    export default{
        name:"MainHeader",
        data(){
            return{

            }
        }
    }
</script>

<style>

</style>