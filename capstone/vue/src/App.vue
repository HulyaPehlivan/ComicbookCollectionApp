<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>
<style scoped>
#app {
  background-image: url(https://img.freepik.com/free-vector/comic-abstract-blue-background_225004-669.jpg?w=1380&t=st=1664224100~exp=1664224700~hmac=855867c9c95b6032e68493dde4f29f751c8223329c78453dde951e8258091b60);
  background-size: cover;
}
#nav {
  font-size: 25px;
  padding-left: 10px;
  font-weight: bold;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
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
</style>
