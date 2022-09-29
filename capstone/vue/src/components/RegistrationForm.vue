<template>
  <v-app>
    <v-form>
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <v-text-field
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      >
      </v-text-field>
      <v-text-field
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        :rules="passwordRules"
        required
      ></v-text-field>
      <v-text-field
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        :rules="confirmPasswordRules"
        required
      ></v-text-field>
      <div id="field">
        <label for="isPremium" class="sr-only">Become a Premium User?</label>
        <input
          type="checkbox"
          id="isPremium"
          class="form-control"
          v-model="user.isPremium"
          v-on:click="isPremium = !isPremium"
        />
      </div>

      <div id="have-acct">
        <router-link :to="{ name: 'login' }"
          >Have an Account Already?</router-link
        >
      </div>
      <v-btn flat class="success mx-0 mt-3" @click.prevent="register">
        Create Account
      </v-btn>
    </v-form>
  </v-app>
</template>

<script>
import authService from "../services/AuthService";
export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
        isPremium: false,
        passwordRules: [
          (v) => v.length >= 8 || "Minimum length is 8 characters",
        ],
        confirmPasswordRules: [
          (value) => !!value || "type confirm password",
          (value) =>
            value === this.password ||
            "The password confirmation does not match.",
        ],
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
  },
  clearErrors() {
    this.registrationErrors = false;
    this.registrationErrorMsg = "There were problems registering this user.";
  },
};
</script>

<style>
</style>