<template>
  <div class="home">
    <banner-view />
    <search-bar />
  </div>
</template>

<script>
import BannerView from "../components/BannerView.vue";
import SearchBar from "../components/SearchBar.vue";
export default {
  components: { BannerView, SearchBar },
  name: "home",
};
</script>
<style scoped>
</style>
