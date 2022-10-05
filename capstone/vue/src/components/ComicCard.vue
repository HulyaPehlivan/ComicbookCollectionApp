<template>
  <div class="card">
    <div class="cover">
      <comic-cover />
    </div>
  </div>
</template>

<script>
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
  width: auto;
  height: auto;
  margin: 13px;
}
</style>