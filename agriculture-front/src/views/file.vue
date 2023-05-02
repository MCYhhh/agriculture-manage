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
        <el-form-item label="分数" :label-width="formLabelWidth">
          <el-input v-model="form.score" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="上传封面" prop="imageUrl">
          <el-upload
            action="http://localhost:8084/file/upload"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-success="handleAvatarSuccess"
            :on-remove="handleRemove"
            enctype="multipart/form-data"
            :http-request="onUpload"
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
        <el-button type="primary" @click="submitArticle(form)"
        >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>


<script>
import {saveArticleAPI} from "../api";
import {uploadAPI} from "../api";
export default {
  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        title: "",
        type:0,
        summary: "",
        content: "",
        img: "",
        score:2.2,
        uid:1,
      },
      formLabelWidth: "120px",
      json :"",
      isDisabled:false,
    };
  },

  methods: {
   async onUpload(file){
      console.log(file)
     localStorage.setItem('isFile',"isFile")
      const formData=new FormData()
      formData.append('file',file.file)
      const{data:res}=await uploadAPI(formData)
     this.form.img=res
    },
    handleAvatarSuccess(res){
      console.log("上传")
      console.log(res)
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

    submitArticle: async function (){
      localStorage.removeItem('isFile')
      // const {data:res}=await
      console.log("上传提交提交")
      console.log(this.form)
      this.json = JSON.stringify(this.form)
      const{data:res}=await saveArticleAPI(this.json);
      console.log(res.data);
      this.$message.success("文章发布成功！！");
      this.isDisabled=true;
    }
  },
};
</script>
<style>
.add{
  margin: 50px;
}
</style>
