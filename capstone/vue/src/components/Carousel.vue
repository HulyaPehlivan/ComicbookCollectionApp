<template>
  <div>
    <v-app>
      <v-carousel id="carousel">
        <v-carousel-item>Item 1</v-carousel-item>
        <v-carousel-item>Item 2</v-carousel-item>
        <v-carousel-item>Item 3</v-carousel-item>
        <v-carousel-item>Item 4</v-carousel-item>
      </v-carousel>
    </v-app>
  </div>
</template>

<script>
export default {
  name: "carousel-view",
};
</script>

<style scoped>
div {
  height: 100% !important;
  width: 100%;
}
#carousel {
  height: 84% !important;
}
</style>