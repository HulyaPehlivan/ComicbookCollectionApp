<template>
  <div class="main">
    <comics-list />
  </div>
</template>

<script>
import ComicsList from "../components/ComicList.vue";
export default {
  components: { ComicsList },
  name: "comic-search",
};
</script>

<style scoped>
</style>