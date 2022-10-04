<template>
  <div class="main">
    <h2 class="title">{{ comic.title }}</h2>
    <br />
    <h3 class="release-date">Release Date: {{ comic.releaseDate }}</h3>
    <br />
    <p>Publisher: {{ comic.publisher }}</p>
    <br />
    <h3>Description</h3>
    <span
      v-if="comic.description != 'null'"
      class="text-subtitle-1"
      v-html="comic.description"
    >
      {{ comic.description }}
    </span>
    <br />
    <select name="collections" id="collection" v-model="collection">
      <option selected>Please select one</option>
      <option
        v-for="collection in $store.state.collections"
        :key="collection.collectionId"
        :value="collection"
        @change="setCollectionId(collection.collectionId);"
      >
        {{ collection.collectionName }}
      </option>
    </select>
    <br />
    <br />
    <div class="button-container"></div>
    <button
      class="button"
      v-on:click.prevent="addComic()"
      v-if="!addToCollection"
    >
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
        publisher: "",
      },
      addToCollection: false,
      // currentCollectionId: this.collection.collectionId,
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
        this.comic.apiID,
        (this.addToCollection = true)
      );
    },
    retrieveCollections() {
      collectionService.getCollections().then((response) => {
        this.$store.commit("SET_COLLECTIONS", response.data);
      });
    },
    // setCollectionId(activeCollectionId) {
    //   this.$store.commit("SET_ACTIVE_COLLECTION", activeCollectionId);
    // },
  },
};
</script>

<style scoped>
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