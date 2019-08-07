<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <a href="#" v-b-modal.modal-login>Log In</a> |
      <a href="#">Sign Up</a>
    </div>
    <router-view />
    <LogIn />
  </div>
</template>

<script>
import LogIn from "@/components/LogIn.vue";

export default {
  name: "app",
  components: {
    LogIn
  }
};
</script>

<style lang="scss">
#app {
  text-align: center;
}
</style>
