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
                :state="nameState"
                label="Name"
                label-for="name-input"
                invalid-feedback="Name is required"
            >
                <b-form-input
                    id="name-input"
                    ref="nameinput"
                    v-model="name" 
                    :state="nameState"
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
                    v-model="passw"
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
                    v-model="passw2"
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
import store from "../store/config";
export default {
    name: "SignUp",
    data() {
        return {
            name: "",
            nameState: null,
            email: "",
            emailState: null,
            passw: "",
            passwordState: null,
            passw2: "",
            password2State: null
        };
    },
    methods: {
        checkFormValidity() {
            const validName = this.$refs.nameinput.checkValidity();
            this.nameState = validName ? "valid" : "invalid";

            const validEmail = this.$refs.emailinput.checkValidity();
            this.emailState = validEmail ? "valid" : "invalid";

            const validPassword = this.$refs.passwordinput.checkValidity();
            this.passwordState = validPassword ? "valid" : "invalid";

            const validPassword2 = this.$refs.password2input.checkValidity();
            this.password2State = validPassword2 ? "valid" : "invalid";

            return validName & validEmail & validPassword & validPassword2;
        },
        resetModal() {
            this.name = "";
            this.nameState = null;
            this.email = "";
            this.emailState = null;
            this.passw = "";
            this.passwordState = null;
            this.passw2 = "";
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
                this.$refs.signupModal.hide();
            });
        },
        saveUser() {
            /*TODO: implement this*/
            console.log(store.state.API_LOCATION);
        }
    }
};
</script>