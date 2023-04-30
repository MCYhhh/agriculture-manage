<template>
  <div id="register">
    <el-form ref="form" :model="RegisterForm" :rules="rules" label-width="0px" class="registerbox">
      <h3 style="padding-left:120px;font-size: 28px;color: #b5dac4;margin-top: -10px;letter-spacing:30px">注册</h3>
      <el-form-item label="">
        <el-input v-model="RegisterForm.uaccount" placeholder="账号" prefix-icon="el-icon-user-solid" auto-complete="off" type="text"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="RegisterForm.uname" placeholder="用户名" prefix-icon="el-icon-help" auto-complete="off" type="text"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="RegisterForm.upwd" placeholder="密码" prefix-icon="el-icon-lock" auto-complete="off" type="password"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input v-model="RegisterForm.checkupwd" placeholder="确认密码" prefix-icon="el-icon-lock" auto-complete="off" type="password"></el-input>
      </el-form-item>
      <el-form-item label="">
<!--        <span style="color: darkgray;letter-spacing: 2px">性别</span>-->
        <el-radio-group v-model="RegisterForm.usex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item size="large" >
        <el-button  @click="onSubmit" style="width: 30%;background-color: #cee3c1;border: none">注册</el-button>
        <el-button style="width: 30%;background-color: #cee3c1;border: none" v-on:click="reset()">重置</el-button>
        <p style="color: #c0d2b6" @click="toLogin">有账号？去登录</p>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
// import router from "../router";
import {registerAPI} from "../api";
import {loginAPI} from "../api";

export default {
  name: "Register",
  data() {
    var checkUaccount = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("账号不能为空"));
      }else {
        callback();
      }
    };
    var checkUname = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("昵称不能为空"));
      }else {
        callback();
      }
    };
    var checkUsex=(rule,value,callback)=>{
      if(!value){
        return callback(new Error("性别不能为空"));
      }else{
        callback();
      }
    }
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.RegisterForm.checkupwd !== "") {
          this.$refs.form.validateField("checkupwd");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.RegisterForm.upwd) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      RegisterForm: {
        uaccount:'',
        uname: '',
        upwd: '',
        checkupwd:'',
        usex:'',
      },
      rules: {
        upwd: [{ validator: validatePass, trigger: "blur" }],
        checkPass: [{ validator: validatePass2, trigger: "blur" }],
        uname: [{ validator: checkUname, trigger: "blur" }],
        uaccount: [{ validator: checkUaccount, trigger: "blur" }],
        usex: [{ validator: checkUsex, trigger: "blur" }],
      },
    };

  },
  methods: {
  onSubmit() {
      console.log('submit!',this.RegisterForm);
      this.$message({
        message: '注册成功',
        type: 'success'
      });
      console.log(this.RegisterForm)
      this.$refs['form'].validate(async (valid) => {
        if (valid) {  // 表单校验合法
          if (this.RegisterForm.upwd !== this.RegisterForm.checkupwd) {
            this.$message.error("两次输入的密码不一致")
            return false
          }
          const json = JSON.stringify(this.RegisterForm)
          const {data: res} = await registerAPI(json);
          console.log(res)
          if (res.code === '00000') {
            this.$message.success("注册成功")
            // this.$router.push("/")
          } else {
            this.$message.error(res.msg)
          }
        }
      });

    },
    toLogin(){
      this.$router.push("/")
    },
    reset(){
      this.RegisterForm.uname=''
        this.RegisterForm.upwd=''
      this.RegisterForm.uaccount=''
      this.RegisterForm.checkupwd=''
    }

  }
}
</script>

<style scoped>
#register{
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
.registerbox{
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
  padding-bottom: 5px;
}
.el-button{
  font-size: 16px;
  margin: 5px 10px;
}
</style>
