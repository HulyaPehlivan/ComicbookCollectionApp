<template>
  <div class="cover-img">
      <v-card
            :color="'primary lighten-1'"
            class="ma-4"
            height="764"
            width="497"
            style="border-radius: 10px; overflow: hidden"
          >
    <v-img class="image" height="100%" :src="comic.image" alt="" />
      </v-card>
  </div>
</template>

<script>
import ComicService from "../services/ComicService";
export default {
  name: "comic-cover",
  data() {
    return {
      model: null,
      comic: {
        image: 0,
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

<style scoped>
.cover-img {
      margin: 5px;
      height: 550px;
      width: auto;
}

</style>