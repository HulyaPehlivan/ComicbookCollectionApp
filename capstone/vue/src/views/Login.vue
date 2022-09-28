<template>
  <div>
    <banner-view />
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <div id="field">
          <label for="username" class="sr-only">Username: </label>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <div id="field">
          <label for="password" class="sr-only">Password: </label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        <div id="field">
          <router-link :to="{ name: 'register' }">Need an account?</router-link>
        </div>
        <div></div>
        <button type="submit">Sign in</button>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import BannerView from "../components/BannerView.vue";
export default {
  name: "login",
  components: { BannerView },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
#login {
  text-align: center;
  font-family: Bangers, "Sans-serif";
  color: #f23c27;
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
}

label {
  text-shadow: -1px -1px 0 white, 1px -1px 0 white, -1px 1px 0 white,
    1px 1px 0 white;
  font-size: 20px;
  display: inline-block;
  /* width: 150px; */
  text-align: right;
  margin-right: 10px;
}

button {
  font-family: Bangers, "Sans-serif";
  color: white;
  background-color: #f23c27;
  border: none;
  border-radius: 3px;
  padding: 5px 10px;
  font-size: 16px;
}

a:active {
  color: #f23c27;
}
a:visited {
  color: #f23c27;
}
a {
  text-decoration: none;
}

.form-section {
  padding: 5px;
}

#field-section {
  border: 2px solid black;
  padding: 5px;
}

#field-section .form-control {
  margin: 10px;
}

#field {
  margin: 10px 10px 10px;
}
</style>