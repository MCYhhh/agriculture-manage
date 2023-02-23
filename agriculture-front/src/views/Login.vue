<template>
  <div id="login">
    <el-form ref="form" :model="LoginForm" label-width="0px" class="loginbox">
      <h3 style="padding-left:120px;font-size: 28px;color: #b5dac4;margin-top: -10px;letter-spacing:30px">登录</h3>
      <el-form-item label="">
        <el-input v-model="LoginForm.name" placeholder="账号" prefix-icon="el-icon-user-solid" auto-complete="off" type="text"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="LoginForm.password" placeholder="密码" prefix-icon="el-icon-lock" auto-complete="off" type="password"></el-input>
      </el-form-item>
      <el-form-item size="large" >
        <el-button  @click="onSubmit" style="width: 30%;background-color: #cee3c1;border: none">登录</el-button>
        <el-button style="width: 30%;background-color: #cee3c1;border: none" v-on:click="reset()">重置</el-button>
        <p style="color: #c0d2b6" @click="toRegister">无账号？去注册</p>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      LoginForm: {
        name: '',
        password: '',
      }
    };
  },
  methods: {
    onSubmit() {
      console.log('submit!',this.LoginForm);
      this.$message({
        message: '登录成功',
        type: 'success'
      });

    },
    toRegister(){
      this.$router.push("/register")
    }
  }
}
</script>

<style scoped>
#login{
  background-position: center;
  height: 100%;
  width: 100%;
  background-image: url("../assets/images/loginback.gif");
  background-size: cover;
  position: fixed;
}
div{
  margin: 0;
  padding: 0;
}
.loginbox{
  border-radius: 15px;
  background-clip: padding-box;
  margin: 200px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #ecf3f0;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.el-form-item{
  padding-bottom: 10px;
}
.el-button{
  font-size: 16px;
  margin: 5px 10px;
}
</style>
