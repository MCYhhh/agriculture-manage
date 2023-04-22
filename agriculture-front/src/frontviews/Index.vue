<template>
    <el-container style="height: 1000px; border: 1px solid #eee">
        <el-container>
            <el-header style="height:20px">
                <Header></Header>
            </el-header>
            <el-main style="height:50px">
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
    import Header from "./Header.vue"
    import Main from "./Main.vue"
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