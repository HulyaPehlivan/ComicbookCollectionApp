<template>
  <div class="card">
    <h2 class="title"></h2>
    <img class="image" src="" alt="" />
    <h3 class="publisher"></h3>
    <h3 class="volume"></h3>
    <h3 class="release-date"></h3>
    <p class="description"></p>
    <div class="button-container"></div>
    <button
      class="button"
      v-if="!enableAdd"
      v-on:click.prevent="addToCollection(comic)"
    >
      Add to Collection
    </button>
  </div>
</template>

<script>
export default {
  name: "comic-card",
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
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}
</style>