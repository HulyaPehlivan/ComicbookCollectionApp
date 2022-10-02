<template>
  <div class="comic-container">
    <v-card
      class="comic-card ma-4"
      v-bind:comic="comic"
      v-for="comic in $store.state.comics"
      v-bind:key="comic.apiID"
      :color="'primary lighten-1'"
      height="auto"
      width="auto"
      style="border-radius: 10px; overflow: hidden"
      @click="toggle"
    >
      <v-img height="100%" :src="comic.image">
        <v-row class="fill-height" align="center" justify="center">
          <v-scale-transition>
            <v-icon v-if="active" color="white" size="48"></v-icon>
          </v-scale-transition>
          <!-- <div class="d-flex align-end gradient-box"> -->
          <v-card-title class="noselect">{{ comic.name }}</v-card-title>
        </v-row>
      </v-img>
      <v-expand-transition>
        <v-sheet
          v-if="model != null"
          style="background-color: #f7d281 !important"
        >
          <v-container fluid class="pa-12">
            <v-row>
              <v-col cols="12" sm="6">
                <h2>Issue Title:</h2>
                <span class="text-h6" v-if="comic.title != 'null'">{{
                  `${comics[model].title}`
                }}</span>
                <span class="text-h6" v-else> Title Not Found </span>
                <h2>Description:</h2>
                <span
                  v-if="comic.description != 'null'"
                  class="text-subtitle-1"
                  v-html="comic.description"
                >
                </span>

                <span class="text-subtitle-1" v-else
                  >Description Not Found</span
                >
              </v-col>
              <v-col
                cols="12"
                sm="6"
                class="d-flex align-center justify-center"
              >
              </v-col>
            </v-row>
          </v-container>
        </v-sheet>
      </v-expand-transition>
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
        console.log(response.data);
        this.comic = response.data;
        this.$store.commit("SET_CURRENT_COMIC", this.comic);
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
  grid-template-columns: 1fr 1fr 1fr;
  gap: 20px;
}
/* 
.comic-card {
  display:inline-flex;
} */
</style>