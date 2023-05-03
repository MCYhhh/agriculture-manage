<template>
  <div class="homemiddle2-container">
    <h2 class="neon">=====民风民俗====</h2>
    <div class="recscenery">
      <el-row>
        <el-col :span="8" v-for="(item, index) in scenery" :key="item.sid" offset="2" style="width: 350px;height: 400px">
          <el-card :body-style="{ padding: '0px' }">
            <img :src="item.surl" class="image" >
            <span class="sitename" style="padding: 20px;">{{item.sname}}</span>
            <div style="padding: 14px;">
              <span>{{ item.saddress }}</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeMiddle2",
  data() {
    return {
      scenery:[
        {sid:1,sname:'丽江民风',saddress:'云南省丽江市万超县幸福小区101号',sprice:180,sdesp:'丽江风情，人文风俗',surl:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'},
        {sid:2,sname:'大理民风',saddress:'云南省大理市白族自治州万超县幸福小区101号',sprice:180,sdesp:'丽江风情，人文风俗',surl:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'},
        {sid:3,sname:'香格里拉民风',saddress:'云南省香格里拉万超县幸福小区101号',sprice:180,sdesp:'丽江风情，人文风俗',surl:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'},
        {sid:4,sname:'丽江民风',saddress:'云南省丽江市万超县幸福小区101号',sprice:180,sdesp:'丽江风情，人文风俗',surl:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'},
        {sid:5,sname:'香格里拉民风',saddress:'云南省丽江市万超县幸福小区101号',sprice:180,sdesp:'丽江风情，人文风俗',surl:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'},
        {sid:6,sname:'大理民风',saddress:'云南省丽江市万超县幸福小区101号',sprice:180,sdesp:'丽江风情，人文风俗',surl:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'},
       ],
    }
  }
}
</script>

<style scoped>
.homemiddle2-container{
  margin: 0 auto;
  width: 1600px;
  height:400px ;
  position: static;
  padding-top: 280px;
}
h2{
  width: 1000px;
  height: 200px;
  position: absolute;
  left: 50%;
  margin-left: -150px;
  background-image: -webkit-linear-gradient(left, #ecf3f0,#66ffff 10%, #f1eed4 20%, #b5dac4 30%, #CCCCFF 40%, #00FFFF 50%,#CCCCFF 60%,#CC00CC 70%,#CC00FF 80%,#66FFFF 90%,blue 100%);
  -webkit-text-fill-color: transparent;
  -webkit-background-clip: text;
  -webkit-background-size: 200% 100%;
  -webkit-animation: masked-animation 4s linear infinite;
  font-size: 35px;
}
@keyframes masked-animation {
  0% {
    background-position: 0  0;
  }
  100% {
    background-position: -100%  0;
  }
}
.recscenery{
  padding-top: 150px;
  padding-left: -10px;
  position: static;
}
.sitename{
  position: relative;
  top: -150px;
  font-size: 30px;
  font-weight: bolder;
  color: white;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 350px;
  display: block;
  margin-bottom: -25px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>
