<template>
  <v-container style="background-color: #f23c27">
    <v-sheet
      class="mx-auto"
      elevation="8"
      max-width="1700"
      style="background-color: rgba(0, 0, 0, 0); box-shadow: none !important"
    >
      <v-slide-group
        v-model="model"
        class="pa-4 slider"
        active-class="success"
        show-arrows
      >
        <v-slide-item
          v-for="comic in comics"
          :key="comic.id"
          v-slot="{ active, toggle }"
        >
          <v-card
            :color="'primary lighten-1'"
            class="ma-4"
            height="400"
            width="300"
            style="border-radius: 10px; overflow: hidden"
            @click="toggle"
          >
            <!-- {{ comics[n].title }} -->
            <v-img height="100%" :src="comic.image">
              <v-row class="fill-height" align="center" justify="center">
                <v-scale-transition>
                  <v-icon v-if="active" color="white" size="48"></v-icon>
                </v-scale-transition>
                <!-- <div class="d-flex align-end gradient-box"> -->
                <v-card-title class="noselect">{{
                  comic.name
                }}</v-card-title>
              </v-row>
            </v-img>
          </v-card>
        </v-slide-item>
      </v-slide-group>
    </v-sheet>
  </v-container>
</template>

<script>
import ComicService from "../services/ComicService";
export default {
  data: () => ({
    model: null,
    comics: [],
  }),
  created() {
    ComicService.getComicByCollectionId(this.$store.state.activeCollectionId).then(
      (response) => {
        console.log(response.data)
        this.comics = response.data;
        this.$store.commit("LOAD_ALL_COMICS", this.comics);
      }
    );
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Bangers");

h2 {
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
}
.v-card {
  border-radius: 4px;
  margin: 16px;
}

.v-icon {
  align-items: center;
}

.thumbnail {
  width: 250px;
  height: 250px;
  overflow: hidden;
  border-radius: 15px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.gradient-box {
  width: 100%;
  height: 150px;
  position: absolute;
  bottom: 0;
  background: linear-gradient(to bottom, transparent 0%, black 100%);
}

.noselect {
  -webkit-touch-callout: none; /* iOS Safari */
  -webkit-user-select: none; /* Safari */
  -khtml-user-select: none; /* Konqueror HTML */
  -moz-user-select: none; /* Old versions of Firefox */
  -ms-user-select: none; /* Internet Explorer/Edge */
  user-select: none; /* Non-prefixed version, currently
                                  supported by Chrome, Edge, Opera and Firefox */
}
</style>

v-text="'mdi-close-circle-outline'"