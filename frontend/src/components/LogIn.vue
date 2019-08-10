<template>
    <div>
        <b-modal
            id="modal-login"
            ref="loginModal"
            title="Log In"
            @show="resetModal"
            @hidden="resetModal"
        >
            <form @submit.stop.prevent="handleSubmit">
                <b-form-group
                    :state="emailState"
                    label="E-mail"
                    label-for="email-input"
                    invalid-feedback="E-mail is required"
                >
                    <b-form-input
                        id="email-input"
                        ref="emailinput"
                        v-model="email"
                        :state="emailState"
                        required
                    ></b-form-input>
                </b-form-group>
                <b-form-group
                    :state="passwordState"
                    label="Password"
                    label-for="password-input"
                    invalid-feedback="Password is required"
                >
                    <b-form-input
                        id="password-input"
                        ref="passwordinput"
                        v-model="passw"
                        :state="passwordState"
                        required
                    ></b-form-input>
                </b-form-group>
            </form>
            <b-alert v-bind:class="{hideElement:hideMessageError}" show variant="danger">The account you've entered doesn't match any account.</b-alert>
            <div slot="modal-footer" class="w-100">
                <b-button variant="primary" @click="handleOk">LOGIN</b-button>
            </div>
        </b-modal>
    </div>
</template>

<script>
import axios from "axios";
import store from "../store/config";
export default {
    name: "LogIn",
    data() {
        return {
            email: "",
            emailState: null,
            passw: "",
            passwordState: null,
            hideMessageError: true,
        };
    },
    methods: {
        checkFormValidity() {
            const validEmail = this.$refs.emailinput.checkValidity();
            this.emailState = validEmail ? "valid" : "invalid";

            const validPassword = this.$refs.passwordinput.checkValidity();
            this.passwordState = validPassword ? "valid" : "invalid";

            return validEmail & validPassword;
        },
        resetModal() {
            this.email = "";
            this.emailState = null;
            this.passw = "";
            this.passwordState = null;
            this.hideMessageError = true;
        },
        handleOk(bvModalEvt) {
            bvModalEvt.preventDefault();
            this.handleSubmit();
        },
        handleSubmit() {
            this.hideMessageError = true;
            if (!this.checkFormValidity()) {
                return;
            }

            this.$nextTick(() => {
                axios
                    .get(store.state.API_LOCATION + "/user/login/" + this.email + "/" + this.passw)
                    .then((response) => (this.evaluateLogin(response)))
                    .catch((e) => (console.log("GET /user/login cannot be accessed")));
            });
        },
        evaluateLogin(response) {
            if (response.data.result == "success") {
                this.$refs.loginModal.hide();
            }else{
                this.hideMessageError = false;
                this.emailState = null;
                this.passwordState = null;
            }
        },
    }
};
</script>