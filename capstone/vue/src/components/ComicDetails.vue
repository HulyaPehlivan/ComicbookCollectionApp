<template>
  <div>
    <h2 class="title">{{ comic.title }}</h2>
    <v-img class="image" height="100%" :src="comic.image" alt="" />
    <h3 class="release-date">{{ comic.releaseDate }}</h3>
    <span
      v-if="comic.description != 'null'"
      class="text-subtitle-1"
      v-html="comic.description"
    >
      {{ comic.description }}
    </span>
  </div>
</template>

<script>
import ComicService from "../services/ComicService";
export default {
  name: "comic-details",
  data() {
    return {
      model: null,
      comic: {
        apiID: 0,
        comicId: 0,
        title: "",
        deck: "",
        description: "",
        releaseDate: "",
        image: "",
      },
    };
  },
  created() {
    ComicService.getComicById(this.$route.params.apiID).then((response) => {
      console.log = response.data;
      this.comic = response.data;
      this.$store.commit("SET_CURRENT_COMIC", response.data);
    });
  },
};
</script>

<style>
</style>