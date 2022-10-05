<template>
  <div class="home">
    <banner-view id="banner" />
    <body>
      <h3>My Collection</h3>
      <div class="loading" v-if="isLoading"></div>
      <carousel id="carousel" v-else />

      <search-bar id="search" />
      <side-bar id="navbar" />
      <div id="bg">
        <img
          src="https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
          alt=""
        />
      </div>
    </body>
  </div>
</template>

<script>
import BannerView from "../components/BannerView.vue";
import Carousel from "../components/Carousel.vue";
import SearchBar from "../components/SearchBar.vue";
import SideBar from "../components/SideBar.vue";

import collectionService from "../services/CollectionService";

export default {
  components: { BannerView, SearchBar, SideBar, Carousel },
  name: "home",
  data() {
    return {
      volumes: [],
      isLoading: true,
    };
  },
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
  },
};
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css?family=Bangers");
#bg {
  position: fixed;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  z-index: -1;
}

h3 {
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  text-align: left;
  margin-top: 30px;
  margin-left: 15px;
  font-size: 40px;
  font-family: Bangers, sans-serif;
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
.home {
  display: flex;
  flex-direction: column;
}
#banner {
  display: flex;
  align-items: center;
}

body {
  display: grid;
  grid-template-columns: 200px 1fr 1fr;
  gap: 10px;
  grid-template-areas:
    "navbar . search"
    "navbar carousel carousel";
}

#carousel {
  grid-area: carousel;
}
#navbar {
  grid-area: navbar;
}

#search {
  justify-self: right;
  margin: 10px;
  grid-area: search;
}
</style>
