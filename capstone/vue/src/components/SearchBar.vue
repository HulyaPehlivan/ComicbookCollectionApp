<template>
  <div class="main">
    <form role="search" id="form">
      <input
        type="search"
        id="query"
        name="q"
        placeholder="Search..."
        aria-label="Search through site content"
        v-model="searchInput"
      />
      <button>
        <svg viewBox="0 0 1024 1024">
          <path
            class="path1"
            d="M848.471 928l-263.059-263.059c-48.941 36.706-110.118 55.059-177.412 55.059-171.294 0-312-140.706-312-312s140.706-312 312-312c171.294 0 312 140.706 312 312 0 67.294-24.471 128.471-55.059 177.412l263.059 263.059-79.529 79.529zM189.623 408.078c0 121.364 97.091 218.455 218.455 218.455s218.455-97.091 218.455-218.455c0-121.364-103.159-218.455-218.455-218.455-121.364 0-218.455 97.091-218.455 218.455z"
          ></path>
        </svg>
      </button>
      <select name="i" class="river-search-select" v-model="searchType">
        <option value="Title">Title</option>
        <option value="Story Arc">Story Arc</option>
        <option value="Comic Number">Comic Number</option>
      </select>
    </form>
  </div>
</template>

<script>
export default {
  name: "search-bar",
  data() {
    return {
      searchInput: "",
      searchType: "Title",
    };
  },
};
</script>

<style scoped>
.river-search-select {
  width: 120px;
  height: 27px;
  color: #fff;
  background-color: #f23c27;

  margin-right: 10px;
  margin-left: 10px;
  text-align: center;
  justify-content: center;
  font-size: 12.444px;
  line-height: 20px;
  font: 16px system-ui;
  position: absolute right;
}
form {
  background-color: #f23c27;
  width: 500px;
  height: 44px;
  border-radius: 5px;
  display: flex;
  flex-direction: row;
  align-items: center;
}
input {
  all: unset;
  font: 16px system-ui;
  color: #fff;
  height: 100%;
  width: 100%;
  padding: 6px 10px;
}
::placeholder {
  color: #fff;
  opacity: 0.7;
}
button {
  all: unset;
  cursor: pointer;
  width: 44px;
  height: 44px;
}

svg {
  color: #fff;
  fill: currentColor;
  width: 24px;
  height: 24px;
  padding: 10px;
}
</style>