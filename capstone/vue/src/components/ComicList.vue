<template>
  <div class="comic-container">
    <comic-cover
      v-bind:comic="comic"
      v-for="comic in $store.state.comics"
      v-bind:key="comic.apiID"
    />
  </div>
</template>

<script>
// import ComicCard from "./ComicCard.vue";
import ComicCover from "./ComicCover.vue"

export default {
  name: "comic-list",
  data() {
    return {
      model: null,
      comics: [],
    };
  },
  components: {
    ComicCover
  },
  created()
 {
   this.comics = this.$store.state.comics
 },
};
</script>

<style>
</style>