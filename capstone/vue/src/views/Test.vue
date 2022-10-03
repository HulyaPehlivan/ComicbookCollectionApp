<template>
  <div>
    <test-carousel />
  </div>
</template>

<script>
import TestCarousel from "../components/TestCarousel.vue";
import ComicService from "../services/ComicService";
export default {
  components: { TestCarousel },
  data() {
    return {};
  },
  methods: {
    search() {
      if (this.searchType === "Title") {
        ComicService.getComicByTitle(this.searchInput).then((response) => {
          this.comics = response.data;
          this.$store.commit("GET_SEARCHED_COMICS", response.data);
          this.$router.push({ name: "issues-name" });
        });
      } else if (this.searchType === "Story Arc") {
        ComicService.getComicByStoryArc(this.searchInput).then((response) => {
          this.comics = response.data;
          this.$store.commit("GET_SEARCHED_COMICS", response.data);
          this.$router.push({ name: "issues-name" });
        });
      }
    },
  },
};
</script>

<style>
</style>
