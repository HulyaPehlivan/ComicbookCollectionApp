<template>
  <div class="home">
    <banner-view id="banner" />
    <body>
      <search-bar id="search" />
      <side-bar id="navbar" />
    </body>
  </div>
</template>

<script>
import BannerView from "../components/BannerView.vue";
import SearchBar from "../components/SearchBar.vue";
import SideBar from "../components/SideBar.vue";
export default {
  components: { BannerView, SearchBar, SideBar },
  name: "home",
};
</script>
<style scoped>
.home {
  display: flex;
  flex-direction: column;
}
#banner {
  display: flex;
  align-items: center;
}
#search {
  justify-self: right;
}
body {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 50px;
  grid-template-areas:
    "navbar . search"
    "navbar . search";
}
#navbar {
  grid-area: navbar;
}
#search {
  grid-area: search;
}
</style>
