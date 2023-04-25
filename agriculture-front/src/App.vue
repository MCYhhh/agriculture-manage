<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import Nav from "./components/Nav";
export default {
  name: 'App',
  components: {Nav},
  provide(){
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true,
    };
  },
  methods: {
    reload(){
      this.isRouterAlive = false;
      this.$nextTick(function(){
        this.isRouterAlive = true;
      })
    }
  },
}
</script>

<style>
</style>
