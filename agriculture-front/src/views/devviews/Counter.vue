<template>
  <div class="counter">
    <el-button type="warning" plain @click="sub">-</el-button>
    <span>{{count}}</span>
    <el-button type="primary" plain @click="add">+</el-button>
  </div>
</template>

<script>
import bus from "../../eventBus";
export default {
  name: "Counter",
  props:{
    id:{
      type:Number,
      required:true
    },
    count:{
      type:Number,
      default:0
    },
    stateNew:{
      type:Boolean,
      default:false
    }
  },
  methods:{
    add(){
      const obj={
        id:this.id,
        state:this.stateNew,
        value:this.count+1
      }
      bus.$emit('addNum',obj)
    },
    sub(){
      const obj={
        id:this.id,
        state:this.stateNew,
        value:this.count-1
      }
      bus.$emit('subNum',obj)
    }
  }
}
</script>

<style scoped>
  .counter{
    margin-left: 1000px;
    margin-top: -30px;
    padding-bottom: 5px;
  }
</style>
