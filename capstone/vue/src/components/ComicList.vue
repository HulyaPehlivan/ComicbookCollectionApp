<template>
  <div class="comic-container">
    <comic-card
      v-bind:comic="comic"
      v-for="comic in $store.state.comics"
      v-bind:key="comic.title"
    />
  </div>
</template>

<script>
import ComicCard from "./ComicCard.vue";
export default {
  name: "comic-list",
  components: {
    ComicCard,
  },
};
</script>

<style>
</style>