<template>
  <div class="game-container">
    <ArticleList></ArticleList>
<!--    <ArticleContent></ArticleContent>-->
  </div>
</template>

<script>
import ArticleList from "./ArticleList.vue";
import ArticleContent from "./ArticleContent.vue";
import HomeMiddle from "../home/HomeMiddle.vue";
export default {
  name: "Home",
  components: {
    ArticleList,
    ArticleContent
  }
}
</script>

<style scoped>
</style>
