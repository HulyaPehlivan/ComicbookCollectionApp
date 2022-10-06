<template>
  <div class="main mx-auto">
    <banner-view />
    <search-bar id="search" />
    <div id="bg">
      <img
        src="https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
        alt=""
      />
    </div>

    <v-container style="background-color: rgba(0, 0, 0, 0)">
      <v-sheet class="mx-auto" elevation="8" max-width="1900">
        <v-slide-group v-model="collection" class="pa-4 slider" show-arrows>
          <v-slide-item
            v-for="collection in $store.state.collections"
            v-bind:key="collection.collectionId"
            v-slot="{ active, toggle }"
            style="
              background: url(https://cdn.shopify.com/s/files/1/0535/3046/0328/products/MP1455_x250.jpg?v=1614189894);
            "
          >
            <v-card
              :color="active ? 'primary' : 'grey lighten-1'"
              class="ma-4"
              height="250"
              width="200"
              style="border-radius: 10px; overflow: hidden"
              @click="
                toggle;
                setCollectionId(collection.collectionId);
              "
              ><div class="collection-name">
                {{ collection.collectionName }}
              </div>
              <div class="number-comics">
                Comics in Collection:
                <div class="num-of-comics">{{ collection.num_of_comics }}</div>
              </div>
              <v-row class="fill-height" align="center" justify="center">
                <v-scale-transition>
                  <v-icon v-if="active" color="white" size="48"></v-icon>
                </v-scale-transition>
              </v-row>
            </v-card>
          </v-slide-item>
        </v-slide-group>
      </v-sheet>
    </v-container>
    <div class="loading" v-if="isLoading"></div>
    <div class="show-carousel" v-else>
      <carousel v-if="showComicCollection" />
    </div>
  </div>
</template>

<script>
import BannerView from "../components/BannerView.vue";
import SearchBar from "../components/SearchBar.vue";
import Carousel from "../components/Carousel.vue";
import collectionService from "../services/CollectionService";

export default {
  components: { BannerView, SearchBar, Carousel },
  name: "collections",
  data: () => ({
    model: null,
    collection: {
      collectionId: 0,
      collectionName: "",
      num_of_comics: 0,
      isPublic: false,
      userId: 0,
    },
    showComicCollection: false,
    isLoading: true,
  }),
  created() {
    this.retrieveCollections();
  },
  methods: {
    retrieveCollections() {
      collectionService.getCollections().then((response) => {
        this.$store.commit("SET_COLLECTIONS", response.data);

        if (this.$store.state.collections.length > 0) {
          const collectionId = response.data[0].collectionId;
          this.$store.commit("SET_ACTIVE_COLLECTION", collectionId);
        }
        this.isLoading = false;
      });
    },
    setCollectionId(activeCollectionId) {
      this.$store.commit("SET_ACTIVE_COLLECTION", activeCollectionId);
      this.showComicCollection = !this.showComicCollection;
    },
  },
  computed: {},
};
</script>

<style scoped>
v-card {
  text-align: center;
}
.mx-auto {
  background-color: rgba(0, 0, 0, 0);
}

.v-card {
  border-radius: 4px;
  margin: 16px;
  text-align: center;
  font-family: Bangers;
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
}

.v-icon {
  align-items: center;
}
#search {
  display: flex;
  justify-content: flex-end;
  margin: 10px;
}
#bg {
  position: fixed;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  z-index: -1;
}
.collection-name {
  font-size: 40px;
  margin: 75px 5px 0px 5px;
}

.number-comics {
  font-size: 23px;
  padding: 3px;
  margin: 10px 3px 0px 3px;
  color: #f08327;
}

.num-of-comics {
  font-size: 50px;
  color: #f08327;
}
#bg img {
  position: fixed;
  background-size: cover;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  margin-bottom: 0px;
  min-width: 50%;
  min-height: 50%;
  opacity: 80%;
}
</style>