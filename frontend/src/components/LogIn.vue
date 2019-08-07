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
          >
          </b-form-input>
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
          >
          </b-form-input>
        </b-form-group>
      </form>
      <div slot="modal-footer" class="w-100">
        <b-button variant="primary" @click="handleOk">
          LOGIN
        </b-button>
      </div>
    </b-modal>
  </div>
</template>

<script>
export default {
  name: "LogIn",
  data() {
    return {
       email: '',
       emailState: null,
       passw: '',
       passwordState: null,
    };
  },
  methods: {
    checkFormValidity() {
        const validEmail = this.$refs.emailinput.checkValidity();
        this.emailState = validEmail ? 'valid' : 'invalid';

        const validPassword = this.$refs.passwordinput.checkValidity();
        this.passwordState = validPassword ? 'valid' : 'invalid';

        return validEmail & validPassword;
    },
    resetModal() {
      this.email = '';
      this.emailState = null;
      this.passw = '';
      this.passwordState = null;
    },
    handleOk(bvModalEvt) {
      bvModalEvt.preventDefault()
      this.handleSubmit()
    },
    handleSubmit() {
      if (!this.checkFormValidity()) {
        return;
      }

      this.$nextTick(() => {
        this.$refs.loginModal.hide();
      });
    }
  }
};
</script>