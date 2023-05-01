<template>
  <div>
    <el-button type="warning" @click="dialogFormVisible = true;"
               class="add">点击新增文章数据</el-button
    >

    <el-dialog title="新增文章数据" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="文章标题" :label-width="formLabelWidth">
          <el-input v-model="form.title" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="文章类型" :label-width="formLabelWidth">
          <el-input v-model="form.type" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="摘要" :label-width="formLabelWidth">
          <el-input v-model="form.summary" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="正文" :label-width="formLabelWidth">
          <el-input v-model="form.content" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="上传封面" prop="imageUrl">
          <el-upload
            action="http://localhost:8084/file"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-success="handleAvatarSuccess"
            :on-remove="handleRemove"
          >
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="" />
          </el-dialog>
        </el-form-item>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="" />
        </el-dialog>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitCat(form)"
        >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>


<script>

export default {
  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        cname: "",
        ccolor: "",
        cinfo: "",
        curl: "",
        cisadopt: 0,
      },
      formLabelWidth: "120px",
      json :"",
      isDisabled:false,
    };
  },
  methods: {
    handleAvatarSuccess(res, file) {
      console.log(res)
      this.form.curl = res
      // console.log(this.form.curl = res);
      // this.form.curl = sessionStorage.setItem("curl",this.curl)
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
      console.log(file.url);
    },

    submitCat: async function (){
      this.form.curl='http://localhost:8082/myImg/65ba45786a8742a2b8a08d3ad396b25d..jpg'
      this.json = JSON.stringify(this.form),
        await addcatAPI(this.json);
      // console.log(res.data);
      this.$message.success("文章发布成功！！");
      // this.isDisabled=true;
    }
  },
};
</script>
<style>
.add{
  margin: 50px;
}
</style>
