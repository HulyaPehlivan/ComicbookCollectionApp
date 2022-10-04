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
            style= "background: url(data:image/jpeg;base64,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)"
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
            >
              {{ collection.collectionName }}
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
    <test-carousel v-if="showComicCollection" />
  </div>
</template>

<script>
import BannerView from "../components/BannerView.vue";
import SearchBar from "../components/SearchBar.vue";
import TestCarousel from "../components/TestCarousel.vue";
import collectionService from "../services/CollectionService";

export default {
  components: { BannerView, SearchBar, TestCarousel },
  name: "collections",
  data: () => ({
    model: null,
    collection: {
      collectionId: 0,
      collectionName: "",
      isPublic: false,
      userId: 0,
    },
    showComicCollection: false,
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
      });
    },
    setCollectionId(activeCollectionId) {
      // this.collection.collectionId = this.$store.state.activeCollectionId;
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