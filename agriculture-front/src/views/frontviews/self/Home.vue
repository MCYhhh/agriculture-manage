<template>
  <div class="self-container">
    <el-descriptions class="margin-top" :column="1"  border>
      <template slot="extra">
        <el-button type="primary" size="small" @click="modifyinfo">修改信息</el-button>
      </template>
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
          <i class="el-icon-picture-outline-round"></i>
          <span>照片</span>
        </template>
        <span>{{ user.uimg }}</span>
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
        </template>
        <span v-if="user.state===0">正常</span>
        <span v-else>已注销</span>
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
