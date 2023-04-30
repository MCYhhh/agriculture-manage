<template>
 <div class="home-container">
   首页
 </div>
</template>
<script>

export default {
  name: "Home",
  data() {
    return{
      dialogFormVisible: false,
      user:{
        uid:1,
        uaccount:'account',
        uname:'uname',
        upwd:'upwd',
        utype:0,
        usex:"女",
        uemail:"tianyong@126.com",
        utel:"15349585890",
        uaddress:"江苏省苏州市吴中区吴中大道 1188 号",
        uimg:"yfuwn",
        udesp:"",
        state:0,
        create_time:"2012-1-12 21：21：12",
        update_time:""
      },
      user1:{}
    }
  },
  methods:{
    cancelinfo(){
      this.dialogFormVisible = false;
      console.log(this.user)
      console.log(this.user1)
    },
    confirminfo(){
      console.log(this.user.uname)
      this.dialogFormVisible = false;
      this.user=JSON.parse(JSON.stringify(this.user1));
    },
    modifyinfo(){
      this.user1=JSON.parse(JSON.stringify(this.user));
      this.dialogFormVisible = true
    }
  },
}
</script>
<style scoped>
 span {
   font-size: 15px;
 }
</style>
