<template>
  <div class="main">
    <div class="sidenav">
      <router-link class="collections" :to="{ name: 'collections' }"
        >Collections</router-link
      >

      <div id="field">
        <label for="addCollection" class="sr-only">Add a Collection?</label>
        <input
          type="checkbox"
          id="addCollection"
          class="form-control"
          v-model="showAddCollection"
          v-on:click="showAddCollection = !showAddCollection"
        />
        <br />

        <form v-if="showAddCollection === true">
          <label for="CCInfo" id="label">Create Collection:</label>
          <input
            type="text"
            placeholder="Collection Name"
            v-model="collection.collectionName"
          />
          <input type="text" placeholder="Public or Private?" />
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "side-bar",
  data() {
    return {
      collection: {
        collectionId: 0,
        collectionName: "",
        isPublic: false,
        userId: 0,
      },
      showAddCollection: false,
    };
  },
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