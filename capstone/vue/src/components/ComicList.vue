<template>
  <div class="comic-container">
    <v-card
      v-bind:comic="comic"
      v-for="comic in $store.state.comics"
      v-bind:key="comic.apiID"
      :color="'primary lighten-1'"
      class="ma-4"
      height="auto"
      width="auto"
      style="border-radius: 10px; overflow: hidden"
      @click="getComic(comic.apiID)"
    >
      <v-img class="image" height="100%" :src="comic.image" alt="" />
    </v-card>

  </div>
</template>

<script>
import ComicService from "../services/ComicService";

// import ComicCard from "./ComicCard.vue";
// import ComicCover from "./ComicCover.vue";

export default {
  name: "comic-list",
  data() {
    return {
      model: null,
      comics: [],
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
  methods: {
    getComic(apiID) {
      ComicService.getComicById(apiID).then((response) => {
        this.comic = response.data;
        this.$store.commit("SET_CURRENT_COMIC", response.data);
        this.$router.push({ name: "issues-id" });
      });
    },
  },
  created() {
    this.comics = this.$store.state.comics;
  },
};
</script>

<style scoped>
.comic-container {
  display: grid;
  grid-template-columns: 360px 360px 360px 360px 360px;
  gap: 20px;
}
</style>