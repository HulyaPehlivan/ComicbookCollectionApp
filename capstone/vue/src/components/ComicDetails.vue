<template>
  <div class="main">
    <h2 class="title">{{ comic.title }}</h2>
    <br>
    <h3 class="release-date">Release Date: {{ comic.releaseDate }}</h3>
    <br>
    <h3>Description</h3>
    <span
      v-if="comic.description != 'null'"
      class="text-subtitle-1"
      v-html="comic.description"
    >
      {{ comic.description }}
    </span>
    <div class="button-container"></div>
    <button
      class="button"
      v-if="!enableAdd"
      v-on:click.prevent="addToCollection(comic)"
    >
      Add to Collection
    </button>
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

<style scoped>
.main{
  border: 2px solid black;
  border-radius: 10px;
  width: auto;
  height: 764px;
  margin: 20px;
  background-color: white;
  opacity: 80%;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  padding: 10px;
}
</style>