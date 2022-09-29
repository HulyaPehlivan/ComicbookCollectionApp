<template>
  <div class="home">
    <banner-view id="banner" />
    <body>
      <search-bar id="search" />
      <side-bar id="navbar" />
      <carousel id="carousel" />
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
export default {
  components: { BannerView, SearchBar, SideBar, Carousel },
  name: "home",
};
</script>
<style scoped>
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
  grid-template-columns: 1fr 1fr 1fr;
  gap: 50px;
  grid-template-areas:
    "navbar carousel search"
    "navbar carousel search";
}
#carousel {
  grid-area: carousel;
}
#navbar {
  grid-area: navbar;
}
#search {
  justify-self: right;
  grid-area: search;
}
</style>
