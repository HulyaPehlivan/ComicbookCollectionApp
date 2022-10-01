<template>
  <div class="main">
    <div class="banner">
      <banner-view />
    </div>
    <div class="card">
      <comic-card class="comic-card" />
      <comic-details class="comic-details" />
    </div>

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
import ComicCard from "../components/ComicCard.vue";
import ComicDetails from "../components/ComicDetails.vue";
export default {
  name: "comic",
  components: { BannerView, ComicCard, ComicDetails },
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


.card {
  display: grid;
  grid-template-columns: .5fr 2fr;
  gap: 10px;
  grid-template-areas:
    "cover details"
    "cover details"
    
}

.comic-card {
  grid-area: cover;
}

.comic-details {
  grid-area: details;
}
</style>