<template>
  <div class="comic-container">
    <v-card
      class="ma-4"
      v-bind:comic="comic"
      v-for="comic in $store.state.comics"
      v-bind:key="comic.apiID"
      :color="'primary lighten-1'"
      height="auto"
      width="auto"
      style="border-radius: 10px; overflow: hidden"
      @click="getComic(comic.apiID)"
    >
      <v-img class="image" height="100%" :src="comic.image" alt="" />
      <!-- <h3>{{ comic.title }}</h3>
      <span
        v-if="comic.description != 'null'"
        class="text-subtitle-1"
        v-html="comic.description"
      >
        {{ comic.description }}
      </span> -->
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
        this.$store.commit("SET_CURRENT_COMIC", this.comic);
        this.$router.push({ name: "issues-id", params: { apiID: apiID } });
      });
    },
  },
  // created() {
  //   this.comics = this.$store.state.comics;
  // },
};
</script>

<style scoped>
.comic-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
  gap: 20px;
  margin-right: 10px;
}
</style>