<template>
  <div class="main">
      <banner-view />
    <comics-list />
    <div id="bg">
        <img
          src="https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
          alt=""
        />
      </div>
  </div>
</template>

<script>
import BannerView from '../components/BannerView.vue';
import ComicsList from "../components/ComicList.vue";
export default {
  components: { ComicsList, BannerView },
  name: "comic-search",
};
</script>

<style scoped>
</style>