<template>
    <div>
        <b-modal
            id="modal-signup"
            ref="signupModal"
            title="Sign Up"
            @show="resetModal"
            @hidden="resetModal"
        >
        <form @submit.stop.prevent="handleSubmit">
            <b-form-group
                :state="fullnameState"
                label="Name"
                label-for="fullname-input"
                invalid-feedback="Name is required"
            >
                <b-form-input
                    id="fullname-input"
                    ref="fullnameinput"
                    v-model="fullname"
                    :state="fullnameState"
                    required
                ></b-form-input>
            </b-form-group>
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
                    v-model="pass_word"
                    :state="passwordState"
                    required
                ></b-form-input>
            </b-form-group>
            <b-form-group
                :state="password2State"
                label="Password Again"
                label-for="password2-input"
                invalid-feedback="Password is required Again"
            >
                <b-form-input
                    id="password2-input"
                    ref="password2input"
                    v-model="pass_word2"
                    :state="password2State"
                    required
                ></b-form-input>
            </b-form-group>
        </form>
        <div slot="modal-footer" class="w-100">
            <b-button variant="primary" @click="handleOk">SIGN UP</b-button>
        </div>
        </b-modal>
    </div>
</template>

<script>
import axios from "axios";
import store from "../store/config";
export default {
    name: "SignUp",
    data() {
        return {
            fullname: "",
            fullnameState: null,
            email: "",
            emailState: null,
            pass_word: "",
            passwordState: null,
            pass_word2: "",
            password2State: null
        };
    },
    methods: {
        checkFormValidity() {
            const validName = this.$refs.fullnameinput.checkValidity();
            this.fullnameState = validName ? "valid" : "invalid";

            const validEmail = this.$refs.emailinput.checkValidity();
            this.emailState = validEmail ? "valid" : "invalid";

            const validPassword = this.$refs.passwordinput.checkValidity();
            this.passwordState = validPassword ? "valid" : "invalid";

            const validPassword2 = this.$refs.password2input.checkValidity();
            this.password2State = validPassword2 ? "valid" : "invalid";

            return validName & validEmail & validPassword & validPassword2;
        },
        resetModal() {
            this.fullname = "";
            this.fullnameState = null;
            this.email = "";
            this.emailState = null;
            this.pass_word = "";
            this.passwordState = null;
            this.pass_word2 = "";
            this.password2State = null;
        },
        handleOk(bvModalEvt) {
            bvModalEvt.preventDefault();
            this.handleSubmit();
        },
        handleSubmit() {
            if (!this.checkFormValidity()) {
                return;
            }

            this.$nextTick(() => {
                axios
                    .post(store.state.API_LOCATION + "/user/signup/", {
                        fullname: this.fullname,
                        email: this.email,
                        upassword: this.pass_word,
                    })
                    .then((response) => (this.evaluateSignUp(response)))
                    .catch((e) => (console.log("POST /user/signup cannot be accessed")));
            });
        },
        evaluateSignUp(response) {
            if (response.data.result == "success") {
                this.$refs.signupModal.hide();
            }else{
                console.log("FAILED SIGN UP");
            }
        }
    }
};
</script>