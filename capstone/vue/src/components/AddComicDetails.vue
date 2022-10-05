<template>
  <div class="main">
    <h2 class="title">{{ comic.title }}</h2>
    <br />
    <h3 class="release-date">Release Date: {{ comic.releaseDate }}</h3>
    <br />
    <p>Publisher: {{ comic.publisher }}</p>
    <br />
    <h3>Description</h3>
    <div class="description-details">
      <span
        v-if="comic.description != 'null'"
        class="text-subtitle-1"
        v-html="comic.description"
      >
        {{ comic.description }}
      </span>
    </div>
    <br />
    <label id="label">Select collection:</label>
    <br />
    <select name="collections" id="collection" v-model="collection">
      <option
        v-for="collection in $store.state.collections"
        :key="collection.collectionId"
        :value="collection"
        :selected="collection === $store.state.collection[0]"
      >
        {{ collection.collectionName }}
      </option>
    </select>
    <br />
    <br />
    <div class="button-container">
      <button class="button" v-on:click="addComic()">Add to Collection</button>
    </div>
    <div class="button-container">
      <button class="button" v-on:click="deleteComic()">
        Remove from Collection
      </button>
    </div>
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
        this.$router.push({ name: "home" })
      );
    },
    retrieveCollections() {
      collectionService.getCollections().then((response) => {
        this.$store.commit("SET_COLLECTIONS", response.data);
      });
    },
    deleteComicFromCollection() {
      ComicService.deleteComic(this.comic.comicId);
      this.$router.push({ name: "home" });
    },
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
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
  padding: 10px;
}

h2 {
  font-size: 40px;
}

select {
  background-color: tomato;
  border: 2px solid black;
  border-radius: 5px;
  font-size: 18px;
}

option {
  font-size: 18px;
}

.button-container {
  text-decoration: none;
  font-size: 25px;
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
    padding: 5px;
}

#label {
  text-decoration: none;
  font-size: 25px;
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
}

div.description-details {
  overflow-y: scroll;
  height: 350px;
  background-color: lightgray;
  padding: 10px;
}
</style>