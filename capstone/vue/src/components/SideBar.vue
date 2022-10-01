<template>
  <div class="main">
    <div class="sidenav">
      <router-link class="collections" :to="{ name: 'collections' }"
        >Collections</router-link
      >
      <a href="#">Browse</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "side-bar",
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Bangers");

.sidenav {
  height: 100%;
  width: 160px;
  position: fixed;
  z-index: 1;
  left: 0;
  background-color: #2859b6;
  overflow-x: hidden;
  padding-top: 20px;
}

.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 25px;
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  display: block;
}

.main {
  margin-left: 160px;
  padding: 0px 10px;
}
</style>