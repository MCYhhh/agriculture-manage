<template>
  <div class="total-container">
    <test></test>
    <Test2></Test2>
  </div>
</template>

<script>
import Test from "./test.vue";
import Test2 from "./test.vue";

export default {
  name: "total",
  components: {Test2, Test}
}
</script>

<style scoped>

</style>
