<template>
  <div class="main">
    <div class="sidenav">
      <router-link class="collections" :to="{ name: 'collections' }"
        >Collections</router-link
      >
      <button
        class="side-nav-button"
        type="button"
        v-on:click="showAddNewCollection = !showAddNewCollection"
      >
        Add New Collection
      </button>
      <form class="create-collection" v-if="showAddNewCollection === true">
        <label id="label">Create Collection:</label>
        <input
          class="add-field-name"
          type="text"
          placeholder="Collection Name"
          v-model="collection.collectionName"
        />
        <div class="public-checkbox">
          <label for="isPublic" class="add-field"
            >Make collection public?</label
          >
          <input
            type="checkbox"
            class="add-field-checkbox"
            v-model="collection.isPublic"
            @click="isPublic = !isPublic"
          />
        </div>
        <button class="create-collection" type="submit" @click="create()">
          Create Collection
        </button>
      </form>
      <button
        class="side-nav-button"
        type="button"
        v-on:click="showDeleteCollection = !showDeleteCollection"
      >
        Delete Collection
      </button>
      <form class="create-collection" v-if="showDeleteCollection === true">
        <label id="label">Select collection:</label>
        <select name="collections" id="collection" v-model="collection2">
          <option
            v-for="collection in $store.state.collections"
            :key="collection.collectionId"
            :value="collection"
          >
            {{ collection.collectionName }}
          </option>
        </select>
        <button
          class="create-collection"
          type="submit"
          @click="deleteCollection()"
        >
          Delete Collection
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import CollectionService from "../services/CollectionService";
export default {
  name: "side-bar",
  data() {
    return {
      collection: {
        collectionName: "",
        isPublic: false,
      },
      collection2: {
        collectionId: 0,
      },
      showAddNewCollection: false,
      showDeleteCollection: false,
    };
  },
  methods: {
    create() {
      CollectionService.createCollection(this.collection);
    },
    deleteCollection() {
      CollectionService.deleteCollection(this.collection2.collectionId);
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Bangers");

.sidenav {
  height: 100%;
  width: 200px;
  position: fixed;
  z-index: 1;
  left: 0;
  background-color: #2859b6;
  overflow-x: hidden;
  padding-top: 20px;
  display: flex;
  flex-direction: column;
  align-content: center;
}

.sidenav a {
  padding-right: 30px;
  padding-top: 10px;
  padding-left: 20px;
  text-decoration: none;
  font-size: 25px;
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  text-align: center;
}

.main {
  margin-left: 160px;
  padding: 0px 10px;
}

select {
  border: 2px solid black;
  border-radius: 5px;
}

.side-nav-button {
  padding-right: 30px;
  padding-top: 10px;
  padding-left: 20px;

  text-decoration: none;
  font-size: 25px;
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
}

.create-collection {
  text-decoration: none;
  font-size: 20px;
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  width: 90%;
  border: 2px solid black;
  border-radius: 5px;
  background-color: white;
  padding: 5px;
  margin: 5px;
}

.add-field {
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  width: 90%;
  margin: 5px;
}

.add-field-name {
  font-family: Bangers, "Sans-Serif";
  color: #f23c27;
  width: 90%;
  padding: 5px;
  margin: 5px;
  border: 2px solid black;
  border-radius: 5px;
}

::placeholder {
  color: #f23c27;
}

form {
  margin: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.public-checkbox {
  display: flex;
}

.add-field-checkbox {
  width: 25px;
}
</style>