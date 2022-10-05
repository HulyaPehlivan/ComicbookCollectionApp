<template>
  <div>
    <banner-view />
    <div id="bg">
      <img
        src="https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
        alt=""
      />
    </div>
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
          <label for="username" class="sr-only"></label>
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
          <label for="password" class="sr-only"></label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        <div id="field" class="register">
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
button {
  width: 200px;
  align-self: center;
}
#password {
  margin-bottom: 25px;
}
.register {
  padding-bottom: 10px;
}
h1 {
  margin-top: 10px;
  margin-bottom: 0px;
}
#field {
  margin: 5px 10px 0px;
  font-size: 30px;
}
form {
  display: flex;
  flex-direction: column;
  background: white;
  align-items: center;
  border: 1px solid black;
  margin-left: 700px;
  margin-right: 700px;
  margin-top: 100px;
  padding-top: 10px;
  padding-bottom: 20px;
  border-radius: 5px;
}

#bg {
  position: fixed;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  z-index: -1;
}
#bg img {
  position: fixed;
  background-size: cover;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  margin-bottom: 0px;
  min-width: 50%;
  min-height: 50%;
  opacity: 80%;
}
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
  width: 150px;
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
input {
  font-size: 30px;
  justify-content: center;
  padding-top: 10px;
  padding-bottom: 10px;
  display: flex;
  flex-direction: column;
  border: 2px solid black;
  padding: 5px;
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
</style>