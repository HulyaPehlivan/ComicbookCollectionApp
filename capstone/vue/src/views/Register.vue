<template>
  <div>
    <banner-view />
    <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
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
          <label for="confirm" class="sr-only">Confirm: </label>
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
        </div>
        <div id="field">
          <label for="add-premium" class="sr-only"
            >Become a Premium User?</label
          >
          <input type="checkbox" />
        </div>

        <div id="have-acct">
          <router-link :to="{ name: 'login' }"
            >Have an Account Already?</router-link
          >
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Create Account
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import BannerView from "../components/BannerView.vue";
import authService from "../services/AuthService";

export default {
  components: { BannerView },
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Bangers");
#register {
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
  padding: 5px 0;
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

#have-acct {
  margin: 10px 10px 10px;
}
</style>
