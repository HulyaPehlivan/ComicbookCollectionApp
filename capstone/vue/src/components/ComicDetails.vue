<template>
  <div class="main">
    <h2 class="title">{{ comic.title }}</h2>
    <br />
    <h3 class="release-date">Release Date: {{ comic.releaseDate }}</h3>
    <br />
    <h3 v-if="comic.description != 'null'">Description</h3>
    <h3 v-else></h3>
    <span
      v-if="comic.description != 'null'"
      class="text-subtitle-1"
      v-html="comic.description"
    >
      {{ comic.description }}
    </span>
    <span class="text-subtitle-1" v-else></span>
    <br />
    <select name="collections" id="collection" v-model="collection">
      <option
        v-for="collection in $store.state.collections"
        :key="collection.collectionId"
        :value="collection"
      >
        {{ collection.collectionName }}
      </option>
    </select>
    <br />
    <br />
    <div class="button-container"></div>
    <button class="button" v-on:click.prevent="addComic()">
      Add to Collection
    </button>
  </div>
</template>

<script>
import ComicService from "../services/ComicService";
import collectionService from "../services/CollectionService";
export default {
  name: "comic-details",
  data() {
    return {
      model: null,
      selected: {
        name: "Choose Collection",
      },
      collection: {
        collectionId: 0,
        collectionName: "",
        isPublic: "",
        userId: 0,
      },
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
      this.comic = response.data;
      this.$store.commit("SET_CURRENT_COMIC", response.data);
    });

    this.retrieveCollections();
  },
  methods: {
    addComic() {
      ComicService.addComicToCollection(
        this.comic,
        this.collection.collectionId,
        this.comic.apiID
      ).then((response) => {
        console.log(response.data);
      });
    },
    retrieveCollections() {
      collectionService.getCollections().then((response) => {
        this.$store.commit("SET_COLLECTIONS", response.data);
      });
    },
  },
};
</script>

<style scoped>
select {
  border: 2px solid black;
  border-radius: 10px;
  background-color: #f23c27;
}
.main {
  border: 2px solid black;
  border-radius: 10px;
  width: auto;
  height: 764px;
  margin: 20px;
  background-color: white;
  opacity: 80%;
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
  padding: 10px;
}
</style>