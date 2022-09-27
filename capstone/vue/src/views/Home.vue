<template>
  <div class="home">
    <h1>Comic Explosion!!!</h1>
    <p>
      Welcome to Comic Explosion, handling all your comic collection needs since
      2022.
    </p>
    <div class="collection-list">
      <p>View a Collection!</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
<style scoped>
h1 {
  color: #f23c27;

  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  text-align: center;
  font-size: 50px;
}
p {
  color: #f23c27;
  padding-bottom: 30px;
  font-weight: bold;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  text-align: center;
  font-size: 35px;
}
</style>
