<template>
  <div class="info-container" style="height: 1000px">
    <div class="infochange">
      <el-button type="primary" size="medium" @click="modifyinfo" class="change">修改信息</el-button>
    </div>
    <el-descriptions class="margin-top" :column="1"  border>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          <span>用户头像</span>
        </template>
        <span>
          <img :src="user.uimg" style="width: 150px">
        </span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-view"></i>
          <span>用户账号</span>
        </template>
        <span>{{ user.uaccount }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          <span>昵称</span>
        </template>
        <span>{{ user.uname }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-male"></i>
          <span>性别</span>
        </template>
        <span>{{ user.usex }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-news"></i>
          <span>邮箱</span>
        </template>
        <span>{{ user.uemail }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          <span>手机号</span>
        </template>
        <span>{{ user.utel }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>
          <span>备注</span>
        </template>
        <span>{{ user.udesp }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>
          <span>联系地址</span>
        </template>
        <span>{{user.uaddress}}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>
          <span>状态</span>
        </template >
        <el-tag type="success" v-if="user.utype===0">普通用户</el-tag>
        <el-tag type="info" v-else-if="user.utype===1">商家</el-tag>
        <el-tag type="danger" v-else-if="user.utype===2">管理员</el-tag>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-time"></i>
          <span>创建时间</span>
        </template>
        <span>{{user.create_time}}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-time"></i>
          <span>最近更新时间</span>
        </template>
        <span>{{user.update_time}}</span>
      </el-descriptions-item>
    </el-descriptions>
    <div class="modifyinfo" >
      <el-dialog title="信息修改" :visible.sync="dialogFormVisible" width="30%">
        <el-form>
          <el-form-item label="用户账号" label-width="100px">
            <el-upload
              action="http://localhost:8084/file/upload"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-success="handleAvatarSuccess"
              :on-remove="handleRemove"
              enctype="multipart/form-data"
              :http-request="onUpload"
            >
<!--              <img v-if="avatarUrl" :src="user1.uimg" class="avatar">-->
              <el-image :src="user1.uimg"  fit="contain" v-if="avatarUrl"></el-image>
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="用户账号" label-width="100px">
            <el-input  v-model="user1.uaccount" disabled></el-input>
          </el-form-item>
          <el-form-item label="用户昵称" label-width="100px">
            <el-input  v-model="user1.uname"></el-input>
          </el-form-item>
          <el-form-item label="性别" label-width="100px">
            <el-radio-group v-model="user1.usex">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="邮箱" label-width="100px">
            <el-input type="email" v-model="user1.uemail"></el-input>
          </el-form-item>
          <el-form-item label="手机号" label-width="100px">
            <el-input type="number" v-model="user1.utel"></el-input>
          </el-form-item>
          <el-form-item label="居住地" label-width="100px">
            <el-input v-model="user1.uaddress"></el-input>
          </el-form-item>
          <el-form-item label="备注" label-width="100px">
            <el-input v-model="user1.udesp"></el-input>
          </el-form-item>
          <el-form-item label="状态" label-width="100px">
            <el-input v-model="user1.state" disabled></el-input>
          </el-form-item>
          <el-form-item label="创建时间" label-width="100px">
            <el-input v-model="user1.create_time" disabled></el-input>
          </el-form-item>
          <el-form-item label="最近更新时间" label-width="100px">
            <el-input v-model="user1.update_time" disabled></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelinfo">取 消</el-button>
          <el-button type="primary" @click="confirminfo">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>

import {uploadAPI,modifyUserAPI} from "../../../api";

export default {
  name: "Home",
  data() {
    return{
      dialogFormVisible: false,
      dialogImageUrl: "",
      dialogVisible: false,
      dialogTableVisible: false,
      user:{},
      avatarUrl:true,
      user1:{}
    }
  },
  methods:{
    async onUpload(file){
      console.log(file)
      localStorage.setItem('isFile',"isFile")
      const formData=new FormData()
      formData.append('file',file.file)
      const{data:res}=await uploadAPI(formData)
      this.user1.uimg=res
    },
    handleAvatarSuccess(res) {
      console.log("上传")
      console.log(res)
      this.avatarUrl=false

      // this.user1.uimg=this.avatarUrl
      // this.form.img=res.data
      // console.log("filefile",file)

    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      console.log("预览预览")
      console.log("预览预览")
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
      console.log(file.url);
    },

    cancelinfo(){
      this.dialogFormVisible = false;
      console.log(this.user)
      console.log(this.user1)
    },
   async confirminfo(){
      localStorage.removeItem('isFile')
     this.user=JSON.parse(JSON.stringify(this.user1));
      // const {data:res}=await
      console.log("上传提交提交")
      console.log(this.form)
      this.json = JSON.stringify(this.user)
      const{data:res}=await modifyUserAPI(this.json);
      console.log(res.data);
      this.$message.success("用户信息修改成功！！");
      this.dialogFormVisible = false;
    },
    modifyinfo(){
      this.user1=JSON.parse(JSON.stringify(this.user));
      this.dialogFormVisible = true
    }
  },
  created() {
    this.user=JSON.parse(localStorage.getItem('user'))
    console.log(this.user)
  }
}
</script>
<style scoped>
 span {
   font-size: 15px;
 }
 .infochange{
   float: right;
   margin: 0 0 10px 0;
 }
 .change{
   margin-right: 50px;
   font-size: 15px;
   padding: 16px;
   margin-top: 10px;
 }
 .info-container{
   margin-top: -18px;
   margin-left: -18px;
 }
 .avatar {
   width: 150px;
   height: 150px;
   display: block;
 }
</style>
