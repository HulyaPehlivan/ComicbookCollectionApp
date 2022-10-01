<template>
  <div class="card">
    <div class="cover">
      <comic-cover />
      <!-- <h2 class="title"></h2>
    <h3 class="publisher"></h3>
    <h3 class="volume"></h3>
    <h3 class="release-date"></h3>
    <p class="description"></p> -->
    </div>
  </div>
</template>

<script>
// import ComicDetails from "../components/ComicDetails.vue";
import ComicCover from "../components/ComicCover.vue";
export default {
  name: "comic-card",
  components: {
    ComicCover,
  },
  props: {
    comic: Object,
    enableAdd: {
      type: Boolean,
      default: false,
    },
  },
};
</script>

<style scoped>
.card {
  /* border: 2px solid black;
  border-radius: 10px; */
  width: auto;
  height: auto;
  margin: 13px;
}

</style>