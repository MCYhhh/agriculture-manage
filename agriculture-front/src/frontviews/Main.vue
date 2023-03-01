<template>
    <div class="Maindiv">
        <MainHeader></MainHeader>
        <MainMain></MainMain>
        <div>
            <p></p>
        </div>
    </div>
    
</template>

<script>
    import MainHeader from "./MainHeader.vue"
    import MainMain from "./MainMain.vue"
    export default{
        name:"Mainb",
        data(){
            return{
        
            }
        },
        methods:{ },
        components:{
            MainHeader,MainMain
        },
    }
</script>

<style scoped>
    .Maindiv{
        background-image: url("../assets/images/background.jpg");
        height:800px;
    }
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