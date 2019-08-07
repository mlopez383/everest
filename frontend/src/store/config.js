import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
      API_LOCATION: 'http://localhost:9000',
  },
});
