<template>
  <div class="main">
    <div id="nav">
      <router-link class="home" v-bind:to="{ name: 'home' }">Home</router-link>

      <router-link
        class="logout"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <div class="text">
      <h1>Comic Explosion!!!</h1>
      <p>
        Welcome to Comic Explosion, handling all your comic collection needs
        since 2022.
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "banner-view",
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Bangers");
.main {
  background-image: url(https://img.freepik.com/free-vector/comic-abstract-blue-background_225004-669.jpg?w=1380&t=st=1664224100~exp=1664224700~hmac=855867c9c95b6032e68493dde4f29f751c8223329c78453dde951e8258091b60);
  background-size: cover;
  display: flex;
  flex-direction: column;
}
#nav {
  font-size: 25px;
  padding-left: 10px;
  padding-top: 10px;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  align-self: start;
  flex-direction: column;
}
.text {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.main {
  font-family: Bangers, "Sans-Serif";
}

.home {
  justify-content: flex-start;
  padding-right: 25px;
}
a {
  text-decoration: none;
}
a:active {
  color: #f23c27;
}
a:visited {
  color: #f23c27;
}
h1 {
  color: #f23c27;

  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  text-align: center;
  font-size: 65px;
}
p {
  color: #f23c27;
  padding-bottom: 10px;
  font-weight: bold;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  text-align: center;
  font-size: 40px;
}
</style>
