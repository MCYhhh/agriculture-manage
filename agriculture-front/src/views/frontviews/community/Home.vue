<template>
  <div class="file-container">
    <el-button>
      <el-dropdown @command="chooseValue">
        <span class="el-dropdown-link">
          <i class="el-icon-caret-bottom"  style="font-size: 18px" >{{ choose }}</i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item v-for="item in option1" :key="item.value" :command="item.label">
            <span>{{item.label}}</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-button>
    <el-input v-model="value" prefix-icon="el-icon-search" @keyup.enter.native="search" ></el-input>

  </div>
</template>
<script>

export default {
  name: "file",
  data(){
    return{
      value:'',
      choose:'选择类型',
      option1:[
        {label:'商品名称',value:0},
        {label:'商品价格',value:1},
      ]
    }
  },
  methods:{
    chooseValue(label){
      this.choose=label
      if(label.includes('价格')){
        alert('请输入低于xx元（只填写数字）')
      }
      else
        alert('请输入商品名称')
      // this.value='请输入'+label
    },
    search(){
      console.log(typeof this.value)
      const numReg = /^[0-9]+$/
      const numRe = new RegExp(numReg)
      if (numRe.test(this.value)) {
        // this.$message({<!-- -->
        //   type: 'error',
        //   message: '请输入数字 ',
        //   duration: 10000,
        //   showClose: true,
        // })
        // return false
        console.log("搜索搜索,拿到输入值",this.value)
        this.value=Number(this.value)
        console.log(typeof this.value)
      }

    }
  }
}

</script>
<style scoped>
.file-container{
  margin:0 auto;
  padding-bottom: 50px;
  width: 700px;
  position: static;
}

/deep/ .el-input__inner{
  border-radius: 100px;
  border-color: rgba(0,0,0,0);
  width: 600px;
  height: 40px;
}
.el-input{
  border-radius: 100px;
  position: absolute;
  width: 600px;
  height: 40px;
}

.el-input:hover{
  box-shadow: 3px 3px 3px rgba(1,1,1,0.2);
}
</style>

