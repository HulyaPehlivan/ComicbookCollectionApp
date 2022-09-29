<template>
  <div class="home">
    <banner-view id="banner" />
    <body>
      <!-- <carousel id="carousel" /> -->
      <carousel-2 id="carousel" />
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
// import Carousel from "../components/Carousel.vue";
import Carousel2 from '../components/Carousel2.vue';
import SearchBar from "../components/SearchBar.vue";
import SideBar from "../components/SideBar.vue";
export default {
  components: { BannerView, SearchBar, SideBar, Carousel2 },
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
  grid-template-columns: 160px 1fr 1fr;
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
  margin: 5px;
  grid-area: search;
}
</style>
