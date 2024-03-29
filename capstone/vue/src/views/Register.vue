<template>
  <div>
    <banner-view />
    <div id="bg">
      <img
        src="https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
        alt=""
      />
    </div>
    <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
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
          <!-- <p>*password must contain at least one uppercase letter, </p>
           <p> one lowercase letter and one number</p> -->
        </div>
        <div id="field">
          <label for="confirm" class="sr-only"></label>
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
          <label for="isPremium" class="sr-only">Become a Premium User?</label>
          <input
            type="checkbox"
            id="isPremium"
            class="form-control"
            v-model="user.isPremium"
            v-on:click="
              isPremium = !isPremium;
              showCCInfo = !showCCInfo;
            "
          />
          <p>With a premium account, you can have collections</p>
            <p> saved with over 100 comics!</p>
          <br />

          <form v-if="showCCInfo === true">
            <label for="CCInfo" id="label">Credit Card Information:</label>
            <input type="text" placeholder="Credit Card Number" />
            <label for="CCInfo"></label>
            <input type="text" placeholder="Expiration Date mm/yy" />
            <label for="CCInfo"></label>
            <input type="text" placeholder="Security Code" />
            <label for="CCInfo"></label>
            <input type="text" placeholder="Zip Code" />
          </form>
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
        isPremium: false,
      },
      showCCInfo: false,
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  computed: {
    pwLength() {
      return this.user.password.length;
    },
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else if (
        !this.user.password.match(
          "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"
        )
      ) {
        this.registrationErrors = true;
        this.registrationErrorMsg =
          "Password must contain at least: eight characters, one uppercase letter, one lowercase letter and one number";
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

#have-acct {
  font-size: 25px;
}
input {
  font-size: 30px;
  border: 1px solid black;
  margin-left: 10px;
  margin-right: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
}
form {
  display: flex;
  flex-direction: column;
  background: white;
  align-items: center;
  border: 1px solid black;
  margin-left: 700px;
  margin-right: 700px;
  margin-top: 50px;
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
  font-size: 30px;
  display: inline-block;
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
