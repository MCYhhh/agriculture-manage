<template>
    <div>
        <el-row :gutter="10" class="HeaderMain">
            <el-col :span="3" class="FirstButton">
                <el-popover
                    placement="top-start"
                    width="200"
                    title="一站式解决旅游攻略"
                    trigger="hover"
                    content="将根据您的需求为您设计出最合适的旅游路线！">
                    <el-button type="success" plain slot="reference">旅游规划</el-button>
                </el-popover>
            </el-col>    
            
            <el-col :span="3">
                <el-popover
                        placement="top-start"
                        width="200"
                        title="原产地美食等你"
                        trigger="hover"
                        content="包含种类丰富的当地农产品，快来看看都有什么吧！">
                        <el-button type="success" plain slot="reference">农产品</el-button>
                </el-popover>
            </el-col>
                
            <el-col :span="3">
                <el-popover
                        placement="top-start"
                        width="200"
                        title="购物一览表"
                        trigger="hover"
                        content="包含您在本平台消费的所有的产品订单">
                        <el-button  type="success" plain slot="reference">订单</el-button>
                    </el-popover> 
            </el-col>
                    
            <el-col :span="3">
                <el-popover
                        placement="top-start"
                        width="200"
                        title="共赏美景，共品佳肴"
                        trigger="hover"
                        content="请一起为我们美丽的叉叉宣传助力吧！">
                        <el-button type="success" plain slot="reference">宣传助力</el-button>
                    </el-popover>
            </el-col>
                    
            <el-col :span="3">
                <el-popover
                        placement="top-start"
                        width="200"
                        title="看看别人说了啥"
                        trigger="hover"
                        content="发布帖子和大家一起分享你的见闻吧！">
                        <el-button type="success" plain slot="reference">社区</el-button>
                    </el-popover>
            </el-col>
                    
            <el-col :span="3">
                <el-popover
                        placement="top-start"
                        width="200"
                        title="个人主界面"
                        trigger="hover"
                        content="查看你的个人信息等内容可以来这里哦！">
                        <el-button type="success" plain slot="reference">我的</el-button>
                    </el-popover>
            </el-col>
        </el-row>                       
    </div>
</template>

<script>
    
    export default{
        name:"MainHeadera",
        data(){
            return{

            }
        }
    }
</script>

<style>
    .FirstButton{
        margin-left: 240px;
    }
    .el-button{
        font-size: 20px;
    }
    .HeaderMain{
        padding-top: 10px;
    }
</style>