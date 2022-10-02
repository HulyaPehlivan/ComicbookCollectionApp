<template>
  <div class="main">
    <banner-view id="banner" />
    <search-bar id="search" />
    <comics-list id="list" />
    <div id="bg">
      <img
        src="https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
        alt=""
      />
    </div>
  </div>
</template>

<script>
import BannerView from "../components/BannerView.vue";
import ComicsList from "../components/ComicList.vue";
import SearchBar from "../components/SearchBar.vue";
export default {
  components: { ComicsList, BannerView, SearchBar },
  name: "comic-search",
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

#banner {
  display: flex;
  align-items: center;
}

#search {
  display: flex;
  justify-content: flex-end;
  margin: 10px;
}

#list {
  margin-top: 20px;
  margin-left: 10px;
}
</style>