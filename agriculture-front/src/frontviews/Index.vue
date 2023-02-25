<template>
    <el-container style="height: 1000px; border: 1px solid #eee">
        <el-container>
            <el-header style="height:50px">
                <Header></Header>
            </el-header>
            <el-main>
                <Main></Main>
            </el-main>
            <el-footer>
                <Footer></Footer>
            </el-footer>
        </el-container>
    </el-container>
</template>

<style scoped>

</style>

<script>
  import Header from "./Head.vue"
  import Main from "./Mainb.vue"
  import Footer from "./Footer.vue"
  export default {
    name:"Index",
    components:{
        Header,Main,Footer
    },
    data(){
        return{
          
        }
    }
  };
</script>