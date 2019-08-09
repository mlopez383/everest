<template>
    <div id="app">
        <div id="nav">
            <router-link to="/">Home</router-link>|
            <router-link to="/about">About</router-link>|
            <a href="#" v-b-modal.modal-login>Log In</a> |
            <a href="#" v-b-modal.modal-signup>Sign Up</a>
        </div>
        <router-view />
        <LogIn />
        <SignUp />
    </div>
</template>

<script>
import LogIn from "@/components/LogIn.vue";
import SignUp from "@/components/SignUp.vue";

export default {
    name: "app",
        components: {
            LogIn,
            SignUp
        }
};
</script>

<style lang="scss">
#app {
    text-align: center;
}
</style>