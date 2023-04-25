<template>
  <div class="footer-container" >
    <van-grid  v-for="item in footerList">
      <van-grid-item v-for="value in item" :key="value" >
        <p style="color: #e59c9c">{{ value }}</p>
      </van-grid-item>
    </van-grid>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data(){
    return{
      footerList:[
        ['畅游雲韵','纵享利惠','小憩滇都','富农助农'],
        ['彩云之南，梦如近景；阡陌芳菲，青山绿野','晴空农行，静听悦事；农户百家，惠民百态','野趣云南，品味乐园；即刻分享，众乐一言','携手奋进，谱写农事；扶农助农，国富民安'],
        // [{n1:'畅游雲韵',n2:'纵享利惠',n3:'纵享利惠',n4:'纵享利惠'}],
        // [{n1:'畅游雲韵',n2:'纵享利惠',n3:'纵享利惠',n4:'纵享利惠'}],
      ]
    }
  }
}
</script>

<style scoped>
.footer-container{
  margin-top: 600px ;
  margin-left: -30px;
  width: 2000px;
  height:200px ;
  position: static;
  background-color: #f6f3df;
}
.van-grid-item{
  flex-basis:15%;
}
/deep/ .van-grid-item__content{
  background-color: rgba(0,0,0,0);
  padding: -20px;
}

</style>
